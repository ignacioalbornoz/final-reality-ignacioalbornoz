package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class CharacterWhiteMage extends AbstractPlayerCharacterMage{
    public CharacterWhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue);
    }

    @Override
    public String getCharacterClass() {
        return "WHITE_MAGE";
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterWhiteMage)) {
            return false;
        }
        final CharacterWhiteMage that = (CharacterWhiteMage) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
}
