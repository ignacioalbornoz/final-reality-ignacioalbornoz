package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public class Enemy extends AbstractEnemy {

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name, int weight) {
    super(turnsQueue,name, weight);
  }

  /**
   * Returns the class of the enemy's: "ENEMY".
   */
  @Override
  public String getCharacterClass() {
    return "ENEMY";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void respondWaitTurn(){
    this.waitTurnEnemy();
  }

  @Override
  public void respondEquip(IWeapon weapon){this.equipEnemyCharacter(weapon);}
}