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

    private final Map<String,IPlayerCharacter> playerCharacterList;
    private final Map<String,IEnemy> enemyList;
    private final Map<String,IWeapon> weaponList;



    private final Map<String,String> charactersEquippedList;



    private final Map<String,IEnemy> aliveEnemyList;
    private final Map<String,IPlayerCharacter> alivePlayerCharacterList;



    private final BlockingQueue<ICharacter> controllerTurnsQueue;
    private final PropertyChangeSupport PlayerCharacterAllDeadNotification = new PropertyChangeSupport(this);
    private final PropertyChangeSupport EnemyAllDeadNotification = new PropertyChangeSupport(this);




    private final PropertyChangeListener PlayerCharacterDeathListener = new PlayerCharacterDeathListener(
            this);

    private final PropertyChangeListener EnemyDeathListener = new EnemyDeathListener(this);

    private final PropertyChangeListener EnemyAllDeadListener = new EnemyAllDeadListener(this);
    private final PropertyChangeListener PlayerCharacterAllDeadListener = new PlayerCharacterAllDeadListener(
            this);

    private Boolean gameOver;
    private Boolean gameStarted;




    private  ICharacter characterInTurn;




    private IGamePhase gamePhase;



    public FinalRealityController() {
        playerCharacterList = new HashMap<>();
        weaponList = new HashMap<>();
        enemyList = new HashMap<>();
        charactersEquippedList = new HashMap<>();
        controllerTurnsQueue = new LinkedBlockingQueue<>();
        characterInTurn = null;
        aliveEnemyList = new HashMap<>();
        alivePlayerCharacterList = new HashMap<>();
        gameOver = false;
        gameStarted = false;
        setGamePhase(new PreGameStartedPhase());

    }



    private void setTrueGameStarted(){
        this.gameStarted = true; }

    public void actionIfHeadEnemy(IEnemy enemy){
        if (isInEnemyList(enemy)){
            enemyRandomTarget(enemy);
        }
    }


    public void enemyRandomTarget(IEnemy enemy){
        Map.Entry<String,IPlayerCharacter> entry = playerCharacterList.entrySet().iterator().next();
        IPlayerCharacter value = entry.getValue();
        controllerAttack(enemy,value);
    }




    public Map<String,ICharacter> cloneAndShuffleMap(Map<String,IPlayerCharacter> map, Map<String,IEnemy> mapTwo ){

        var myObjectListA = new HashMap<String,ICharacter>(map);

        var myObjectListB = new HashMap<String,ICharacter>(mapTwo);

        myObjectListA.putAll(myObjectListB);


        List<String> list = new ArrayList<>(myObjectListA.keySet());
        Collections.shuffle(list);

        Map<String, ICharacter> shuffleMap = new LinkedHashMap<>();
        list.forEach(k->shuffleMap.put(k, myObjectListA.get(k)));

        return shuffleMap;
    }



    public void waitTurnShuffleMap(Map<String,ICharacter> shuffleMap){
        for (Map.Entry<String,ICharacter> me : shuffleMap.entrySet()) {
           controllerWaitTurn(me.getValue());}
    }


    public void controllerTurns(){
        var shuffleMap = cloneAndShuffleMap(this.playerCharacterList,this.enemyList);
        waitTurnShuffleMap(shuffleMap);
        this.subscribeToPlayerCharacterAllDeadNotification();
        this.subscribeToEnemyAllDeadNotification();
    }




    public void controllerWaitTurn(ICharacter character){
        character.waitTurn();
    }



    public BlockingQueue<ICharacter> getControllerTurnsQueue() {
        return controllerTurnsQueue;
    }






    public ICharacter getCharacterInTurn() {
        return characterInTurn;
    }


    public void setGamePhase(IGamePhase gamePhase) {
        this.gamePhase = gamePhase;
        gamePhase.setController(this);
    }


    public IGamePhase getGamePhase() {
        return gamePhase;
    }


    private void gameOver() {
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
            setGamePhase(new SecondPhase());
        }
        else if(isInAlivePlayerCharacterList(characterInTurn)){
            setGamePhase(new SelectingAttackTargetPhase());
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
            this.controllerWaitTurn(character);}
        this.setGamePhase(new FirstPhase());
    }

    public void doPhaseAction(){
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


    public PropertyChangeSupport getPlayerCharacterAllDeadNotification() {
        return PlayerCharacterAllDeadNotification;
    }

    public PropertyChangeSupport getEnemyAllDeadNotification() {
        return EnemyAllDeadNotification;
    }






    public void firePlayerCharacterAllDeadEvent() {
        PlayerCharacterAllDeadNotification.firePropertyChange(new PropertyChangeEvent(this,
                "You lost the game", null,null));}

    public void fireEnemyAllDeadEvent() {
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
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }

    public void createEngineer(@NotNull String name){
        IPlayerCharacter newCharacter = new Engineer(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);

    }
    public void createKnight(@NotNull String name){
        IPlayerCharacter newCharacter = new Knight(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);

    }
    public void createThief(@NotNull String name){
        IPlayerCharacter newCharacter = new Thief(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);

    }
    public void createWhiteMage(@NotNull String name){
        IPlayerCharacter newCharacter = new WhiteMage(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        alivePlayerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }

    public void createEnemy(@NotNull String name, int weight){
        IEnemy newEnemy = new Enemy(controllerTurnsQueue,name,weight);
        enemyList.put(newEnemy.getName(),newEnemy);
        aliveEnemyList.put(newEnemy.getName(),newEnemy);
        subscribeToEnemyDeathNotification(newEnemy);
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




    public IPlayerCharacter getPlayerCharacterFromParty(String nameCharacter){
        return playerCharacterList.get(nameCharacter);
    }

    public IEnemy getEnemyFromEnemyList(String nameEnemy){
        return enemyList.get(nameEnemy);
    }

    public IWeapon getWeapon(String nameWeapon) {
        return weaponList.get(nameWeapon);
    }

    public IPlayerCharacter getAlivePlayerCharacter(String nameCharacter){
        return alivePlayerCharacterList.get(nameCharacter);
    }

    public IEnemy getAliveEnemy(String nameEnemy){
        return aliveEnemyList.get(nameEnemy);
    }


    public Collection<IPlayerCharacter> getCollectionOfPlayerCharacters(){
        return playerCharacterList.values();
    }


    public @Unmodifiable Set<String> getCopyOfSetOfPlayerCharacterNames(){
        return new HashSet<>(playerCharacterList.keySet());
    }

    public Collection<IEnemy> getCollectionOfEnemy(){
        return enemyList.values();
    }

    public @Unmodifiable Set<String> getCopyOfSetOfEnemyNames(){
        return new HashSet<>(enemyList.keySet());
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
        return playerCharacterList.containsValue(character);
    }

    public boolean isInEnemyList(IEnemy enemy){
        return enemyList.containsValue(enemy);
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
        return !playerCharacterList.containsKey(name);
    }

    public boolean isNameEnemyDisponible(String name){
        return !enemyList.containsKey(name);
    }

    public boolean isNameWeaponDisponible(String name){
        return !weaponList.containsKey(name);
    }


    public void deletePlayerCharacter(String playerCharacterName){
        unsubscribeToPlayerCharacterDeathNotification(playerCharacterList.get(playerCharacterName));
        playerCharacterList.remove(playerCharacterName);
        alivePlayerCharacterList.remove(playerCharacterName);
    }

    public void deleteEnemy(String enemyName){
        unsubscribeToEnemyDeathNotification(enemyList.get(enemyName));
        enemyList.remove(enemyName);
        aliveEnemyList.remove(enemyName);
    }

    public void deleteWeapon(String weaponName){
        if (!(isWeaponInCharactersEquipped(weaponName))) {weaponList.remove(weaponName);}
    }

    public void removeAliveEnemy(String enemyName){
        aliveEnemyList.remove(enemyName);
        this.checkGameStatus();
    }

    public void removeAlivePlayerCharacter(String playerCharacterName){
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









    public void checkGameStatus() {
        if (getAliveEnemyList().size()==0){
            fireEnemyAllDeadEvent();
        }
        if (getAlivePlayerCharacterList().size()==0){
            firePlayerCharacterAllDeadEvent();
        }
    }

    public void endGamePlayerLost() {
        this.endGame();
    }

    public void endGamePlayerWon() {
        this.endGame();
    }

    private void endGame(){
        unsubscribeToPlayerCharacterAllDeadNotification();
        unsubscribeToEnemyAllDeadNotification();
        this.gameOver();
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public boolean getGameStarted() {
        return this.gameStarted;
    }


}
