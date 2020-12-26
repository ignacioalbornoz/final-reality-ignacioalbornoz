package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class FirstPhase extends AbstractGamePhase{
    public FirstPhase() {super();
    }

    @Override
    public void doPhaseAction() {
        if (controller.getGameOver()){
            controller.setGamePhase(new GameOverPhase());
        }
        else{
            controller.turnStarts();}
    }

    public String getType(){
        return "FirstPhase";
    }
}
