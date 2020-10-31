package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the engineer characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
class CharacterEngineerTest extends AbstractCharacterTest {

    /**
     * Name to creates a engineer character to test.
     */
    private static final String ENGINEER_NAME = "Cid";

    /**
     * Creates the variables for the engineer character tests.
     */
    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterEngineer(turns, ENGINEER_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new CharacterEngineer(turns, ENGINEER_NAME),
            testCharacters.get(0),
            new CharacterEngineer(turns, "NotEquals"),
            new CharacterThief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var testIWeapon = new WeaponAxe("Test", 15, 10);
        var character = new CharacterEngineer(turns, ENGINEER_NAME);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}

