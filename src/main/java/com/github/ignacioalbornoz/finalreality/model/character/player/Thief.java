package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single thief character of the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Thief extends AbstractNonMage {

    /**
     * Creates a new thief character with a name and the queue with the characters ready to
     * play.
     */
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name) {
        super(turnsQueue, name);
    }

    /**
     * Returns the class of the enemy's: "THIEF".
     */
    @Override
    public String getCharacterClass() {
        return "THIEF";
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedByThief(this);

    }

    @Override
    public void respondEquip(IWeapon weapon){this.equipThiefCharacter(weapon);}
}
