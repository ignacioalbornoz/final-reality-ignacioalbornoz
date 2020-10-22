package com.github.ignacioalbornoz.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy {
    private final int weight;

    public AbstractEnemy(@NotNull final String name, final int weight,
                         @NotNull final BlockingQueue<ICharacter> turnsQueue) {
        super(turnsQueue, name);
        this.weight = weight;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String getCharacterClass() {
        return "ENEMY";
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof IEnemy) {
            final IEnemy that = (IEnemy) o;
            return getWeight() == that.getWeight() && getName().equals(that.getName()) & getCharacterClass().equals(that.getCharacterClass());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeight());
    }
}
