package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest{

    @Override
    protected void checkAttack(final ICharacter expectedCharacter, final ICharacter testEqualCharacter, final ICharacter differentClassCharacter) {
        expectedCharacter.equip(testIWeapon);
        testEqualCharacter.equip(testIWeapon);
        differentClassCharacter.equip(testIWeapon);
        expectedCharacter.attack(testEqualCharacter);
        testEqualCharacter.attack(expectedCharacter);
        assertEquals(expectedCharacter.getHP(),testEqualCharacter.getHP());
        differentClassCharacter.attack(expectedCharacter);
        differentClassCharacter.attack(testEqualCharacter);
        assertEquals(expectedCharacter.getHP(),testEqualCharacter.getHP());
    }

    @Override
    protected void checkLethalAttack(final ICharacter expectedCharacter,
                                     final ICharacter testEqualCharacter,
                                     final ICharacter differentClassCharacter) {


        expectedCharacter.equip(testIWeapon);
        testEqualCharacter.equip(testIWeapon);
        differentClassCharacter.equip(testIWeapon);

        while(testEqualCharacter.getCanContinue()) {
            differentClassCharacter.attack(testEqualCharacter);}

        while(differentClassCharacter.getCanContinue()) {expectedCharacter.attack(differentClassCharacter);}

        while(expectedCharacter.getCanContinue()) {expectedCharacter.attack(expectedCharacter);}


        assertFalse(differentClassCharacter.getCanContinue());
        assertFalse(testEqualCharacter.getCanContinue());
        assertFalse(expectedCharacter.getCanContinue());
        testEqualCharacter.equip(new WeaponNull());
        assertEquals(testEqualCharacter.getEquippedWeapon(),expectedCharacter.getEquippedWeapon());
    }

    protected void checkDeathNotification(final IPlayerCharacter expectedCharacter,
                                          final IPlayerCharacter testEqualCharacter){
        assertNotNull(expectedCharacter.getPlayerCharacterDeathNotification());
        assertNotNull(testEqualCharacter.getPlayerCharacterDeathNotification());
        assertNotEquals(expectedCharacter.getPlayerCharacterDeathNotification(),
                testEqualCharacter.getPlayerCharacterDeathNotification());
    }

}
