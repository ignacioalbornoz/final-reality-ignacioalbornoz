package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterBlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterBlackMageTest extends AbstractPlayerCharacterTest{
    private static final String BLACK_MAGE_NAME = "Vivi";

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testCharacters.add(new CharacterBlackMage(BLACK_MAGE_NAME, turns));

    }

    @Test
    void constructorTest() {
        checkConstruction(new CharacterBlackMage(BLACK_MAGE_NAME, turns),
            testCharacters.get(0),
            new CharacterBlackMage("NotEquals", turns),
            new CharacterThief("NotEquals", turns));

    }

    @Test
    void equipWeaponTest() {
        var character = new CharacterBlackMage(BLACK_MAGE_NAME, turns);
        var testIWeapon = new WeaponAxe("Test", 15, 10);
        assertNotEquals(character,testIWeapon);
        assertNotEquals(character.hashCode(),testIWeapon.hashCode());
        assertNotEquals(testIWeapon,character);
        assertNotEquals(testIWeapon.hashCode(),character.hashCode());
        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);
        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertFalse(character.getEquippedWeapon().isNull());
    }
}
