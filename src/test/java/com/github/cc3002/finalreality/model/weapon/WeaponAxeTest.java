package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponAxeTest extends AbstractWeaponTest{
    private static final String AXE_NAME = "Test Axe";
    private IWeapon testAxe;
    private IWeapon WeaponTestNot;
    private IWeapon WeaponTestNotName;

    private IWeapon weakAxe;
    private IWeapon differentWeightWeapon;

    @BeforeEach
    void setUp() {
        WeaponTestNot = new WeaponSword(AXE_NAME, SPEED, DAMAGE);
        testAxe = new WeaponAxe(AXE_NAME, SPEED, DAMAGE);
        WeaponTestNotName = new WeaponAxe("notEquals", SPEED, DAMAGE);
        weakAxe = new WeaponAxe(AXE_NAME, SPEED, 1);
        differentWeightWeapon = new WeaponAxe(AXE_NAME, 1, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new WeaponAxe(AXE_NAME, SPEED, DAMAGE);
        checkConstruction(expectedAxe,
                testAxe,
                WeaponTestNotName,
                WeaponTestNot,
                weakAxe,
                differentWeightWeapon);
    }
}
