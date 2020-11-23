package com.github.ignacioalbornoz.finalreality.model.character;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that contains the common behavior of all enemy characters in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy{

    private final float damage = 1;

    /**
     * Weight of an enemy.
     */
    private final int weight;

    /**
     * Enemy's constructor with the common attributes: name, weight and queue with the characters ready to
     * play.
     */
    protected AbstractEnemy(@NotNull final BlockingQueue<ICharacter> turnsQueue, @NotNull final String name, final int weight) {
        super(turnsQueue, name);
        this.weight = weight;
    }

    /**
     * {@inheritDoc}
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Compares this object to the specified object and returns true if represents the same enemy.
     */
    @Override
    public boolean equals(final Object o) {

        if ((o instanceof IEnemy)) {
            final IEnemy enemy = (IEnemy) o;
            return getWeight() == enemy.getWeight()
                    && getName().equals(enemy.getName())
                    && getCharacterClass().equals(enemy.getCharacterClass());
        }return false;
    }

    /**
     * Returns the hash code for the name, weight, damage and class of this enemy.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWeight(),getName(),getCharacterClass());
    }

    public float getDamage() {
        return damage;
    }
}
