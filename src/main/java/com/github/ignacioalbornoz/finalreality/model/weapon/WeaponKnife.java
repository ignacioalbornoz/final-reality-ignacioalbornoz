package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WeaponKnife extends AbstractWeapon{

    public WeaponKnife(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "KNIFE";
    }


}
