package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponBow;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponNullTest extends AbstractWeaponTest{

    private IWeapon testNull;
    private WeaponSword WeaponTestNot;
    private WeaponBow WeaponTestNotName;

    @BeforeEach
    void setUp() {
        testNull = new WeaponNull();
        WeaponTestNot = new WeaponSword("notEquals", SPEED, DAMAGE);
        WeaponTestNotName = new WeaponBow("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedNull = new WeaponNull();
        assertEquals(testNull, testNull);
        assertEquals(expectedNull, testNull);
        assertEquals(expectedNull.hashCode(), testNull.hashCode());
        assertNotEquals(WeaponTestNot, testNull);
        assertNotEquals(WeaponTestNot.hashCode(), testNull.hashCode());
        assertNotEquals(testNull,WeaponTestNotName);
        assertNotEquals(testNull.hashCode(),WeaponTestNotName.hashCode());
    }
}

