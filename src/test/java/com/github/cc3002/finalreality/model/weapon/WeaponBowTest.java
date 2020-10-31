package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponBow;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the bow weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponBowTest extends AbstractWeaponTest{

    /**
     * Name to creates a bow weapon to test.
     */
    private static final String BOW_NAME = "Test Bow";

    /**
     * Weapon to test.
     */
    private IWeapon testBow;

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
    private IWeapon weakBow;

    /**
     * Different weight weapon to test.
     */
    private IWeapon differentWeightWeapon;

    /**
     * Creates the variables for the bow weapon tests.
     */
    @BeforeEach
    void setUp() {
        testBow = new WeaponBow(BOW_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(BOW_NAME, SPEED, DAMAGE);
        weakBow = new WeaponBow(BOW_NAME, SPEED, 1);
        WeaponTestNotName = new WeaponBow("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponBow(BOW_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedBow = new WeaponBow(BOW_NAME, SPEED, DAMAGE);
        checkConstruction(expectedBow,
                testBow,
                WeaponTestNotName,
                WeaponTestNot,
                weakBow,
                differentWeightWeapon);
    }
}
