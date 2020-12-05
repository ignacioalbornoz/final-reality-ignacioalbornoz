package com.github.ignacioalbornoz.finalreality.controller;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import com.github.ignacioalbornoz.finalreality.listeners.PlayerCharacterDeathListener;

import com.github.ignacioalbornoz.finalreality.listeners.EnemyDeathListener;

import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FinalRealityController {

    private final Map<String,IPlayerCharacter> playerCharacterList;
    private final Map<String,IEnemy> enemyList;
    private final Map<String,IWeapon> weaponList;
    private final Map<String,String> charactersEquippedList;

    private final BlockingQueue<ICharacter> controllerTurnsQueue;

    private final PropertyChangeListener PlayerCharacterDeathListener = new PlayerCharacterDeathListener(this);

    private final PropertyChangeListener EnemyDeathListener = new EnemyDeathListener(this);



    public FinalRealityController() {
        playerCharacterList = new HashMap<>();
        weaponList = new HashMap<>();
        enemyList = new HashMap<>();
        charactersEquippedList = new HashMap<>();
        controllerTurnsQueue = new LinkedBlockingQueue<>();
    }

    public String getHeadOfTurnsQueue(){
        var character = controllerTurnsQueue.poll();
        String characterName = null;
        if (character != null) {
            characterName = character.getName();
        }
        return characterName;
    }

    public void actionIfHeadEnemy(String characterName){
        if (isInEnemyList(getEnemy(characterName))){
            enemyRandomTarget(getEnemy(characterName));
        }
    }


    public void enemyRandomTarget(IEnemy enemy){
        Map.Entry<String,IPlayerCharacter> entry = playerCharacterList.entrySet().iterator().next();
        IPlayerCharacter value = entry.getValue();
        controllerAttack(enemy,value);
    }


    public BlockingQueue<ICharacter> getControllerTurnsQueue() {
        return controllerTurnsQueue;
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
        for (Map.Entry me : shuffleMap.entrySet()) {
           controllerWaitTurn((ICharacter) me.getValue());}
    }


    public void controllerTurns(){
        waitTurnShuffleMap(cloneAndShuffleMap(playerCharacterList,enemyList));
    }

    public void controllerWaitTurn(ICharacter character){
        character.waitTurn();
    }

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
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }

    public void createEngineer(@NotNull String name){
        IPlayerCharacter newCharacter = new Engineer(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }
    public void createKnight(@NotNull String name){
        IPlayerCharacter newCharacter = new Knight(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }
    public void createThief(@NotNull String name){
        IPlayerCharacter newCharacter = new Thief(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }
    public void createWhiteMage(@NotNull String name){
        IPlayerCharacter newCharacter = new WhiteMage(controllerTurnsQueue, name);
        playerCharacterList.put(newCharacter.getName(),newCharacter);
        subscribeToPlayerCharacterDeathNotification(newCharacter);
    }

    public void createEnemy(@NotNull String name, int weight){
        IEnemy newEnemy = new Enemy(controllerTurnsQueue,name,weight);
        enemyList.put(newEnemy.getName(),newEnemy);
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




    public IPlayerCharacter getCharacter(String nameCharacter){
        return playerCharacterList.get(nameCharacter);
    }

    public IEnemy getEnemy(String nameEnemy){
        return enemyList.get(nameEnemy);
    }

    public IWeapon getWeapon(String nameWeapon) {
        return weaponList.get(nameWeapon);
    }


    public Collection<IPlayerCharacter> getCollectionOfCharacter(){
        return playerCharacterList.values();
    }

    public Set<String> getSetOfCharacterNames(){
        return playerCharacterList.keySet();
    }

    public Collection<IEnemy> getCollectionOfEnemy(){
        return enemyList.values();
    }

    public Set<String> getSetOfEnemyNames(){
        return playerCharacterList.keySet();
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
    }

    public void deleteEnemy(String enemyName){
        unsubscribeToEnemyDeathNotification(enemyList.get(enemyName));
        enemyList.remove(enemyName);
    }

    public void deleteWeapon(String weaponName){
        if (!(isWeaponInCharactersEquipped(weaponName))) {weaponList.remove(weaponName);}
    }

}
