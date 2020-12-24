package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class SelectingAttackTargetPhase extends AbstractGamePhase{

    public SelectingAttackTargetPhase(){
        super();
    }


    @Override
    public void doPhaseAction() {
        controller.setGamePhase(new SecondPhase());
    }

    public String getType(){
        return "SelectingAttackTargetPhase";
    }
}
