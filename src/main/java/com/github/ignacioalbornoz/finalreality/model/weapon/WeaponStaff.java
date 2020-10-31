package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a staff-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */

public class WeaponStaff extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public WeaponStaff(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "STAFF", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "STAFF";
    }
}

