package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.Axe;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the axe weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class AxeTest extends AbstractWeaponTest{

    /**
     * Name to creates a axe weapon to test.
     */
    private static final String AXE_NAME = "Test Axe";

    /**
     * Weapon to test.
     */
    private IWeapon testAxe;

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
    private IWeapon weakAxe;

    /**
     * Different weight weapon to test.
     */
    private IWeapon differentWeightWeapon;

    /**
     * Creates the variables for the axe weapon tests.
     */
    @BeforeEach
    void setUp() {
        WeaponTestNot = new Sword(AXE_NAME, WEIGHT, DAMAGE);
        testAxe = new Axe(AXE_NAME, WEIGHT, DAMAGE);
        WeaponTestNotName = new Axe("notEquals", WEIGHT, DAMAGE);
        weakAxe = new Axe(AXE_NAME, WEIGHT, 1);
        differentWeightWeapon = new Axe(AXE_NAME, 1, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedAxe = new Axe(AXE_NAME, WEIGHT, DAMAGE);
        checkConstruction(expectedAxe,
                testAxe,
                WeaponTestNotName,
                WeaponTestNot,
                weakAxe,
                differentWeightWeapon);
    }
}
