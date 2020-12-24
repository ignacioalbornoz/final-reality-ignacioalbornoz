package com.github.ignacioalbornoz.finalreality.listeners;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerCharacterAllDeadListener implements PropertyChangeListener {

    FinalRealityController controller;

    public PlayerCharacterAllDeadListener(FinalRealityController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FinalRealityController controller =  (FinalRealityController) evt.getSource();
        controller.endGamePlayerLost();
    }
}
