package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

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
}

