package com.github.ignacioalbornoz.finalreality.listeners;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A class that holds all the information of a single Listener of a death of an enemy.
 *
 * @author Ignacio Albornoz Alfaro.
 */

public class EnemyDeathListener implements PropertyChangeListener {
    FinalRealityController controller;

    /**
     * A class that holds all the information of a single Listener of a death of an enemy.
     *
     * @author Ignacio Albornoz Alfaro.
     */
    public EnemyDeathListener(FinalRealityController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IEnemy enemy =  (IEnemy) evt.getSource();
        controller.deleteEnemy(enemy.getName());
    }
}