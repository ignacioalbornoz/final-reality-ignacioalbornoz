package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;

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
}
