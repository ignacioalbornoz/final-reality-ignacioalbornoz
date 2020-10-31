package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterWhiteMage;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterThiefTest extends AbstractPlayerCharacterTest{
    private static final String THIEF_NAME = "Zidane";

    @BeforeEach
    void setUp() {
        basicSetUp();
        testCharacters.add(new CharacterThief(turns, THIEF_NAME));

    }

    @Test
    void constructorTest() { checkConstruction(new CharacterThief(turns, THIEF_NAME),
            testCharacters.get(0),
            new CharacterThief(turns, "NotEquals"),
            new CharacterWhiteMage(turns, "NotEquals"));
    }
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
