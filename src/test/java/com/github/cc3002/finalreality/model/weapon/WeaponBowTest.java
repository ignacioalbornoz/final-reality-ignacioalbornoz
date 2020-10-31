package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponBow;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponBowTest extends AbstractWeaponTest{
    private static final String BOW_NAME = "Test Bow";
    private IWeapon testBow;
    private IWeapon WeaponTestNot;
    private IWeapon weakBow;
    private IWeapon slowBow;
    private IWeapon WeaponTestNotName;
    private IWeapon differentWeightWeapon;

    @BeforeEach
    void setUp() {
        testBow = new WeaponBow(BOW_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(BOW_NAME, SPEED, DAMAGE);
        weakBow = new WeaponBow(BOW_NAME, SPEED, 1);
        slowBow = new WeaponBow(BOW_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponBow("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponBow(BOW_NAME, 1, DAMAGE);
    }

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
