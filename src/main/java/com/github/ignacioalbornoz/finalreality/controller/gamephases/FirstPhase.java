package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class FirstPhase extends AbstractGamePhase{
    public FirstPhase() {super();
    }

    @Override
    public void doPhaseAction() {
        controller.turnStarts();
    }

    public String getType(){
        return "FirstPhase";
    }
}
