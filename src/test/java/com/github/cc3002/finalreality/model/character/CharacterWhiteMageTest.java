package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterBlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterWhiteMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterWhiteMageTest extends AbstractPlayerCharacterTest{
    private static final String WHITE_MAGE_NAME = "Eiko";


    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterWhiteMage(WHITE_MAGE_NAME,turns));

    }

    @Test
    void constructorTest() { checkConstruction(new CharacterWhiteMage(WHITE_MAGE_NAME, turns),
                testCharacters.get(0),
            new CharacterWhiteMage("NotEquals", turns),
                new CharacterThief("NotEquals", turns));
    }

    @Test
    void equipWeaponTest() {
        var character = new CharacterWhiteMage(WHITE_MAGE_NAME,turns);
        var testIWeapon = new WeaponAxe("Test", 15, 10);
        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);
        assertEquals(testIWeapon, character.getEquippedWeapon());
    }
}
