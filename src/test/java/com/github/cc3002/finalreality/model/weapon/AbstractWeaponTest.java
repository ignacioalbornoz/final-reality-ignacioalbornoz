package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of weapons.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 * @see IWeapon
 */
public abstract class AbstractWeaponTest{

    /**
     * Damage to creates weapons to test.
     */
    static final int DAMAGE = 15;

    /**
     * Weight to creates weapons to test.
     */
    static final int WEIGHT = 10;

    /**
     * Checks that the weapon's constructor works properly.
     */
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
