package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single knight character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Knight extends AbstractNonMage {

    /**
     * Creates a new knight character with a name and the queue with the characters ready to
     * play.
     */
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "KNIGHT".
     */
    @Override
    public String getCharacterClass() {
        return "KNIGHT";
    }
}
