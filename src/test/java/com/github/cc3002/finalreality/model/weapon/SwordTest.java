package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.Axe;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the sword weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class SwordTest extends AbstractWeaponTest{

    /**
     * Name to creates a sword weapon to test.
     */
    private static final String SWORD_NAME = "Test Sword";

    /**
     * Weapon to test.
     */
    private IWeapon testSword;

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
    private IWeapon weakSword;

    /**
     * Different weight weapon to test.
     */
    private IWeapon differentWeightWeapon;

    /**
     * Creates the variables for the sword weapon tests.
     */
    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, SPEED, DAMAGE);
        weakSword = new Sword(SWORD_NAME, SPEED, 1);
        WeaponTestNotName = new Sword("notEquals", SPEED, DAMAGE);
        WeaponTestNot = new Axe(SWORD_NAME, SPEED, DAMAGE);
        differentWeightWeapon = new Sword(SWORD_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedSword = new Sword(SWORD_NAME, SPEED, DAMAGE);
        checkConstruction(expectedSword,
                testSword,
                WeaponTestNotName,
                WeaponTestNot,
                weakSword,
                differentWeightWeapon);
    }
}
