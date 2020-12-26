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
        throw new InvalidTransitionException("The game is over thanks for playing, " +
                "I hope you enjoyed it. If you want to play again, " +
                "you can close the tab and start the application again. " +
                "You can contact the developer at the email: ignacio.albornoz@ug.uchile.cl");
    }

    @Override
    public String getType() {
        return "GameOver";
    }

    @Override
    public void attack(ICharacter character, ICharacter attackedCharacter) throws InvalidTargetException, InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {
        throw new InvalidTransitionException("The game is over thanks for playing, " +
                "I hope you enjoyed it. If you want to play again, " +
                "you can close the tab and start the application again. " +
                "You can contact the developer at the email: ignacio.albornoz@ug.uchile.cl");
    }

    @Override
    public IPlayerCharacter getAlivePlayerCharacter(String nameOfPlayerCharacter) throws InvalidTransitionException {
        throw new InvalidTransitionException("The game is over thanks for playing, " +
                "I hope you enjoyed it. If you want to play again, " +
                "you can close the tab and start the application again. " +
                "You can contact the developer at the email: ignacio.albornoz@ug.uchile.cl");
    }

    @Override
    public IEnemy getAliveEnemy(String nameOfEnemy) throws InvalidTransitionException {
        throw new InvalidTransitionException("The game is over thanks for playing, " +
                "I hope you enjoyed it. If you want to play again, " +
                "you can close the tab and start the application again. " +
                "You can contact the developer at the email: ignacio.albornoz@ug.uchile.cl");
    }
}
