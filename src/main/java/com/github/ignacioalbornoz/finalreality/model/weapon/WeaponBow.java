package com.github.ignacioalbornoz.finalreality.model.weapon;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WeaponBow extends AbstractWeapon{
    public WeaponBow(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "BOW";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeaponBow)) {
            return false;
        }
        final WeaponBow IWeapon = (WeaponBow) o;
        return getDamage() == IWeapon.getDamage() &&
                getWeight() == IWeapon.getWeight() &&
                getName().equals(IWeapon.getName());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage(), getType());
    }
}
