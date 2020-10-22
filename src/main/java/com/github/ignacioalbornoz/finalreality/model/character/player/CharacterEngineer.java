package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class CharacterEngineer extends AbstractPlayerCharacterNonMage{
    public CharacterEngineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue);
    }

    @Override
    public String getCharacterClass() {
        return "ENGINEER";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterEngineer)) {
            return false;
        }
        final CharacterEngineer that = (CharacterEngineer) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
}
