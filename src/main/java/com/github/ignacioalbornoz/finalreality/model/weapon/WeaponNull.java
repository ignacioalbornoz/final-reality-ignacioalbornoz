package com.github.ignacioalbornoz.finalreality.model.weapon;

/**
 * A class that contains all the information for a null-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponNull extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public WeaponNull() {
        super("null", 0, 0);
    }

    /**
     * Returns "NULL", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "NULL";
    }

    /**
     * Returns true, this weapon is of type "NULL".
     */
    @Override
    public boolean isNull(){
        return true;
    }
}
