package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

import java.util.Set;

public class PreGameStartedPhase extends AbstractGamePhase{

    public PreGameStartedPhase(){
        super();
    }


    @Override
    public IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidCharacterException {
        if (controller.getCopyOfSetOfAlivePlayerCharacters().contains(nameOfPlayerCharacter)){
            return controller.getAlivePlayerCharacter(nameOfPlayerCharacter);
        }else{
            throw new InvalidCharacterException("You must select a valid player character.");
        }
    }


    @Override
    public IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidCharacterException {
        if (controller.getCopyOfSetOfAliveEnemyCharacters().contains(nameOfEnemy)){
            return controller.getAliveEnemy(nameOfEnemy);
        }else{
            throw new InvalidCharacterException("You must select a valid enemy character.");
        }
    }

    @Override
    public void createEnemy(String name, int weight) {
        controller.createEnemy(name,weight);
    }

    @Override
    public void setEnemyDamage(IEnemy enemySelected, int i) throws InvalidCharacterException {
        if (enemySelected==null){
            throw new InvalidCharacterException("You must select a valid enemy.");
        }else{
            controller.controllerSetEnemyDamage(enemySelected, i);
        }
    }

    @Override
    public Set<String> getCopyOfSetOfEnemyNames() {
        return controller.getCopyOfSetOfAliveEnemyCharacters();
    }

    @Override
    public Set<String> getCopyOfSetOfPlayerCharacterNames() {
        return controller.getCopyOfSetOfAlivePlayerCharacters();
    }

    @Override
    public String getNameOfCharacterInTurn() throws InvalidPhaseException {
        throw new InvalidPhaseException("You must advance to the next phase for the game turns to begin.");
    }

    @Override
    public void createBlackMage(String blackMage) {
        controller.createBlackMage(blackMage);
    }

    @Override
    public void createWhiteMage(String whiteMage) {
        controller.createWhiteMage(whiteMage);
    }
    @Override
    public void createEngineer(String engineer) {
        controller.createEngineer(engineer);
    }
    @Override
    public void createKnight(String knight) {
        controller.createKnight(knight);
    }
    @Override
    public void createThief(String thief) {
        controller.createThief(thief);
    }



    @Override
    public void weaponCreateAxe(String nameOfAxe, int i, int j) {
        controller.weaponCreateAxe(nameOfAxe, i, j);
    }

    @Override
    public void weaponCreateBow(String nameOfBow, int i, int j) {
        controller.weaponCreateBow(nameOfBow, i, j);
    }
    @Override
    public void weaponCreateKnife(String nameOfKnife, int i, int j) {
        controller.weaponCreateKnife(nameOfKnife, i, j);
    }
    @Override
    public void weaponCreateStaff(String nameOfStaff, int i, int j) {
        controller.weaponCreateStaff(nameOfStaff, i, j);
    }
    @Override
    public void weaponCreateSword(String nameOfSword, int i, int j) {
        controller.weaponCreateSword(nameOfSword, i, j);
    }

    @Override
    public void equip(IPlayerCharacter playerCharacter, IWeapon weapon) throws InvalidTargetException, InvalidCharacterException, InvalidWeaponException {
        if (playerCharacter == null) {
            throw new InvalidCharacterException("You must select a valid character.");
        } else if (weapon == null) {
            throw new InvalidWeaponException("You must select a valid weapon.");
        }
        else{
            controller.equipController(playerCharacter, weapon);
            if(!(controller.getEquippedWeaponController(playerCharacter)==weapon)){
                throw new InvalidTargetException("You cannot equip the weapon to this character.");
            }
        }
    }

    @Override
    public void unEquip(IPlayerCharacter playerCharacterSelected) throws InvalidCharacterException {
        if (playerCharacterSelected==null){
            throw new InvalidCharacterException("You must select a valid character.");
        } else{
            controller.unEquipController(playerCharacterSelected);
        }
    }


    @Override
    public void doPhaseAction() throws InvalidTransitionException {
        if(controller.getAliveEnemyList().size()>0 && controller.getAlivePlayerCharacterList().size()>0){
            controller.setInitialPlayerCharacterList();
            controller.setInitialEnemyList();
            controller.gameStarted();
        }
        else if(!(controller.getAliveEnemyList().size()>0 && controller.getAlivePlayerCharacterList().size()>0)){
            throw new InvalidTransitionException("You must create your characters and the enemies");
        }

        else if(!(controller.getAliveEnemyList().size()>0)){throw new InvalidTransitionException("You must create enemies");}

        else if(!(controller.getAlivePlayerCharacterList().size()>0)){throw new InvalidTransitionException("You must create your characters.");}


    }

    public String getType(){
        return "PreGameStartedPhase";
    }
}
