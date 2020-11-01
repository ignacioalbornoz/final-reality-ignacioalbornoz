package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Class containing the common tests for the enemy characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 * @see ICharacter
 */
class EnemyTest extends AbstractCharacterTest {

  /**
   * Name to creates a enemy character to test.
   */
  private static final String ENEMY_NAME = "Goblin";

  /**
   * Creates the variables for the enemy character tests.
   */
  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(turns, ENEMY_NAME, 10));
  }

  /**
   * {@inheritDoc}
   */
  @Test
  void constructorTest() {
    checkConstruction(new Enemy(turns, ENEMY_NAME, 10),
        testCharacters.get(0),
        new Enemy(turns, ENEMY_NAME, 11),
        new Thief(turns, ENEMY_NAME));

    assertNotEquals(testCharacters.get(0),new Enemy(turns, "NAME", 10));
    assertNotEquals(testCharacters.get(0).hashCode(),new Enemy(turns, "NAME", 10).hashCode());

    assertNotEquals(testCharacters.get(0),new WeaponNull());
    assertNotEquals(testCharacters.get(0).hashCode(), new WeaponNull().hashCode());
  }
}