package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class BlackMage extends AbstractMage {

    /**
     * Creates a new black mage character with a name and the queue with the characters ready to
     * play.
     */
    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "BLACK_MAGE".
     */
    @Override
    public String getCharacterClass() {
        return "BLACK_MAGE";
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedByBlackMage(this);
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equippedByBlackMage(this);}
}
