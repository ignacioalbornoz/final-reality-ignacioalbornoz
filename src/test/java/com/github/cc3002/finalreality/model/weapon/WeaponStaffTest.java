package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponStaff;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the staff weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponStaffTest extends AbstractWeaponTest{

    /**
     * Name to creates a staff weapon to test.
     */
    private static final String STAFF_NAME = "Test Staff";

    /**
     * Weapon to test.
     */
    private IWeapon testStaff;

    /**
     * Different type weapon to test.
     */
    private IWeapon WeaponTestNot;

    /**
     * Different name weapon to test.
     */
    private IWeapon WeaponTestNotName;

    /**
     * Lower damage weapon to test.
     */
    private IWeapon weakStaff;

    /**
     * Different weight weapon to test.
     */
    private IWeapon differentWeightWeapon;

    /**
     * Creates the variables for the staff weapon tests.
     */
    @BeforeEach
    void setUp() {
        testStaff = new WeaponStaff(STAFF_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(STAFF_NAME, SPEED, DAMAGE);
        weakStaff = new WeaponStaff(STAFF_NAME, SPEED, 1);
        WeaponTestNotName = new WeaponStaff("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponStaff(STAFF_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
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
