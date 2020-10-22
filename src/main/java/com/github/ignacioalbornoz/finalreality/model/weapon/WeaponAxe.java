package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WeaponAxe extends AbstractWeapon{
    public WeaponAxe(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "AXE";
    }


}
