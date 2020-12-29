package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;

public class GameOverPhase extends AbstractGamePhase{
    public GameOverPhase() {
        super();
    }

    @Override
    public void doPhaseAction() throws InvalidTransitionException {
        throw new InvalidTransitionException("The game is over, I hope you enjoyed it. " +
                "If you want to play again, " +
                "you can close the tab and start the application again. " +"\n"+
                "You can contact the developer at: ignacio.albornoz@ug.uchile.cl");
    }

    @Override
    public String getType() {
        return "GameOver";
    }

}
