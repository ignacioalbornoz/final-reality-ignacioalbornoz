package com.github.ignacioalbornoz.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy{

    private final int weight;

    /**
     * Creates a new enemy with a name, a weight and the queue with the characters ready to
     * play.
     */
    public AbstractEnemy(@NotNull final String name, final int weight,
                         @NotNull final BlockingQueue<ICharacter> turnsQueue) {
        super(turnsQueue, name);
        this.weight = weight;
    }

    /**
     * Returns the weight of this enemy.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(final Object o) {

        if ((o instanceof IEnemy)) {
            final IEnemy enemy = (IEnemy) o;
            return getWeight() == enemy.getWeight() && getName().equals(enemy.getName());
        }return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeight(),getName(),getCharacterClass());
    }


    @Override
    public String getCharacterClass() {
        return "ENEMY";
    }

    /**
     *
     *
     */
    @Override
    public void respondWaitTurn(){
        this.waitTurnEnemy();

    }
}
