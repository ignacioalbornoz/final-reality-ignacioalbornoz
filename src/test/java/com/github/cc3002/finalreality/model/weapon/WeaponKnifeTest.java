package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponKnife;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponKnifeTest extends AbstractWeaponTest{
    private static final String KNIFE_NAME = "Test Knife";
    private IWeapon testKnife;
    private IWeapon WeaponTestNot;
    private WeaponKnife weakKnife;
    private WeaponKnife slowKnife;
    private WeaponKnife WeaponTestNotName;

    @BeforeEach
    void setUp() {
        testKnife = new WeaponKnife(KNIFE_NAME, SPEED, DAMAGE);
        WeaponTestNot = new WeaponSword("notEquals", SPEED, DAMAGE);
        weakKnife = new WeaponKnife(KNIFE_NAME, SPEED, 1);
        slowKnife = new WeaponKnife(KNIFE_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponKnife("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedKnife = new WeaponKnife(KNIFE_NAME, SPEED, DAMAGE);
        assertEquals(testKnife, testKnife);
        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
        assertNotEquals(weakKnife, testKnife);
        assertNotEquals(weakKnife.hashCode(), testKnife.hashCode());
        assertNotEquals(slowKnife, testKnife);
        assertNotEquals(slowKnife.hashCode(), testKnife.hashCode());
        assertNotEquals(WeaponTestNot, testKnife);
        assertNotEquals(WeaponTestNot.hashCode(), testKnife.hashCode());
        assertNotEquals(testKnife,WeaponTestNotName);
        assertNotEquals(testKnife.hashCode(),WeaponTestNotName.hashCode());
    }
}
