package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.Engineer;
import com.github.ignacioalbornoz.finalreality.model.character.player.Knight;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the engineer characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
class EngineerTest extends AbstractNonMageTest {

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
        testIWeapon = new Axe("Test", 10, 15);
        testCharacters.add(new Engineer(turns, ENGINEER_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new Engineer(turns, ENGINEER_NAME),
            testCharacters.get(0),
            new Engineer(turns, "NotEquals"),
            new Thief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var testIWeapon = new Axe("Test", 15, 10);
        var character = new Engineer(turns, ENGINEER_NAME);

        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }

    @Test
    void checkAttackTest() {
        this.checkAttack(new Engineer(turns, ENGINEER_NAME),
                testCharacters.get(0), new Knight(turns, "NotEquals"));
    }

    @Test
    void checkLethalAttackTest() {
        this.checkLethalAttack(new Engineer(turns, ENGINEER_NAME),
                testCharacters.get(0), new Knight(turns, "NotEquals"));
    }
}

