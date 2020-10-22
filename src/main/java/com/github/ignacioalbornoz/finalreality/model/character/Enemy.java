package com.github.ignacioalbornoz.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Ignacio Albornoz Alfaro>
 */
public class Enemy extends AbstractEnemy{
  public Enemy(@NotNull String name, int weight, @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(name, weight, turnsQueue);
  }
}
