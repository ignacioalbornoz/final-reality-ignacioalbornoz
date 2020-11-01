package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a bow-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Bow extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public Bow(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "BOW", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "BOW";
    }
}
