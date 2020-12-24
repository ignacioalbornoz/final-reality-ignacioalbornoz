package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that contains the common behavior of all enemy characters in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy{

    private final PropertyChangeSupport EnemyDeathNotification = new PropertyChangeSupport(this);

    private final int damage = 1;

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
                    && getName().equals(enemy.getName());
        }return false;
    }

    /**
     * Returns the hash code for the name, weight, damage and class of this enemy.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWeight(),getName(),getCharacterClass());
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void addEnemyDeathListener(PropertyChangeListener listener) {
        this.EnemyDeathNotification.addPropertyChangeListener(listener);
    }

    @Override
    public void removeEnemyDeathListener(PropertyChangeListener listener) {
        this.EnemyDeathNotification.removePropertyChangeListener(listener);
    }

    @Override
    public PropertyChangeSupport getEnemyDeathNotification() {
        return EnemyDeathNotification;
    }


    public void fireDeathOfEnemyEvent() {
        EnemyDeathNotification.firePropertyChange(new PropertyChangeEvent(this,
                "Enemy character has died",null, null));}

    @Override
    public void setHP(int HP) {
        if (0 >= HP){
            this.setCanContinue(false);
            fireDeathOfEnemyEvent(); }
        this.HP = Math.max(HP,0) ;
    }
}
