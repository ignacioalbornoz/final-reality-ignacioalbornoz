package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

import java.util.Objects;
import java.util.Set;

public abstract class AbstractGamePhase implements IGamePhase {

    /**
     * The city that is going to be the context of the state.
     */

    protected FinalRealityController controller;

    /**
     * City's constructor with the common attributes: name and number of inhabitants.
     *
     */
    public AbstractGamePhase() {

        this.controller = null;
    }

    /**
     * Set the city that is the context of the state.
     */
    

    @Override
    public void setController(FinalRealityController controller){
        this.controller = controller;
    }

    public FinalRealityController getController(){
        return this.controller;
    }


    @Override
    public void attackToEnemySelected(ICharacter character) throws InvalidPhaseException, InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException, InvalidTargetException {
        throw new InvalidPhaseException("You must be in \"SelectingAttackTargetPhase\" to be able to attack an enemy.");
    }

    @Override
    public IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        if(!controller.isNamePlayerCharacterDisponible(nameOfPlayerCharacter)){
            if (controller.isInAlivePlayerCharacterList(controller.getPlayerCharacterFromInitialList(nameOfPlayerCharacter))){
                return controller.getAlivePlayerCharacter(nameOfPlayerCharacter);}
            else{
                throw new InvalidAliveCharacterException("Not a player character alive");}
        }else{
            throw new InvalidCharacterException("Not even a created player character");
        }
    }

    @Override
    public IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        if(!(controller.isNameEnemyDisponible(nameOfEnemy))){
            if (controller.isInAliveEnemyList(controller.getEnemyFromInitialList(nameOfEnemy))){
                return controller.getAliveEnemy(nameOfEnemy);}
            else{
                throw new InvalidAliveCharacterException("Not a enemy character alive");}
        }else{
            throw new InvalidCharacterException("Not even a created enemy character");
        }
    }


    @Override
    public void setNextEnemy() throws InvalidAliveCharacterException {
        if(controller.getAliveEnemyList().size()==0){
            throw new InvalidAliveCharacterException("There are no enemies alive.");
        }
        controller.setNextEnemy();
    }

    @Override
    public void setNextPlayerCharacter() throws InvalidAliveCharacterException {
        if(controller.getAlivePlayerCharacterList().size()==0){
            throw new InvalidAliveCharacterException("There are no player characters alive.");
        }
        controller.setNextPlayerCharacter();
    }

    @Override
    public void setNextWeapon() throws InvalidWeaponException {
        if(controller.getSetOfWeaponNames().size()==0){
            throw new InvalidWeaponException("There are no weapons.");
        }
        controller.setNextWeapon();
    }


    @Override
    public void setPreviousWeapon() throws InvalidWeaponException {
        if(controller.getSetOfWeaponNames().size()==0){
            throw new InvalidWeaponException("There are no weapons.");
        }else{
            controller.setPreviousWeapon();
        }
    }

    @Override
    public void setEnemyDamage(IEnemy enemySelected, int i) throws InvalidPhaseException,
            InvalidCharacterException {
        throw new InvalidPhaseException("You can only modify the " +
                "enemies when you are in \"PreGameStarted Phase\".");
    }


    @Override
    public void setPreviousEnemy() throws InvalidAliveCharacterException {
        if(controller.getAliveEnemyList().size()==0){
            throw new InvalidAliveCharacterException("There are no enemies alive.");
        }else{
            controller.setPreviousEnemy();
        }
    }


    @Override
    public void setPreviousPlayerCharacter() throws InvalidAliveCharacterException {
        if(controller.getAlivePlayerCharacterList().size()==0){
            throw new InvalidAliveCharacterException("There are no player characters alive.");
        }else{
            controller.setPreviousPlayerCharacter();
        }
    }


    @Override
    public Set<String> getCopyOfSetOfEnemyNames() {
        return controller.getCopyOfSetOfEnemyNames();
    }

    @Override
    public Set<String> getCopyOfSetOfPlayerCharacterNames() {
        return controller.getCopyOfSetOfPlayerCharacterNames();
    }

    @Override
    public String getNameOfCharacterInTurn() throws InvalidPhaseException, InvalidCharacterException {
        if (controller.getCharacterInTurn()==null){
            throw new InvalidCharacterException("No character has a turn at this time, wait a moment and try again.");
        }else{
        return controller.getNameOfCharacterInTurn();}
    }


    @Override
    public void createEnemy(String name, int weight) throws InvalidPhaseException {
        throw new InvalidPhaseException("You can only create enemies when you are in \"PreGameStarted Phase\".");
    }

    @Override
    public void createBlackMage(String blackMage) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create characters.");
    }
    @Override
    public void createWhiteMage(String whiteMage) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create characters.");
    }
    @Override
    public void createEngineer(String engineer) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create characters.");
    }
    @Override
    public void createKnight(String knight) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create characters.");
    }
    @Override
    public void createThief(String thief) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create characters.");
    }


    @Override
    public void weaponCreateAxe(String nameOfAxe, int i, int j) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create weapons.");
    }
    @Override
    public void weaponCreateBow(String nameOfBow, int i, int j) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create weapons.");
    }
    @Override
    public void weaponCreateKnife(String nameOfKnife, int i, int j) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create weapons.");
    }
    @Override
    public void weaponCreateStaff(String nameOfStaff, int i, int j) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create weapons.");
    }
    @Override
    public void weaponCreateSword(String nameOfSword, int i, int j) throws InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to create weapons.");
    }

    @Override
    public void equip(IPlayerCharacter playerCharacter, IWeapon weapon) throws InvalidPhaseException, InvalidTargetException, InvalidCharacterException, InvalidWeaponException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" to equip a selected character.");
    }

    @Override
    public void unEquip(IPlayerCharacter playerCharacterSelected) throws InvalidPhaseException, InvalidCharacterException, InvalidTargetException {
        throw new InvalidPhaseException("You must be in \"PreGameStartedPhase\" " +
                "or \"SelectingAttackTargetPhase\" to unequip weapons.");
    }

    @Override
    public IWeapon getWeapon(String weaponSelected) {
        return controller.getWeaponFromList(weaponSelected);
    }

    public void equipToCharacterInTurn(IWeapon weapon) throws InvalidPhaseException,
            InvalidTargetException, InvalidCharacterException, InvalidAliveCharacterException,
            InvalidTransitionException {
        throw new InvalidPhaseException("You must be " +
                "in \"SelectingAttackTargetPhase\" to equip the character in turn.");

    }

    @Override
    public String getEnemySelected() throws InvalidCharacterException {
        if (controller.getCopyOfSetOfAliveEnemyCharacters().contains(controller.getEnemySelected())){
            return controller.getEnemySelected();
        }
        else {throw new InvalidCharacterException("You must select a valid enemy character.");}
    }

    @Override
    public String getPlayerCharacterSelected() throws InvalidCharacterException {
        if (controller.getCopyOfSetOfAlivePlayerCharacters().contains(controller.getPlayerCharacterSelected())){
            return controller.getPlayerCharacterSelected();
        }
        else {throw new InvalidCharacterException("You must select a valid player character.");}
    }

    @Override
    public String getWeaponSelected() throws InvalidWeaponException {
        if (controller.getSetOfWeaponNames().contains(controller.getWeaponSelected())){
            return controller.getWeaponSelected();
        }
        else {throw new InvalidWeaponException("You must select a valid weapon.");}
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof IGamePhase) {
            final IGamePhase gamePhase = (IGamePhase) o;
            return getType().equals(gamePhase.getType());
        }
        return false;
    }

    /**
     * Returns the hash code for the name and numbers of inhabitants of this city.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }


}
