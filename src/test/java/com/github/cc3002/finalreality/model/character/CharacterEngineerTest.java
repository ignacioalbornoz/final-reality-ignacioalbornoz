package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
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
        testCharacters.add(new CharacterEngineer(ENGINEER_NAME, turns));
    }

    @Test
    void constructorTest() { checkConstruction(new CharacterEngineer(ENGINEER_NAME, turns),
            testCharacters.get(0),
            new CharacterEngineer("NotEquals", turns),
            new CharacterThief("NotEquals", turns));
    }
    @Test
    void equipWeaponTest() {
        var testIWeapon = new WeaponAxe("Test", 15, 10);
        var character = new CharacterEngineer(ENGINEER_NAME, turns);
        character.equip(testIWeapon);
        assertEquals(testIWeapon, character.getEquippedWeapon());
    }
}

