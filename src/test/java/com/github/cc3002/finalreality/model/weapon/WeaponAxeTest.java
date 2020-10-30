package com.github.cc3002.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponAxeTest extends AbstractWeaponTest{
    private static final String AXE_NAME = "Test Axe";
    private IWeapon testAxe;
    private WeaponSword WeaponTestNot;
    private WeaponAxe weakAxe;
    private WeaponAxe slowAxe;
    private WeaponAxe WeaponTestNotName;

    @BeforeEach
    void setUp() {
        WeaponTestNot = new WeaponSword("notEquals", SPEED, DAMAGE);
        testAxe = new WeaponAxe(AXE_NAME, SPEED, DAMAGE);
        weakAxe = new WeaponAxe(AXE_NAME, SPEED, 1);
        slowAxe = new WeaponAxe(AXE_NAME, 1, DAMAGE);
        WeaponTestNotName = new WeaponAxe("notEquals", SPEED, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new WeaponAxe(AXE_NAME, SPEED, DAMAGE);
        assertEquals(testAxe, testAxe);
        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
        assertNotEquals(weakAxe, testAxe);
        assertNotEquals(weakAxe.hashCode(), testAxe.hashCode());
        assertNotEquals(slowAxe, testAxe);
        assertNotEquals(slowAxe.hashCode(), testAxe.hashCode());
        assertNotEquals(WeaponTestNot, testAxe);
        assertNotEquals(WeaponTestNot.hashCode(), testAxe.hashCode());
        assertNotEquals(testAxe,WeaponTestNotName);
        assertNotEquals(testAxe.hashCode(), WeaponTestNotName.hashCode());
    }
}
