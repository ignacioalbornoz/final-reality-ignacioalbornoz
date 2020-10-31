package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponAxe;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  /**
   * List of the characters' turns.
   */
  protected BlockingQueue<ICharacter> turns;

  /**
   * List of the characters.
   */
  protected List<ICharacter> testCharacters;

  /**
   * Weapon to test.
   */
  protected IWeapon testIWeapon;

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    tryToEquip(testCharacters.get(0));
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks that the character's constructor works properly.
   */
  protected void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter sameClassDifferentCharacter,
                                   final ICharacter differentClassCharacter) {

    assertNotEquals(testEqualCharacter, new WeaponNull());
    assertNotEquals(testEqualCharacter.hashCode(), new WeaponNull().hashCode());

    assertEquals(expectedCharacter, testEqualCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());

    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter.hashCode(), testEqualCharacter.hashCode());

    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertNotEquals(testEqualCharacter.hashCode(), differentClassCharacter.hashCode());
  }

  /**
   * Creates the common variables for the character tests.
   */
  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testCharacters = new ArrayList<>();
    testIWeapon = new WeaponAxe("Test", 15, 10);
  }

  /**
   * Tries to equip a weapon on this character.
   */
  private void tryToEquip(ICharacter character) {
    character.equip(testIWeapon);
  }
}
