package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class AbstractWeapon implements IWeapon{
    protected final String name;
    protected final int weight;
    protected final int damage;


  protected AbstractWeapon(@NotNull String name, int weight, int damage) {
      this.name = name;
      this.weight = weight;
      this.damage = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IWeapon) {
            final IWeapon weapon = (IWeapon) o;
            return getDamage() == weapon.getDamage() &&
                    getWeight() == weapon.getWeight() &&
                    getName().equals(weapon.getName()) && getType().equals(weapon.getType());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage(), getType());
    }

    @Override
    public boolean isNull(){
      return false;
    }
}

