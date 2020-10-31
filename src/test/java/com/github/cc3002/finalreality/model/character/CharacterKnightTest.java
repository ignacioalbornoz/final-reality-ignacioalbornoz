package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterKnight;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterKnightTest extends AbstractPlayerCharacterTest{
        private static final String KNIGHT_NAME = "Adelbert";

    @BeforeEach
        void setUp() {
            super.basicSetUp();
            testCharacters.add(new CharacterKnight(turns, KNIGHT_NAME));

        }

    @Test
    void constructorTest() { checkConstruction(new CharacterKnight(turns, KNIGHT_NAME),
            testCharacters.get(0),
            new CharacterKnight(turns, "NotEquals"),
            new CharacterThief(turns, "NotEquals"));
    }
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
