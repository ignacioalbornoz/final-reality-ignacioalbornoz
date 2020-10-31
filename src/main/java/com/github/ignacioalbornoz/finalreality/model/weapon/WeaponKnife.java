package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a knife-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponKnife extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public WeaponKnife(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "KNIFE", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "KNIFE";
    }
}
