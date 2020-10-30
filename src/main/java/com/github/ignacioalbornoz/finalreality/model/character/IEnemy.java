package com.github.ignacioalbornoz.finalreality.model.character;

/**
 * This represents a enemy from the game.
 * An enemy can be controlled only by the CPU.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public interface IEnemy extends ICharacter{

    /**
     * Returns the weight of the enemy.
     */
    int getWeight();
}
