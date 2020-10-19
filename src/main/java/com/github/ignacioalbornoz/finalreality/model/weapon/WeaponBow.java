package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

public class WeaponBow extends AbstractWeapon{
    protected WeaponBow(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "BOW";
    }
}
