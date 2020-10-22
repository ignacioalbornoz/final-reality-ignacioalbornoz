package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WeaponSword extends AbstractWeapon{
    public WeaponSword(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "SWORD";
    }

}



