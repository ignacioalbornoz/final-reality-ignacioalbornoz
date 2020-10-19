package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.CharacterClass;
import com.github.ignacioalbornoz.finalreality.model.character.player.PlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Ignacio Albornoz Alfaro.>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  private IWeapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void equip(IWeapon weapon) {
    if (this instanceof PlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }
}
