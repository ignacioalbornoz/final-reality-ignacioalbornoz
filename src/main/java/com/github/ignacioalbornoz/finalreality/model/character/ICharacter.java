package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
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

  String getCharacterClass();

  IWeapon getEquippedWeapon();

  void equip(IWeapon weapon);

}


