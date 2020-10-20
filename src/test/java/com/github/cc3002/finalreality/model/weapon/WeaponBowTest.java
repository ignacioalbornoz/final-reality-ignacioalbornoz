package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponBow;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponBowTest extends AbstractWeaponTest{
    private static final String BOW_NAME = "Test Bow";
    private IWeapon testBow;
    private WeaponSword WeaponTestNot;
    private WeaponBow weakBow;
    private WeaponBow slowBow;
    private WeaponBow WeaponTestNotName;

    @BeforeEach
    void setUp() {
        testBow = new WeaponBow(BOW_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword("notEquals", SPEED, DAMAGE);
        weakBow = new WeaponBow(BOW_NAME, SPEED, 1);
        slowBow = new WeaponBow(BOW_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponBow("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedBow = new WeaponBow(BOW_NAME, SPEED, DAMAGE);
        assertEquals(testBow, testBow);
        assertEquals(expectedBow, testBow);
        assertEquals(expectedBow.hashCode(), testBow.hashCode());
        assertNotEquals(weakBow, testBow);
        assertNotEquals(weakBow.hashCode(), testBow.hashCode());
        assertNotEquals(slowBow, testBow);
        assertNotEquals(slowBow.hashCode(), testBow.hashCode());
        assertNotEquals(WeaponTestNot, testBow);
        assertNotEquals(WeaponTestNot.hashCode(), testBow.hashCode());
        assertNotEquals(testBow,WeaponTestNotName);
        assertNotEquals(testBow.hashCode(),WeaponTestNotName.hashCode());
    }
}
