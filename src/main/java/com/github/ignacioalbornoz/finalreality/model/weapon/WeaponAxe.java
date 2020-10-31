package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a axe-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */

public class WeaponAxe extends AbstractWeapon{

    /**
     * Returns "AXE", the weapon's type of this class.
     */
    public WeaponAxe(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "AXE", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "AXE";
    }
}
