package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.AbstractCharacter;
import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter {
  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name);
  }
  @Override
  public boolean equals(final Object o) {
    if (o instanceof ICharacter) {
      final Enemy that = (Enemy) o;
      return getName().equals(that.getName()) & getCharacterClass().equals(that.getCharacterClass());
    }
    return false;
  }
  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }
}
