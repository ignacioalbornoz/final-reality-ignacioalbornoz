package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.weapon.Sword;
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
class EnemyTest extends AbstractEnemyTest {

  /**
   * Creates the variables for the enemy character tests.
   */
  @BeforeEach
  void setUp() {
    basicSetUp();
    testIWeapon = new Sword("Test", 10, 15);
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

  }

  @Test
  void checkAttackTest() {
    this.checkAttack(new Enemy(turns, ENEMY_NAME, 10), testCharacters.get(0), new Thief(turns, ENEMY_NAME));
  }

  @Test
  void checkLethalAttackTest() {
    this.checkLethalAttack(new Enemy(turns, ENEMY_NAME, 10), testCharacters.get(0), new Thief(turns, ENEMY_NAME));
  }
}