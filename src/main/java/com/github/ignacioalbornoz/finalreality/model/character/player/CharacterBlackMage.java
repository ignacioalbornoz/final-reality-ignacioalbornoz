package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterBlackMage extends AbstractPlayerCharacterMage{

    /**
     * Creates a new black mage character with a name and the queue with the characters ready to
     * play.
     */
    public CharacterBlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "BLACK_MAGE".
     */
    @Override
    public String getCharacterClass() {
        return "BLACK_MAGE";
    }
}
