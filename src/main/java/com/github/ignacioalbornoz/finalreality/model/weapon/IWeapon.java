package com.github.ignacioalbornoz.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Ignacio Albornoz Alfaro.>
 */
public interface IWeapon {

  String getName();

  int getDamage();

  int getWeight();

  String getType();

}
