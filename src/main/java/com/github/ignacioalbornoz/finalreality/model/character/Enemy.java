package com.github.ignacioalbornoz.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public class Enemy extends AbstractEnemy{

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   *
   * @param name
   * @param weight
   * @param turnsQueue
   */
  public Enemy(@NotNull String name, int weight, @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(name, weight, turnsQueue);
  }
}
