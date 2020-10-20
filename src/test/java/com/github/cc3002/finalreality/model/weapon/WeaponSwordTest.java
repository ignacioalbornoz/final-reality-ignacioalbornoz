package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponStaff;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponSwordTest extends AbstractWeaponTest{
    private static final String SWORD_NAME = "Test Sword";
    private IWeapon testSword;
    private IWeapon testStaff;
    private WeaponSword weakSword;
    private WeaponSword slowSword;
    private WeaponSword WeaponTestNotName;

    @BeforeEach
    void setUp() {
        testSword = new WeaponSword(SWORD_NAME, SPEED, DAMAGE);
        testStaff = new WeaponStaff(SWORD_NAME, SPEED, DAMAGE);
        weakSword = new WeaponSword(SWORD_NAME, SPEED, 1);
        slowSword = new WeaponSword(SWORD_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponSword("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedSword = new WeaponSword(SWORD_NAME, SPEED, DAMAGE);
        assertEquals(testSword, testSword);
        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());
        assertNotEquals(weakSword, testSword);
        assertNotEquals(weakSword.hashCode(), testSword.hashCode());
        assertNotEquals(slowSword, testSword);
        assertNotEquals(slowSword.hashCode(), testSword.hashCode());
        assertNotEquals(testStaff, testSword);
        assertNotEquals(testStaff.hashCode(), testSword.hashCode());
        assertNotEquals(testSword, testStaff);
        assertNotEquals(testSword.hashCode(), testStaff.hashCode());
        assertNotEquals(testSword, WeaponTestNotName);
        assertNotEquals(testSword.hashCode(), WeaponTestNotName.hashCode());
    }
}
