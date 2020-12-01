package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.Engineer;
import com.github.ignacioalbornoz.finalreality.model.character.player.Knight;
import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a staff-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */

public class Staff extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public Staff(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "STAFF", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "STAFF";
    }


    @Override
    public void equippedByKnight(Knight character) {
    }

    @Override
    public void equippedByEngineer(Engineer character) {
    }

}

