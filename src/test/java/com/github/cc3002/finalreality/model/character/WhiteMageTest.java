package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.BlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.character.player.WhiteMage;
import com.github.ignacioalbornoz.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common tests for the white mage characters.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class WhiteMageTest extends AbstractMageTest{

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
        testIWeapon = new Staff("Test", 10, 15);
        testCharacters.add(new WhiteMage(turns, WHITE_MAGE_NAME));
    }

    /**
     * {@inheritDoc}
     */
    @Test
    void constructorTest() { checkConstruction(new WhiteMage(turns, WHITE_MAGE_NAME),
                testCharacters.get(0),
            new WhiteMage(turns, "NotEquals"),
                new Thief(turns, "NotEquals"));
    }

    /**
     * Checks that the weapons equipment works correctly.
     */
    @Test
    void equipWeaponTest() {
        var character = new WhiteMage(turns, WHITE_MAGE_NAME);
        var testIWeapon = new Staff("Test", 15, 10);


        assertTrue(character.getEquippedWeapon().isNull());
        character.equip(testIWeapon);

        assertEquals(testIWeapon, character.getEquippedWeapon());
        assertEquals(testIWeapon.hashCode(), character.getEquippedWeapon().hashCode());

        assertFalse(character.getEquippedWeapon().isNull());
    }

    @Test
    void checkAttackTest() {
        this.checkAttack(new WhiteMage(turns, WHITE_MAGE_NAME),
                testCharacters.get(0), new Thief(turns, "NotEquals"));
    }

    @Test
    void checkLethalAttackTest() {
        this.checkLethalAttack(new WhiteMage(turns, WHITE_MAGE_NAME),
                testCharacters.get(0), new Thief(turns, "NotEquals"));
    }

    @Test
    void checkDeathNotificationTest() {
        this.checkDeathNotification(new WhiteMage(turns, WHITE_MAGE_NAME), (IPlayerCharacter) testCharacters.get(0));
    }

}
