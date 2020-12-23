package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class PreGameStartedPhase extends AbstractGamePhase{

    public PreGameStartedPhase(){
        super();
    }


    @Override
    public void doPhaseAction() {
        controller.gameStarted();
    }

    public String getType(){
        return "PreGameStartedPhase";
    }
}
