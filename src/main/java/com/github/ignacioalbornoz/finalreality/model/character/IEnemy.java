package com.github.ignacioalbornoz.finalreality.model.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This represents a enemy from the game.
 * An enemy can be controlled only by the CPU.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public interface IEnemy extends ICharacter{

    /**
     * Returns this enemy's weight.
     */
    int getWeight();

    int getDamage();

    void addEnemyDeathListener(PropertyChangeListener listener);

    void removeEnemyDeathListener(PropertyChangeListener listener);

    PropertyChangeSupport getEnemyDeathNotification();
}
