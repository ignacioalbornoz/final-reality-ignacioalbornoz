package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponStaff;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponStaffTest extends AbstractWeaponTest{
    private static final String STAFF_NAME = "Test Staff";
    private IWeapon testStaff;
    private IWeapon testSword;
    private IWeapon weakStaff;
    private IWeapon slowStaff;
    private IWeapon WeaponTestNotName;
    private IWeapon WeaponTestNot;
    private IWeapon differentWeightWeapon;

    @BeforeEach
    void setUp() {
        testStaff = new WeaponStaff(STAFF_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(STAFF_NAME, SPEED, DAMAGE);
        testSword = new WeaponSword(STAFF_NAME, SPEED, DAMAGE);
        weakStaff = new WeaponStaff(STAFF_NAME, SPEED, 1);
        slowStaff = new WeaponStaff(STAFF_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponStaff("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponStaff(STAFF_NAME, 1, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedStaff = new WeaponStaff(STAFF_NAME, SPEED, DAMAGE);
        checkConstruction(expectedStaff,
                testStaff,
                WeaponTestNotName,
                WeaponTestNot,
                weakStaff,
                differentWeightWeapon);
    }
}
