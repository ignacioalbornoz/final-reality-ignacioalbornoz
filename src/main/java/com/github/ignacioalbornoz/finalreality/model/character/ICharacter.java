package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  String getCharacterClass();

  /**
   * Returns this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Equips a weapon to the character.
   */
  void equip(IWeapon weapon);

  void attack(ICharacter character);

  void attackedByBlackMage(ICharacter character);

  void attackedByWhiteMage(ICharacter character);

  void attackedByEngineer(ICharacter character);

  void attackedByKnight(ICharacter character);

  void attackedByThief(ICharacter character);

  void attackedByEnemy(IEnemy enemy);
}


