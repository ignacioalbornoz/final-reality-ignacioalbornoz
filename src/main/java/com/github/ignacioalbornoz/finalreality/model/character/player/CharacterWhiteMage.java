package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single white mage character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterWhiteMage extends AbstractPlayerCharacterMage{

    /**
     * Creates a new white mage character with a name and the queue with the characters ready to
     * play.
     */
    public CharacterWhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "WHITE_MAGE".
     */
    @Override
    public String getCharacterClass() {
        return "WHITE_MAGE";
    }
}
