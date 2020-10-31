package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterWhiteMage;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the white mage characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterWhiteMageTest extends AbstractCharacterTest{

    /**
     * Name to creates a white mage character to test.
     */
    private static final String WHITE_MAGE_NAME = "Eiko";

    /**
     * Creates the variables for the white mage character tests.
     */
    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterWhiteMage(turns, WHITE_MAGE_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new CharacterWhiteMage(turns, WHITE_MAGE_NAME),
                testCharacters.get(0),
            new CharacterWhiteMage(turns, "NotEquals"),
                new CharacterThief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new CharacterWhiteMage(turns, WHITE_MAGE_NAME);
        var testIWeapon = new WeaponAxe("Test", 15, 10);


        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}
