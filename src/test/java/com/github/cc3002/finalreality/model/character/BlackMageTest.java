package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.BlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the black mage characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class BlackMageTest extends AbstractCharacterTest{

    /**
     * Name to creates a black mage character to test.
     */
    private static final String BLACK_MAGE_NAME = "Vivi";

    /**
     * Creates the variables for the black mage character tests.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testCharacters.add(new BlackMage(turns, BLACK_MAGE_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(turns, BLACK_MAGE_NAME),
            testCharacters.get(0),
            new BlackMage(turns, "NotEquals"),
            new Thief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new BlackMage(turns, BLACK_MAGE_NAME);
        var testIWeapon = new Axe(BLACK_MAGE_NAME, 15, 10);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }
}
