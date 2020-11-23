package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractWeapon implements IWeapon{
    protected final String name;
    protected final int weight;
    protected final int damage;

    /**
     * Weapon's constructor with the common attributes: name, weight, damage.
     */
    protected AbstractWeapon(@NotNull String name, int weight, int damage) {
      this.name = name;
      this.weight = weight;
      this.damage = damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage() {
        return this.damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWeight() {
        return this.weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNull(){
      return false;
    }


    /**
     * Compares this object to the specified object and returns true if represents the same weapon.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof IWeapon) {
            final IWeapon weapon = (IWeapon) o;
            return getDamage() == weapon.getDamage() &&
                    getWeight() == weapon.getWeight() &&
                    getName().equals(weapon.getName()) &&
                    getType().equals(weapon.getType());
        }
        return false;
    }

    /**
     * Returns the hash code for the name, weight, damage and type of this weapon.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage(), getType());
    }
}

