package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This represents a player character from the game.
 * A player character can be controlled by the player.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public interface IPlayerCharacter extends ICharacter {

    /**
     * Adds a player character listener to a character, that notifies its death.
     */
    void addPlayerCharacterDeathListener(PropertyChangeListener listener);

    /**
     * Removes the listener from the character.
     */
    void removePlayerCharacterDeathListener(PropertyChangeListener listener);

    /**
     * Returns the notification that fires when a character dies.
     */
    PropertyChangeSupport getPlayerCharacterDeathNotification();

}
