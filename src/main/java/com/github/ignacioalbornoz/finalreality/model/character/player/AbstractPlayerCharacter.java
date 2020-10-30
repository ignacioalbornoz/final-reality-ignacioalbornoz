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



  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name);
  }


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
   * {@inheritDoc}
   *
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass(),getName());
  }


  /**
   * {@inheritDoc}
   *
   */
  @Override
  public void respondWaitTurn(){
    this.waitTurnPlayer();

  }

}

