package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractCharacter implements ICharacter {

  /**
   * List of the characters' turns.
   */
  protected final BlockingQueue<ICharacter> turnsQueue;

  /**
   * Name of an character.
   */
  protected final String name;

  /**
   * Timer to implement the turn list of the characters.
   */
  private ScheduledExecutorService scheduledExecutor;

  /**
   * The character's equipped weapon that initializes as a null weapon.
   */
  protected IWeapon equippedWeapon = new WeaponNull();

  /**
   * Character's constructor with the common attributes: name and queue with the characters ready to
   * play.
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name) {
    this.turnsQueue = turnsQueue;
    this.name = name;
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    this.respondWaitTurn();
  }

  /**
   * Sets a scheduled executor to make this player character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurnPlayer(){
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Sets a scheduled executor to make this enemy character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurnEnemy(){
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Responds to the waitTurn method
   */
  public abstract void respondWaitTurn();

  /**
   * {@inheritDoc}
   */
  @Override
  public void equip(IWeapon weapon) {
    this.respondEquip(weapon);}

  public void equipPlayerCharacter(IWeapon weapon){this.equippedWeapon = weapon;}

  public void equipEnemyCharacter(IWeapon weapon){}

  public void respondEquip(IWeapon weapon){}

}




