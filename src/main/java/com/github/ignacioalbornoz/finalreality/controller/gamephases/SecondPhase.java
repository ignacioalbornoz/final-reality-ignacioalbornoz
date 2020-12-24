package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class SecondPhase extends AbstractGamePhase{
    @Override
    public void doPhaseAction() {
        controller.turnEnds();
    }

    public String getType(){
        return "SecondPhase";
    }
}
