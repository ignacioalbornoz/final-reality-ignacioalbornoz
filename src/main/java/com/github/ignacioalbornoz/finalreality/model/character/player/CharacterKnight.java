package com.github.ignacioalbornoz.finalreality.model.character.player;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class CharacterKnight extends AbstractPlayerCharacterNonMage{

    public CharacterKnight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue);
    }

    @Override
    public String getCharacterClass() {
        return "KNIGHT";
    }
}
