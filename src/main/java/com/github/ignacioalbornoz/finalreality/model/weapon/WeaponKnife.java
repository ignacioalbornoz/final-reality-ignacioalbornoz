package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

public class WeaponKnife extends AbstractWeapon{

    protected WeaponKnife(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "KNIFE";
    }
}
