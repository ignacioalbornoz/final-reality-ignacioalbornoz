package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

public class WeaponStaff extends AbstractWeapon{
    protected WeaponStaff(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

