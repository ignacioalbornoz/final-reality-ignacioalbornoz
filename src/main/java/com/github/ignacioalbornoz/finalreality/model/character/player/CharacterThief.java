package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single thief character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterThief extends AbstractPlayerCharacterNonMage{

    /**
     * Creates a new thief character with a name and the queue with the characters ready to
     * play.
     */
    public CharacterThief(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "THIEF".
     */
    @Override
    public String getCharacterClass() {
        return "THIEF";
    }
}
