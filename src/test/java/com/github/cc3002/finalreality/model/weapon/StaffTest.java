package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.Staff;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the staff weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class StaffTest extends AbstractWeaponTest{

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
        testStaff = new Staff(STAFF_NAME, WEIGHT, DAMAGE);
        WeaponTestNot = new Sword(STAFF_NAME, WEIGHT, DAMAGE);
        weakStaff = new Staff(STAFF_NAME, WEIGHT, 1);
        WeaponTestNotName = new Staff("notEquals", WEIGHT, DAMAGE);
        differentWeightWeapon = new Staff(STAFF_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME, WEIGHT, DAMAGE);
        checkConstruction(expectedStaff,
                testStaff,
                WeaponTestNotName,
                WeaponTestNot,
                weakStaff,
                differentWeightWeapon);
    }
}
