package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.BlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.Engineer;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a knife-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Knife extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public Knife(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "KNIFE", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "KNIFE";
    }

    @Override
    public void equippedByEngineer(Engineer character) {
    }

    @Override
    public void equippedByWhiteMage(WhiteMage character) {
    }

    @Override
    public void equippedByThief(Thief character) {
    }
}
