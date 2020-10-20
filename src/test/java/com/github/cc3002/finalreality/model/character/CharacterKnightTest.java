package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterBlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterEngineer;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterKnight;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterKnightTest extends AbstractPlayerCharacterTest{
    private String characterName;
    private ICharacter character;
    private static final String KNIGHT_NAME = "Adelbert";
    ICharacter lol;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        character = new CharacterKnight(KNIGHT_NAME, turns);
        characterName = character.getName();
        testCharacters.add(character);

    }

    @Test
    void constructorTest() {
        var xd = new CharacterBlackMage(characterName, turns);
        var uwu = new CharacterThief(characterName, turns);
        var enemy = new Enemy("Enemy", 10, turns);
        if (character.getCharacterClass().equals("THIEF")) {
            lol = xd;
        } else {
            lol = uwu;
        }
        checkConstruction(new CharacterKnight(characterName, turns), character, new CharacterKnight("Test", turns), lol);
        assertNotEquals(character, enemy);
    }
    @Test
    void equipWeaponTest() {
        assertNull(character.getEquippedWeapon());
        character.equip(testIWeapon);
        assertEquals(testIWeapon, character.getEquippedWeapon());
    }
}
