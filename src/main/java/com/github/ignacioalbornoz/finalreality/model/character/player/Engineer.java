package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single engineer character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Engineer extends AbstractNonMage {

    /**
     * Creates a new engineer character with a name and the queue with the characters ready to
     * play.
     */
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "ENGINEER".
     */
    @Override
    public String getCharacterClass() {
        return "ENGINEER";
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedByEngineer(this);

    }
    @Override
    public void equip(IWeapon weapon) {
        weapon.equippedByEngineer(this);}
}
