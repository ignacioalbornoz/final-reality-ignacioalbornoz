package com.github.ignacioalbornoz.finalreality.listeners;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerCharacterDeathListener implements PropertyChangeListener {
    FinalRealityController controller;

    public PlayerCharacterDeathListener(FinalRealityController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IPlayerCharacter playerCharacter =  (IPlayerCharacter) evt.getSource();
        controller.deletePlayerCharacter(playerCharacter.getName());
    }
}
