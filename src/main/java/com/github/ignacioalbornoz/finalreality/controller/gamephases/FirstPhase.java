package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class FirstPhase extends AbstractGamePhase{
    @Override
    public void doPhaseAction() {
        controller.turnStarts();
    }

    public String getType(){
        return "FirstPhase";
    }
}
