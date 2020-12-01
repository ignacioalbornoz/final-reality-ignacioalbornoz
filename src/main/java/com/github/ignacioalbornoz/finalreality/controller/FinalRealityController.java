package com.github.ignacioalbornoz.finalreality.controller;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class FinalRealityController {

    private Map<String,ICharacter> characterList;
    private Map<String,IEnemy> enemyList;
    private Map<String,IWeapon> weaponList;

    public FinalRealityController() {
        characterList = new HashMap<String,ICharacter>();
        weaponList = new HashMap<String,IWeapon>();
        enemyList = new HashMap<String,IEnemy>();
    }




    public void createBlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        ICharacter newCharacter = new BlackMage(turnsQueue, name);
        characterList.put(newCharacter.getName(),newCharacter);
    }

    public void createEngineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        ICharacter newCharacter = new Engineer(turnsQueue, name);
        characterList.put(newCharacter.getName(),newCharacter);
    }
    public void createKnight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        ICharacter newCharacter = new Knight(turnsQueue, name);
        characterList.put(newCharacter.getName(),newCharacter);
    }
    public void createThief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        ICharacter newCharacter = new Thief(turnsQueue, name);
        characterList.put(newCharacter.getName(),newCharacter);
    }
    public void createWhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        ICharacter newCharacter = new WhiteMage(turnsQueue, name);
        characterList.put(newCharacter.getName(),newCharacter);
    }

    public void createEnemy(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name, int weight){
        IEnemy newEnemy = new Enemy(turnsQueue,name,weight);
        enemyList.put(newEnemy.getName(),newEnemy);
    }





    public ICharacter getCharacter(String nameCharacter){
        return characterList.get(nameCharacter);
    }

    public Collection<ICharacter> getCollectionOfCharacters(){
        return characterList.values();
    }

    public Set<String> getSetOfNamesCharacters(){
        return characterList.keySet();
    }

    public ICharacter getCharacterController(String nameCharacter){
        return characterList.get(nameCharacter);
    }



    public boolean isInParty(ICharacter character){
        return characterList.containsValue(character);
    }


    public boolean isNameDisponible(String name){
        return !characterList.containsKey(name);
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






    public void equipController(IPlayerCharacter playerCharacter, IWeapon weapon){
        playerCharacter.equip(weapon);
        weaponList.remove(weapon.getName());
    }

    public void unEquipController(IPlayerCharacter playerCharacter){
        IWeapon newWeapon = playerCharacter.getEquippedWeapon();
        weaponList.put(newWeapon.getName(),newWeapon);
        playerCharacter.equip(new WeaponNull());
    }





}
