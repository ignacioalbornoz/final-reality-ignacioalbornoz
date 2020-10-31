package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponNullTest extends AbstractWeaponTest{

    private IWeapon testNull;
    private IWeapon WeaponTestNot;

    @BeforeEach
    void setUp() {
        testNull = new WeaponNull();
        WeaponTestNot = new WeaponSword("notEquals", SPEED, DAMAGE);
    }

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

