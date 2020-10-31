package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterKnight;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the knight characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class CharacterKnightTest extends AbstractCharacterTest{

    /**
     * Name to creates a knight character to test.
     */
    private static final String KNIGHT_NAME = "Adelbert";

    /**
     * Creates the variables for the knight character tests.
     */
    @BeforeEach
        void setUp() {
            super.basicSetUp();
            testCharacters.add(new CharacterKnight(turns, KNIGHT_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new CharacterKnight(turns, KNIGHT_NAME),
            testCharacters.get(0),
            new CharacterKnight(turns, "NotEquals"),
            new CharacterThief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new CharacterKnight(turns, KNIGHT_NAME);
        var testIWeapon = new WeaponAxe(KNIGHT_NAME, 15, 10);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}
