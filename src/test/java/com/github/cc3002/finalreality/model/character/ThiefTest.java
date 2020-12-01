package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.Knight;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.character.player.WhiteMage;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the thief characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class ThiefTest extends AbstractNonMageTest{

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
        testIWeapon = new Sword("Test", 10, 15);
        testCharacters.add(new Thief(turns, THIEF_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new Thief(turns, THIEF_NAME),
            testCharacters.get(0),
            new Thief(turns, "NotEquals"),
            new WhiteMage(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new Thief(turns, THIEF_NAME);
        var testIWeapon = new Sword("Test", 15, 10);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }

    @Test
    void checkAttackTest() {
        this.checkAttack(new Thief(turns, THIEF_NAME),
                testCharacters.get(0), new Knight(turns, "NotEquals"));
    }

    @Test
    void checkLethalAttackTest() {
        this.checkLethalAttack(new Thief(turns, THIEF_NAME),
                testCharacters.get(0), new Knight(turns, "NotEquals"));
    }
}
