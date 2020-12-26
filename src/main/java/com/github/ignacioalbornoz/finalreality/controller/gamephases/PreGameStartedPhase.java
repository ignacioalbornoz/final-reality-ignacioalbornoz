package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;

import java.util.Set;

public class PreGameStartedPhase extends AbstractGamePhase{

    public PreGameStartedPhase(){
        super();
    }

    @Override
    public IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        return controller.getPlayerCharacterFromInitialList(nameOfPlayerCharacter);
    }

    @Override
    public IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        return super.controller.getEnemyFromInitialList(nameOfEnemy);
    }

    @Override
    public void createEnemy(String name, int weight) {
        controller.createEnemy(name,weight);
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
    public void doPhaseAction() throws InvalidTransitionException {
        if (controller.getGameOver()){
            controller.setGamePhase(new GameOverPhase());
        }
        else if(controller.getAliveEnemyList().size()>0 && controller.getAlivePlayerCharacterList().size()>0){
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
