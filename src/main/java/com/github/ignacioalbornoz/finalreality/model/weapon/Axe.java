package com.github.ignacioalbornoz.finalreality.model.weapon;

import com.github.ignacioalbornoz.finalreality.model.character.player.BlackMage;
import com.github.ignacioalbornoz.finalreality.model.character.player.Thief;
import com.github.ignacioalbornoz.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * A class that contains all the information for a axe-type weapon in the game.
 *
 * @author Ignacio Albornoz Alfaro.
 */

public class Axe extends AbstractWeapon{

    /**
     * Returns "AXE", the weapon's type of this class.
     */
    public Axe(@NotNull String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public void equippedByBlackMage(BlackMage character) {
    }

    @Override
    public void equippedByWhiteMage(WhiteMage character) {
    }

    @Override
    public void equippedByThief(Thief character) {
    }

    /**
     * Returns "AXE", the weapon's type of this class.
     */
    @Override
    public String getType() {
        return "AXE";
    }



}
