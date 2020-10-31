package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.AbstractCharacter;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that contains the common behavior of all player characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 * @version 1.0
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{

  /**
   * Player character's constructor with the common attributes: name and queue with the characters ready to
   * play.
   */
  protected AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                 @NotNull String name) {
    super(turnsQueue, name);
  }

  /**
   * Compares this object to the specified object and returns true if represents the same player character.
   */
  @Override
  public boolean equals(final Object o) {
    if (o instanceof IPlayerCharacter) {
      final IPlayerCharacter that = (IPlayerCharacter) o;
      return getCharacterClass().equals(that.getCharacterClass())
              && getName().equals(that.getName());
    }
    return false;
  }

  /**
   * Returns the hash code for the name, class of this player character.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass(),getName());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void respondWaitTurn(){
    this.waitTurnPlayer();
  }
}

