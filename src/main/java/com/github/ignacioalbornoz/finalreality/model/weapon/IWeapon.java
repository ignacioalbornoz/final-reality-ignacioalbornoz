package com.github.ignacioalbornoz.finalreality.model.weapon;

import java.util.Objects;

/**
 * This represents a weapon from the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public interface IWeapon {

  String getName();

  int getDamage();

  int getWeight();

  String getType();

  boolean isNull();

}
