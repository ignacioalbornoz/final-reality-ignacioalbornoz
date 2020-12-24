package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class PreGameStartedPhase extends AbstractGamePhase{

    public PreGameStartedPhase(){
        super();
    }


    @Override
    public void doPhaseAction() throws InvalidTransitionException {
        if(controller.getAliveEnemyList().size()>0 && controller.getAlivePlayerCharacterList().size()>0){
            controller.gameStarted();
        }
        if(!(controller.getAliveEnemyList().size()>0 && controller.getAlivePlayerCharacterList().size()>0)){
            throw new InvalidTransitionException("You must create your characters and the enemies");
        }

        else if(!(controller.getAliveEnemyList().size()>0)){throw new InvalidTransitionException("You must create enemies");}

        else if(!(controller.getAlivePlayerCharacterList().size()>0)){throw new InvalidTransitionException("You must create your characters.");}


    }

    public String getType(){
        return "PreGameStartedPhase";
    }
}
