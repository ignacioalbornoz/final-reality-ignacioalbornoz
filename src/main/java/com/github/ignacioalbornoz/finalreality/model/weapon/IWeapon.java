package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.*;

/**
 * This represents a weapon from the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public interface IWeapon {

  /**
   * Returns this weapon's name.
   */
  String getName();

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Returns this weapon's weight.
   */
  int getWeight();

  /**
   * Returns this weapon's type.
   */
  String getType();

  /**
   * Returns a boolean indicating whether this weapon is of type "NULL" or not.
   */
  boolean isNull();


  void equippedByBlackMage(BlackMage character);

  void equippedByWhiteMage(WhiteMage character);

  void equippedByEngineer(Engineer character);

  void equippedByKnight(Knight character);

  void equippedByThief(Thief character);

}
