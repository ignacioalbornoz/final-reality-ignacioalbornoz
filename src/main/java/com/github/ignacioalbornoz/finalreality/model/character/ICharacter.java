package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.*;
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

  void setEquippedWeapon(IWeapon weapon);

  int getHP();

  boolean getCanContinue();

  void setCanContinue(boolean canContinue);

  void equip(IWeapon weapon);

  void attack(ICharacter character);

  void attackedByBlackMage(BlackMage character);

  void attackedByWhiteMage(WhiteMage character);

  void attackedByEngineer(Engineer character);

  void attackedByKnight(Knight character);

  void attackedByThief(Thief character);

  void attackedByEnemy(IEnemy enemy);
}


