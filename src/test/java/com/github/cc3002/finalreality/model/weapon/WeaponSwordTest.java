package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponSwordTest extends AbstractWeaponTest{

    private static final String SWORD_NAME = "Test Sword";
    private IWeapon testSword;
    private IWeapon weakSword;
    private IWeapon WeaponTestNotName;
    private IWeapon WeaponTestNot;
    private IWeapon differentWeightWeapon;

    @BeforeEach
    void setUp() {
        testSword = new WeaponSword(SWORD_NAME, SPEED, DAMAGE);
        weakSword = new WeaponSword(SWORD_NAME, SPEED, 1);
        WeaponTestNotName = new WeaponSword("notEquals", SPEED, DAMAGE);
        WeaponTestNot = new WeaponAxe(SWORD_NAME, SPEED, DAMAGE);
        differentWeightWeapon = new WeaponSword(SWORD_NAME, 1, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedSword = new WeaponSword(SWORD_NAME, SPEED, DAMAGE);
        checkConstruction(expectedSword,
                testSword,
                WeaponTestNotName,
                WeaponTestNot,
                weakSword,
                differentWeightWeapon);
    }
}
