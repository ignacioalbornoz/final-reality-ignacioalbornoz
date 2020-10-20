package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponStaff;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponStaffTest extends AbstractWeaponTest{
    private static final String STAFF_NAME = "Test Staff";
    private IWeapon testStaff;
    private IWeapon testSword;
    private WeaponStaff weakStaff;
    private WeaponStaff slowStaff;
    private WeaponStaff WeaponTestNotName;

    @BeforeEach
    void setUp() {
        testStaff = new WeaponStaff(STAFF_NAME, SPEED, DAMAGE);
        testSword = new WeaponSword(STAFF_NAME, SPEED, DAMAGE);
        weakStaff = new WeaponStaff(STAFF_NAME, SPEED, 1);
        slowStaff = new WeaponStaff(STAFF_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponStaff("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedStaff = new WeaponStaff(STAFF_NAME, SPEED, DAMAGE);
        assertEquals(testStaff, testStaff);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
        assertNotEquals(weakStaff, testStaff);
        assertNotEquals(weakStaff.hashCode(), testStaff.hashCode());
        assertNotEquals(slowStaff, testStaff);
        assertNotEquals(slowStaff.hashCode(), testStaff.hashCode());
        assertNotEquals(testSword, testStaff);
        assertNotEquals(testSword.hashCode(), testStaff.hashCode());
        assertNotEquals(testStaff, testSword);
        assertNotEquals(testStaff.hashCode(), testSword.hashCode());
        assertNotEquals(testStaff, WeaponTestNotName);
        assertNotEquals(testStaff.hashCode(), WeaponTestNotName.hashCode());
    }
}
