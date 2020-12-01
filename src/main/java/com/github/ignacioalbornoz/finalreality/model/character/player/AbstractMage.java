package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the mage characters in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractMage extends AbstractPlayerCharacter implements IMage {

    /**
     * {@inheritDoc}
     */
    public AbstractMage(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }
}
