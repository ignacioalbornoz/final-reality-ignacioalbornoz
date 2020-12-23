package com.github.ignacioalbornoz.finalreality.listeners;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyAllDeadListener implements PropertyChangeListener {
    FinalRealityController controller;

    /**
     * A class that holds all the information of a single Listener of a death of an enemy.
     *
     * @author Ignacio Albornoz Alfaro.
     */
    public EnemyAllDeadListener(FinalRealityController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FinalRealityController controller =  (FinalRealityController) evt.getSource();
        controller.endGamePlayerWon();
    }
}
