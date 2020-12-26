package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractEnemyTest extends AbstractCharacterTest{
    /**
     * Name to creates a enemy character to test.
     */
    protected static final String ENEMY_NAME = "Goblin";

    @Override
    protected void checkAttack(final ICharacter expectedCharacter, final ICharacter testEqualCharacter,
                               final ICharacter differentClassCharacter) {
        differentClassCharacter.equip(testIWeapon);
        expectedCharacter.attack(testEqualCharacter);
        testEqualCharacter.attack(expectedCharacter);
        assertEquals(expectedCharacter.getHP(),testEqualCharacter.getHP());
        differentClassCharacter.attack(expectedCharacter);
        differentClassCharacter.attack(testEqualCharacter);
        assertEquals(expectedCharacter.getHP(),testEqualCharacter.getHP());
    }

    @Override
    protected void checkLethalAttack(final ICharacter expectedCharacter,final ICharacter testEqualCharacter,
                                     final ICharacter differentClassCharacter) {
        differentClassCharacter.equip(testIWeapon);
        while(testEqualCharacter.getCanContinue()){differentClassCharacter.attack(testEqualCharacter);}
        while(differentClassCharacter.getCanContinue()){testEqualCharacter.attack(differentClassCharacter);}
        while(expectedCharacter.getCanContinue()){expectedCharacter.attack(expectedCharacter);}

        assertFalse(differentClassCharacter.getCanContinue());
        assertFalse(testEqualCharacter.getCanContinue());
        assertFalse(expectedCharacter.getCanContinue());

    }

    protected void checkDeathNotification(final IEnemy expectedCharacter,final IEnemy testEqualCharacter){
        assertNotNull(expectedCharacter.getEnemyDeathNotification());
        assertNotNull(testEqualCharacter.getEnemyDeathNotification());
        assertNotEquals(expectedCharacter.getEnemyDeathNotification(),testEqualCharacter.getEnemyDeathNotification());

    }
}
