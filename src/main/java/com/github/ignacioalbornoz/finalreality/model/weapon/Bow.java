package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.BlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.Knight;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a bow-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */
public class Bow extends AbstractWeapon{

    /**
     * Creates a new weapon with a name, a weight and a damage ready to be equipped on a character.
     *
     */
    public Bow(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Returns "BOW", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "BOW";
    }

    @Override
    public void equippedByBlackMage(BlackMage character) {
    }

    @Override
    public void equippedByWhiteMage(WhiteMage character) {
    }

    @Override
    public void equippedByKnight(Knight character) {
    }
}
