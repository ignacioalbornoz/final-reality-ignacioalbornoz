package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;

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
    public void attack(ICharacter character, ICharacter attackedCharacter) throws InvalidTargetException,
            InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException, InvalidPhaseException {
        throw new InvalidPhaseException("You must be in \"SelectingAttackTargetPhase\" to be able to attack an enemy.");
    }

    @Override
    public IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        if(!controller.isNamePlayerCharacterDisponible(nameOfPlayerCharacter)){
            if (controller.isInAlivePlayerCharacterList(controller.getAlivePlayerCharacter(nameOfPlayerCharacter))){
                return controller.getAlivePlayerCharacter(nameOfPlayerCharacter);}
            else{
                throw new InvalidAliveCharacterException("Not a player character alive");}
        }else{
            throw new InvalidCharacterException("Not even a created player character");
        }
    }

    @Override
    public IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        if(!controller.isNameEnemyDisponible(nameOfEnemy)){
            if (controller.isInAliveEnemyList(controller.getAliveEnemy(nameOfEnemy))){
                return controller.getAliveEnemy(nameOfEnemy);}
            else{
                throw new InvalidAliveCharacterException("Not a enemy character alive");}
        }else{
            throw new InvalidCharacterException("Not even a created enemy character");
        }
    }

    @Override
    public void createEnemy(String name, int weight) throws InvalidPhaseException {
        throw new InvalidPhaseException("You can only create enemies when you are in \"PreGameStarted Phase\".");
    }

    @Override
    public void setNextEnemy() throws InvalidAliveCharacterException {
        if(controller.getAliveEnemyList().size()==0){
            throw new InvalidAliveCharacterException("There are no enemies alive.");
        }
        controller.setNextEnemy();
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
    public boolean equals(Object o) {
        if (o instanceof IGamePhase) {
            final IGamePhase gamePhase = (IGamePhase) o;
            return getType().equals(gamePhase.getType()) && getController() == gamePhase.getController();
        }
        return false;
    }

    /**
     * Returns the hash code for the name and numbers of inhabitants of this city.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getController());
    }


}
