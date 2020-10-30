package com.github.ignacioalbornoz.finalreality.model.weapon;

public class WeaponNull extends AbstractWeapon{
    public WeaponNull() {
        super("null", 0, 0);
    }

    @Override
    public String getType() {
        return "null";
    }

    @Override
    public boolean isNull(){
        return true;
    }
}
