package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.Knight;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.weapon.Axe;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the knight characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class KnightTest extends AbstractCharacterTest{

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
            testIWeapon = new Sword("Test", 10, 15);
            testCharacters.add(new Knight(turns, KNIGHT_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new Knight(turns, KNIGHT_NAME),
            testCharacters.get(0),
            new Knight(turns, "NotEquals"),
            new Thief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new Knight(turns, KNIGHT_NAME);
        var testIWeapon = new Axe(KNIGHT_NAME, 15, 10);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}
