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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IWeapon)) {
            return false;
        }
        final IWeapon IWeapon = (IWeapon) o;
        return getDamage() == IWeapon.getDamage() &&
                getWeight() == IWeapon.getWeight() &&
                getName().equals(IWeapon.getName()) &&
                getType().equals(IWeapon.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }
}
