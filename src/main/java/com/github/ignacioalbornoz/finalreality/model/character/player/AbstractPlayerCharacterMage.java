package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the mage characters in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractPlayerCharacterMage extends AbstractPlayerCharacter implements IPlayerCharacterMage{

    /**
     * {@inheritDoc}
     */
    public AbstractPlayerCharacterMage(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }
}
