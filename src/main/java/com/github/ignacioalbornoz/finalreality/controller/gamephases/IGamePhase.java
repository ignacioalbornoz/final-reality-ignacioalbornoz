package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

import java.util.Set;

public interface IGamePhase {

    void setController(FinalRealityController controller);

    void doPhaseAction() throws InvalidTransitionException;

    FinalRealityController getController();

    String getType();

    void attack(ICharacter character, ICharacter attackedCharacter) throws InvalidTargetException, InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException, InvalidPhaseException;

    IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException;

    IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException;

    void createEnemy(String name, int weight) throws InvalidPhaseException;

    void setNextEnemy() throws InvalidAliveCharacterException;

    void setPreviousEnemy() throws InvalidAliveCharacterException;

    Set<String> getCopyOfSetOfEnemyNames();

    Set<String> getCopyOfSetOfPlayerCharacterNames();

    String getNameOfCharacterInTurn() throws InvalidPhaseException, InvalidCharacterException;


    void equip(IPlayerCharacter playerCharacter, IWeapon weapon) throws InvalidPhaseException, InvalidTargetException, InvalidCharacterException, InvalidWeaponException;

    void unEquip(IPlayerCharacter playerCharacterSelected) throws InvalidPhaseException, InvalidCharacterException;

    IWeapon getWeapon(String weaponSelected);

    void setNextPlayerCharacter() throws InvalidAliveCharacterException;

    void setPreviousPlayerCharacter() throws InvalidAliveCharacterException;

    void weaponCreateStaff(String nameOfStaff, int i, int j) throws InvalidPhaseException;

    void weaponCreateSword(String nameOfSword, int i, int j) throws InvalidPhaseException;
    void weaponCreateAxe(String nameOfAxe, int i, int j) throws InvalidPhaseException;

    void weaponCreateBow(String nameOfBow, int i, int j) throws InvalidPhaseException;

    void weaponCreateKnife(String nameOfKnife, int i, int j) throws InvalidPhaseException;


    void createBlackMage(String blackMage) throws InvalidPhaseException;

    void createThief(String thief) throws InvalidPhaseException;

    void createWhiteMage(String whiteMage) throws InvalidPhaseException;

    void createEngineer(String engineer) throws InvalidPhaseException;

    void createKnight(String knight) throws InvalidPhaseException;

    void setNextWeapon() throws InvalidTargetException, InvalidWeaponException;

    void setPreviousWeapon() throws InvalidTargetException, InvalidWeaponException;

    void setEnemyDamage(IEnemy enemySelected, int i) throws InvalidPhaseException, InvalidCharacterException;
    void equipToCharacterInTurn(IWeapon weapon) throws InvalidPhaseException, InvalidTargetException, InvalidCharacterException, InvalidAliveCharacterException, InvalidTransitionException;

    String getEnemySelected() throws InvalidCharacterException;

    String getPlayerCharacterSelected() throws InvalidCharacterException;

    String getWeaponSelected() throws InvalidCharacterException;

}
