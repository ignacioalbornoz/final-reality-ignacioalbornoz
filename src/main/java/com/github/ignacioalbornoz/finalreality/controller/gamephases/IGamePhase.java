package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;

public interface IGamePhase {

    void setController(FinalRealityController controller);

    void doPhaseAction();

    FinalRealityController getController();

    String getType();
}
