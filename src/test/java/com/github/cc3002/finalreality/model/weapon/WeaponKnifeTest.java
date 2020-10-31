package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponKnife;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the knife weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponKnifeTest extends AbstractWeaponTest{

    /**
     * Name to creates a knife weapon to test.
     */
    private static final String KNIFE_NAME = "Test Knife";

    /**
     * Weapon to test.
     */
    private IWeapon testKnife;

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
    private IWeapon weakKnife;

    /**
     * Different weight weapon to test.
     */
    private IWeapon differentWeightWeapon;

    /**
     * Creates the variables for the knife weapon tests.
     */
    @BeforeEach
    void setUp() {
        testKnife = new WeaponKnife(KNIFE_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(KNIFE_NAME, SPEED, DAMAGE);
        weakKnife = new WeaponKnife(KNIFE_NAME, SPEED, 1);
        WeaponTestNotName = new WeaponKnife("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponKnife(KNIFE_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedKnife = new WeaponKnife(KNIFE_NAME, SPEED, DAMAGE);
        checkConstruction(expectedKnife,
                testKnife,
                WeaponTestNotName,
                WeaponTestNot,
                weakKnife,
                differentWeightWeapon);
    }
}
