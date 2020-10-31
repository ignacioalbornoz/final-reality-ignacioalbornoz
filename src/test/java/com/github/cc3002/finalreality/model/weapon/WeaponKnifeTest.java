package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponKnife;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponKnifeTest extends AbstractWeaponTest{
    private static final String KNIFE_NAME = "Test Knife";
    private IWeapon testKnife;
    private IWeapon WeaponTestNot;
    private IWeapon weakKnife;
    private IWeapon slowKnife;
    private IWeapon WeaponTestNotName;
    private IWeapon differentWeightWeapon;

    @BeforeEach
    void setUp() {
        testKnife = new WeaponKnife(KNIFE_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword(KNIFE_NAME, SPEED, DAMAGE);
        weakKnife = new WeaponKnife(KNIFE_NAME, SPEED, 1);
        slowKnife = new WeaponKnife(KNIFE_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponKnife("notEquals", SPEED, DAMAGE);
        differentWeightWeapon = new WeaponKnife(KNIFE_NAME, 1, DAMAGE);
    }

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
