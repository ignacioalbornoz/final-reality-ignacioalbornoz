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
    void addPlayerCharacterDeathListener(PropertyChangeListener listener);

    void removePlayerCharacterDeathListener(PropertyChangeListener listener);

    PropertyChangeSupport getPlayerCharacterDeathNotification();

}
