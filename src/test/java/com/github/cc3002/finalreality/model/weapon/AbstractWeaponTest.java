package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class AbstractWeaponTest{

    static final int DAMAGE = 15;
    static final int SPEED = 10;


    protected void checkConstruction(final IWeapon expectedWeapon,
                                     final IWeapon testEqualWeapon,
                                     final IWeapon differentNameWeapon,
                                     final IWeapon differentClassWeapon,
                                     final IWeapon differentDamageWeapon,
                                     final IWeapon differentWeightWeapon) {

        assertNotEquals(new WeaponNull(), "test");
        assertNotEquals(new WeaponNull().hashCode(), "test".hashCode());

        assertEquals(expectedWeapon, testEqualWeapon);
        assertEquals(expectedWeapon.hashCode(), testEqualWeapon.hashCode());

        assertNotEquals(differentNameWeapon, testEqualWeapon);
        assertNotEquals(differentNameWeapon.hashCode(), testEqualWeapon.hashCode());

        assertNotEquals(testEqualWeapon, differentClassWeapon);
        assertNotEquals(testEqualWeapon.hashCode(), differentClassWeapon.hashCode());

        assertNotEquals(testEqualWeapon, differentDamageWeapon);
        assertNotEquals(testEqualWeapon.hashCode(), differentDamageWeapon.hashCode());

        assertNotEquals(testEqualWeapon, differentWeightWeapon);
        assertNotEquals(testEqualWeapon.hashCode(), differentWeightWeapon.hashCode());

    }
}
