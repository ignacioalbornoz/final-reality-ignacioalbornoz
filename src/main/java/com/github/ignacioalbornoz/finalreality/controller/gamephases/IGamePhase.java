package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;

public interface IGamePhase {

    void setController(FinalRealityController controller);

    void doPhaseAction() throws InvalidTransitionException;

    FinalRealityController getController();

    String getType();
}
