package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterWhiteMage;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the thief characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterThiefTest extends AbstractCharacterTest{

    /**
     * Name to creates a thief character to test.
     */
    private static final String THIEF_NAME = "Zidane";

    /**
     * Creates the variables for the thief character tests.
     */
    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterThief(turns, THIEF_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new CharacterThief(turns, THIEF_NAME),
            testCharacters.get(0),
            new CharacterThief(turns, "NotEquals"),
            new CharacterWhiteMage(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new CharacterThief(turns, THIEF_NAME);
        var testIWeapon = new WeaponAxe("Test", 15, 10);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}
