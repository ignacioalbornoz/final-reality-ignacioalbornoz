package com.github.ignacioalbornoz.finalreality.controller;

import com.github.ignacioalbornoz.finalreality.controller.gamephases.*;
import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import com.github.ignacioalbornoz.finalreality.listeners.PlayerCharacterDeathListener;
import com.github.ignacioalbornoz.finalreality.listeners.EnemyDeathListener;
import com.github.ignacioalbornoz.finalreality.listeners.PlayerCharacterAllDeadListener;
import com.github.ignacioalbornoz.finalreality.listeners.EnemyAllDeadListener;
import org.jetbrains.annotations.Unmodifiable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FinalRealityController {

    private final Map<String, IPlayerCharacter> initialPlayerCharacterList;
    private final Map<String, IEnemy> initialEnemyList;
    private final Map<String, IWeapon> weaponList;
    private final Map<String,String> charactersEquippedList;


    private final Map<String,IEnemy> aliveEnemyList;
    private final Map<String,IPlayerCharacter> alivePlayerCharacterList;


    private final BlockingQueue<ICharacter> controllerTurnsQueue;


    private final PropertyChangeSupport PlayerCharacterAllDeadNotification = new PropertyChangeSupport(this);
    private final PropertyChangeSupport EnemyAllDeadNotification = new PropertyChangeSupport(this);
    private final PropertyChangeListener PlayerCharacterDeathListener = new PlayerCharacterDeathListener(this);
    private final PropertyChangeListener EnemyDeathListener = new EnemyDeathListener(this);
    private final PropertyChangeListener EnemyAllDeadListener = new EnemyAllDeadListener(this);
    private final PropertyChangeListener PlayerCharacterAllDeadListener = new PlayerCharacterAllDeadListener(this);


    private Boolean gameOver;
    private Boolean gameStarted;

    private ICharacter characterInTurn;

    private String enemySelected;
    private int numberOfEnemySelected;

    private String weaponSelected;
    private int numberOfWeaponSelected;

    private String characterSelected;
    private int numberOfCharacterSelected;

    private IGamePhase gamePhase;

    public FinalRealityController() {
        initialPlayerCharacterList = new HashMap<>();
        weaponList = new HashMap<>();
        initialEnemyList = new HashMap<>();
        charactersEquippedList = new HashMap<>();
        controllerTurnsQueue = new LinkedBlockingQueue<>();
        characterInTurn = null;
        aliveEnemyList = new HashMap<>();
        alivePlayerCharacterList = new HashMap<>();
        gameOver = false;
        gameStarted = false;
        setGamePhase(new PreGameStartedPhase());
        enemySelected = "Select an enemy";
        numberOfEnemySelected = 1;

    }


    private List<String> getSortedListAliveEnemy() {
        List<String> list = new ArrayList<String>(this.getCopyOfSetOfAliveEnemyCharacters());
        Collections.sort(list);
        return list;
    }

    public void setPreviousEnemy() {
        List<String> list = getSortedListAliveEnemy();
        var i = numberOfEnemySelected;
        if (i>0){
            i = i-1;
            enemySelected = list.get(i);
            numberOfEnemySelected = i;}
    }

    public void setNextEnemy() {
        List<String> list = getSortedListAliveEnemy();
        var i = numberOfEnemySelected;
        if (i <list.size()-1){
            i = i+1;
            enemySelected = list.get(i);
            numberOfEnemySelected = i;}
    }

    public String getEnemySelected() {
        return this.enemySelected;
    }

    private void setTrueGameStarted(){
        this.gameStarted = true; }

    private void actionIfHeadEnemy(IEnemy enemy){
        enemyRandomTarget(enemy);
        if (!this.getGameOver()){
            this.setGamePhase(new SecondPhase());
        }
    }


    private void enemyRandomTarget(IEnemy enemy){
        Map.Entry<String,IPlayerCharacter> entry = alivePlayerCharacterList.entrySet().iterator().next();
        IPlayerCharacter value = entry.getValue();
        controllerAttack(enemy,value);
    }




    public Map<String,ICharacter> cloneAndShuffleMap(Map<String, IPlayerCharacter> map, Map<String, IEnemy> mapTwo){

        var myObjectListA = new HashMap<String,ICharacter>(map);

        var myObjectListB = new HashMap<String,ICharacter>(mapTwo);

        myObjectListA.putAll(myObjectListB);


        List<String> list = new ArrayList<>(myObjectListA.keySet());
        Collections.shuffle(list);

        Map<String, ICharacter> shuffleMap = new LinkedHashMap<>();
        list.forEach(k->shuffleMap.put(k, myObjectListA.get(k)));

        return shuffleMap;
    }



    private void waitTurnShuffleMap(Map<String,ICharacter> shuffleMap){
        for (Map.Entry<String,ICharacter> me : shuffleMap.entrySet()) {
           controllerWaitTurn(me.getValue());}
    }


    public void controllerTurns(){
        var shuffleMap = cloneAndShuffleMap(this.alivePlayerCharacterList,this.aliveEnemyList);
        waitTurnShuffleMap(shuffleMap);
        this.subscribeToPlayerCharacterAllDeadNotification();
        this.subscribeToEnemyAllDeadNotification();
    }




    private void controllerWaitTurn(ICharacter character){
        character.waitTurn();
    }



    public BlockingQueue<ICharacter> getControllerTurnsQueue() {
        return controllerTurnsQueue;
    }






    public ICharacter getCharacterInTurn() {
        return characterInTurn;
    }

    public String getNameOfCharacterInTurn() {
        return characterInTurn.getName();
    }


    public void setGamePhase(IGamePhase gamePhase) {
        this.gamePhase = gamePhase;
        gamePhase.setController(this);
    }


    public IGamePhase getGamePhase() {
        return gamePhase;
    }


    private void gameOver() {
        setGamePhase(new GameOverPhase());
        this.gameOver = true;
    }


    public void gameStarted() {
        this.setTrueGameStarted();
        this.controllerTurns();
        setGamePhase(new FirstPhase());
    }


    public void turnStarts(){
        waitForScheduledExecutor();
        characterInTurn = controllerTurnsQueue.peek();
        ICharacter characterInTurn = getCharacterInTurn();
        if (isInAliveEnemyList(characterInTurn)){
            actionIfHeadEnemy((IEnemy) characterInTurn);
        }
        else if(isInAlivePlayerCharacterList(characterInTurn)){
            setGamePhase(new SelectingAttackTargetPhase());
        }else{
            turnEnds();
        }


    }

    private void waitForScheduledExecutor(){
        while (this.getControllerTurnsQueue().peek()==null){
        }
    }

    public void turnEnds(){
        var character = controllerTurnsQueue.poll();
        characterInTurn = null;
        if (character !=null){
            if (isAlive(character)){
                this.controllerWaitTurn(character);}
        }
        this.setGamePhase(new FirstPhase());
    }

    private boolean isAlive(ICharacter character){
        return isInAliveEnemyList(character) || isInAlivePlayerCharacterList(character);
    }

    public void doPhaseAction() throws InvalidTransitionException {
        this.getGamePhase().doPhaseAction();
    }

    private void subscribeToPlayerCharacterAllDeadNotification() {
        this.addPlayerCharacterAllDeadListener(PlayerCharacterAllDeadListener);
    }
    private void unsubscribeToPlayerCharacterAllDeadNotification() {
        this.removePlayerCharacterAllDeadListener(PlayerCharacterAllDeadListener);
    }
    private void subscribeToEnemyAllDeadNotification() {
        this.addEnemyAllDeadListener(EnemyAllDeadListener);
    }

    private void unsubscribeToEnemyAllDeadNotification() {
        this.removeEnemyAllDeadListener(EnemyAllDeadListener);
    }


    private void addPlayerCharacterAllDeadListener(PropertyChangeListener listener) {
        this.PlayerCharacterAllDeadNotification.addPropertyChangeListener(listener);
    }
    private void removePlayerCharacterAllDeadListener(PropertyChangeListener listener) {
        this.PlayerCharacterAllDeadNotification.removePropertyChangeListener(listener);
    }

    private void addEnemyAllDeadListener(PropertyChangeListener listener) {
        this.EnemyAllDeadNotification.addPropertyChangeListener(listener);
    }

    private void removeEnemyAllDeadListener(PropertyChangeListener listener) {
        this.EnemyAllDeadNotification.removePropertyChangeListener(listener);

    }


    private PropertyChangeSupport getPlayerCharacterAllDeadNotification() {
        return PlayerCharacterAllDeadNotification;
    }

    private PropertyChangeSupport getEnemyAllDeadNotification() {
        return EnemyAllDeadNotification;
    }




    private void firePlayerCharacterAllDeadEvent() {
        PlayerCharacterAllDeadNotification.firePropertyChange(new PropertyChangeEvent(this,
                "You lost the game", null,null));}

    private void fireEnemyAllDeadEvent() {
        EnemyAllDeadNotification.firePropertyChange(new PropertyChangeEvent(this,
                "You won the game", null,null));}





    private void subscribeToPlayerCharacterDeathNotification(IPlayerCharacter playerCharacter) {
        playerCharacter.addPlayerCharacterDeathListener(PlayerCharacterDeathListener);
    }

    private void unsubscribeToPlayerCharacterDeathNotification(IPlayerCharacter playerCharacter) {
        playerCharacter.removePlayerCharacterDeathListener(PlayerCharacterDeathListener);
    }

    private void subscribeToEnemyDeathNotification(IEnemy enemy) {
        enemy.addEnemyDeathListener(EnemyDeathListener);
    }

    private void unsubscribeToEnemyDeathNotification(IEnemy enemy) {
        enemy.removeEnemyDeathListener(EnemyDeathListener);
    }


    public void createBlackMage(@NotNull String name){
        IPlayerCharacter newCharacter = new BlackMage(controllerTurnsQueue, name);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
    }

    public void createEngineer(@NotNull String name){
        IPlayerCharacter newCharacter = new Engineer(controllerTurnsQueue, name);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
    }
    public void createKnight(@NotNull String name){
        IPlayerCharacter newCharacter = new Knight(controllerTurnsQueue, name);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
    }
    public void createThief(@NotNull String name){
        IPlayerCharacter newCharacter = new Thief(controllerTurnsQueue, name);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
    }
    public void createWhiteMage(@NotNull String name){
        IPlayerCharacter newCharacter = new WhiteMage(controllerTurnsQueue, name);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
    }

    public void createEnemy(@NotNull String name, int weight){
        IEnemy newEnemy = new Enemy(controllerTurnsQueue,name,weight);
        subscribeToEnemyDeathNotification(newEnemy);
        aliveEnemyList.put(newEnemy.getName(),newEnemy);
    }


    public void weaponCreateAxe(@NotNull String name, int weight, int damage){
        IWeapon newWeapon = new Axe(name,weight,damage);
        weaponList.put(newWeapon.getName(),newWeapon);
    }
    public void weaponCreateBow(@NotNull String name, int weight, int damage){
        IWeapon newWeapon = new Bow(name,weight,damage);
        weaponList.put(newWeapon.getName(),newWeapon);
    }
    public void weaponCreateKnife(@NotNull String name, int weight, int damage){
        IWeapon newWeapon = new Knife(name,weight,damage);
        weaponList.put(newWeapon.getName(),newWeapon);
    }
    public void weaponCreateStaff(@NotNull String name, int weight, int damage){
        IWeapon newWeapon = new Staff(name,weight,damage);
        weaponList.put(newWeapon.getName(),newWeapon);
    }
    public void weaponCreateSword(@NotNull String name, int weight, int damage){
        IWeapon newWeapon = new Sword(name,weight,damage);
        weaponList.put(newWeapon.getName(),newWeapon);
    }
    public IPlayerCharacter getPlayerCharacterFromInitialList(String namePlayerCharacter){
        return initialPlayerCharacterList.get(namePlayerCharacter);
    }

    public IEnemy getEnemyFromInitialList(String nameEnemy){
        return initialEnemyList.get(nameEnemy);
    }

    public IWeapon getWeaponFromList(String nameWeapon) {
        return weaponList.get(nameWeapon);
    }

    public IPlayerCharacter getAlivePlayerCharacter(String nameCharacter){
        return alivePlayerCharacterList.get(nameCharacter);
    }

    public IEnemy getAliveEnemy(String nameEnemy){
        return aliveEnemyList.get(nameEnemy);
    }


    public Collection<IPlayerCharacter> getCollectionOfPlayerCharacters(){
        return initialPlayerCharacterList.values();
    }


    public @Unmodifiable Set<String> getCopyOfSetOfPlayerCharacterNames(){
        return new HashSet<>(initialPlayerCharacterList.keySet());
    }

    public Collection<IEnemy> getCollectionOfEnemy(){
        return initialEnemyList.values();
    }

    public @Unmodifiable Set<String> getCopyOfSetOfEnemyNames(){
        return new HashSet<>(initialEnemyList.keySet());
    }

    public Collection<IWeapon> getCollectionOfWeapon(){
        return weaponList.values();
    }

    public Set<String> getSetOfWeaponNames(){
        return weaponList.keySet();
    }

    public Collection<String> getCollectionOfEquippedWeapons(){
        return charactersEquippedList.values();
    }

    public Set<String> getSetOfPlayerCharacterEquippedNames(){
        return charactersEquippedList.keySet();
    }


    public @Unmodifiable Set<String> getCopyOfSetOfAliveEnemyCharacters() {
        return new HashSet<>(aliveEnemyList.keySet());
    }

    public @Unmodifiable Set<String> getCopyOfSetOfAlivePlayerCharacters() {
        return new HashSet<>(alivePlayerCharacterList.keySet());
    }

    public void equipController(IPlayerCharacter playerCharacter, IWeapon weapon){
        if (playerCharacter.getEquippedWeapon().isNull()){
            playerCharacter.equip(weapon);
            charactersEquippedList.put(playerCharacter.getName(),weapon.getName());}
    }

    public void unEquipController(IPlayerCharacter playerCharacter){
        if (!playerCharacter.getEquippedWeapon().isNull()){
            playerCharacter.equip(new WeaponNull());
            charactersEquippedList.remove(playerCharacter.getName());}
    }


    public IWeapon getEquippedWeaponController(IPlayerCharacter playerCharacter) {
        return playerCharacter.getEquippedWeapon();
    }

    public String getNameControllerCharacter(ICharacter character) {
        return character.getName();
    }

    public String getNameControllerWeapon(IWeapon weapon) {
        return weapon.getName();
    }

    public String getControllerCharacterClass(ICharacter character) {
        return character.getCharacterClass();
    }

    public String getControllerWeaponType(IWeapon weapon) {
        return weapon.getType();
    }

    public boolean controllerCanContinue(ICharacter character) {
        return character.getCanContinue();
    }

    public int controllerGetHP(ICharacter character) {
        return character.getHP();
    }

    public int controllerGetWeight(IEnemy enemy) {
        return enemy.getWeight();
    }

    public int controllerGetDamage(IEnemy enemy) {
        return enemy.getDamage();
    }

    public int controllerGetWeaponWeight(IWeapon weapon) {
        return weapon.getWeight();
    }
    public int controllerGetWeaponDamage(IWeapon weapon) {
        return weapon.getDamage();
    }

    public boolean controllerGetWeaponIsNull(IWeapon weapon) {
        return weapon.isNull();
    }

    public void controllerAttack(ICharacter character, ICharacter characterAttacked){
        character.attack(characterAttacked);
    }

    public boolean isInParty(IPlayerCharacter character){
        return initialPlayerCharacterList.containsValue(character);
    }

    public boolean isInEnemyList(IEnemy enemy){
        return initialEnemyList.containsValue(enemy);
    }

    public boolean isInWeaponList(IWeapon weapon){
        return weaponList.containsValue(weapon);
    }

    public boolean isWeaponInCharactersEquipped(String weaponName){
        return charactersEquippedList.containsValue(weaponName);
    }

    public boolean isCharacterInCharactersEquipped(String characterName){
        return charactersEquippedList.containsKey(characterName);
    }


    public boolean isNamePlayerCharacterDisponible(String name){
        return !initialPlayerCharacterList.containsKey(name);
    }

    public boolean isNameEnemyDisponible(String name){
        return !initialEnemyList.containsKey(name);
    }

    public boolean isNameWeaponDisponible(String name){
        return !weaponList.containsKey(name);
    }


    public void deletePlayerCharacterFromInitialList(String playerCharacterName){
        unsubscribeToPlayerCharacterDeathNotification(initialPlayerCharacterList.get(playerCharacterName));
        initialPlayerCharacterList.remove(playerCharacterName);
    }

    public void deleteEnemyFromInitialList(String enemyName){
        unsubscribeToEnemyDeathNotification(initialEnemyList.get(enemyName));
        initialEnemyList.remove(enemyName);
    }

    public void deleteWeapon(String weaponName){
        if (!(isWeaponInCharactersEquipped(weaponName))) {weaponList.remove(weaponName);}
    }

    public void removeAliveEnemy(String enemyName){
        unsubscribeToEnemyDeathNotification(initialEnemyList.get(enemyName));
        aliveEnemyList.remove(enemyName);
        this.checkGameStatus();
    }

    public void removeAlivePlayerCharacter(String playerCharacterName){
        unsubscribeToPlayerCharacterDeathNotification(alivePlayerCharacterList.get(playerCharacterName));
        alivePlayerCharacterList.remove(playerCharacterName);
        this.checkGameStatus();
    }





    public Map<String, IPlayerCharacter> getAlivePlayerCharacterList() {
        return alivePlayerCharacterList;
    }

    public Map<String, IEnemy> getAliveEnemyList() {
        return aliveEnemyList;
    }


    public boolean isInAliveEnemyList(ICharacter enemy) {
        return aliveEnemyList.containsKey(enemy.getName());
    }

    public boolean isInAlivePlayerCharacterList(ICharacter playerCharacter) {
        return alivePlayerCharacterList.containsKey(playerCharacter.getName());
    }

    private void checkGameStatus() {
        if (getAliveEnemyList().size()==0){
            fireEnemyAllDeadEvent();
        }
        if (getAlivePlayerCharacterList().size()==0){
            firePlayerCharacterAllDeadEvent();
        }
    }

    public void endGamePlayerLost() {
        System.out.println("You lost the game.");
        this.endGame();
    }

    public void endGamePlayerWon() {
        System.out.println("You won the game.");
        this.endGame();
    }

    private void endGame(){
        unsubscribeToPlayerCharacterAllDeadNotification();
        unsubscribeToEnemyAllDeadNotification();
        this.gameOver();
        setGamePhase(new GameOverPhase());
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public boolean getGameStarted() {
        return this.gameStarted;
    }

    public void controllerSetEnemyDamage(IEnemy enemy,int damage) {
        enemy.setDamage(damage);
    }

    public void setInitialPlayerCharacterList() {
        this.initialPlayerCharacterList.putAll( this.getAlivePlayerCharacterList());
    }

    public void setInitialEnemyList() {
        this.initialEnemyList.putAll(this.getAliveEnemyList());
    }
}
