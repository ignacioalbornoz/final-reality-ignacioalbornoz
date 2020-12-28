package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class SecondPhase extends AbstractGamePhase{
    public SecondPhase() {
        super();
    }

    @Override
    public void doPhaseAction() {
        controller.turnEnds();
    }


    public String getType(){
        return "SecondPhase";
    }
}
