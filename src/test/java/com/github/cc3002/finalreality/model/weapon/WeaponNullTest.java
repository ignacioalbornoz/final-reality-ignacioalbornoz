package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common tests for the null weapons.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WeaponNullTest extends AbstractWeaponTest{

    /**
     * Weapon to test.
     */
    private IWeapon testNull;

    /**
     * Different type weapon to test.
     */
    private IWeapon WeaponTestNot;

    /**
     * Creates the variables for the null weapon tests.
     */
    @BeforeEach
    void setUp() {
        testNull = new WeaponNull();
        WeaponTestNot = new Sword("notEquals", WEIGHT, DAMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        var expectedNull = new WeaponNull();
        checkConstruction(expectedNull,
                testNull,
                WeaponTestNot,
                WeaponTestNot,
                WeaponTestNot,
                WeaponTestNot);
    }
}

