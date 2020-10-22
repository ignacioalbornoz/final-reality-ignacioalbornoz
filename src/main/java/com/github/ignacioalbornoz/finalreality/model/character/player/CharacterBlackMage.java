package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.AbstractCharacter;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class CharacterBlackMage extends AbstractPlayerCharacterMage {
    public CharacterBlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue);
    }

    @Override
    public String getCharacterClass() {
        return "BLACK_MAGE";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterBlackMage)) {
            return false;
        }
        final CharacterBlackMage that = (CharacterBlackMage) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() { return Objects.hash(getCharacterClass());
    }
}
