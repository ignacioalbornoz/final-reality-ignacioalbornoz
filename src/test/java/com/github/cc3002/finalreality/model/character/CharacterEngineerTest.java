package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CharacterEngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Cid";


    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterEngineer(turns, ENGINEER_NAME));
    }

    @Test
    void constructorTest() { checkConstruction(new CharacterEngineer(turns, ENGINEER_NAME),
            testCharacters.get(0),
            new CharacterEngineer(turns, "NotEquals"),
            new CharacterThief(turns, "NotEquals"));
    }
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

