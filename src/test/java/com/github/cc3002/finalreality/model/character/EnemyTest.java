package com.github.cc3002.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterThief;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(turns, ENEMY_NAME, 10));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(turns, ENEMY_NAME, 10),
        testCharacters.get(0),
        new Enemy(turns, ENEMY_NAME, 11),
        new CharacterThief(turns, ENEMY_NAME));
    assertNotEquals(testCharacters.get(0),new Enemy(turns, "NAME", 10));
    assertNotEquals(testCharacters.get(0).hashCode(),new Enemy(turns, "NAME", 10).hashCode());

    assertNotEquals(testCharacters.get(0),new WeaponNull());
    assertNotEquals(testCharacters.get(0).hashCode(), new WeaponNull().hashCode());
  }
}