package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.Bow;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the bow weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class BowTest extends AbstractWeaponTest{

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
        testBow = new Bow(BOW_NAME, WEIGHT, DAMAGE);
        WeaponTestNot = new Sword(BOW_NAME, WEIGHT, DAMAGE);
        weakBow = new Bow(BOW_NAME, WEIGHT, 1);
        WeaponTestNotName = new Bow("notEquals", WEIGHT, DAMAGE);
        differentWeightWeapon = new Bow(BOW_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedBow = new Bow(BOW_NAME, WEIGHT, DAMAGE);
        checkConstruction(expectedBow,
                testBow,
                WeaponTestNotName,
                WeaponTestNot,
                weakBow,
                differentWeightWeapon);
    }
}
