package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;

public class SelectingAttackTargetPhase extends AbstractGamePhase{

    public SelectingAttackTargetPhase(){
        super();
    }


    @Override
    public void doPhaseAction() throws InvalidTransitionException {
        if (controller.getGameOver()){
            controller.setGamePhase(new GameOverPhase());
        }
        else{throw new InvalidTransitionException("You must attack");}
    }

    @Override
    public void attack(ICharacter character, ICharacter characterAttacked) throws InvalidTargetException,
            InvalidAliveCharacterException, InvalidCharacterException, InvalidTransitionException {

        var nameOfEnemyToAttack = controller.getEnemySelected();
        if(!controller.isNameEnemyDisponible(nameOfEnemyToAttack)){
            if(controller.isInAliveEnemyList(controller.getEnemyFromInitialList(nameOfEnemyToAttack))){
                var enemyToAttack = getAliveEnemy(nameOfEnemyToAttack);
                controller.controllerAttack(character, enemyToAttack);
                if (!controller.getGameOver()){
                    controller.setGamePhase(new SecondPhase());
                }
            }
        }
        else{
            throw new InvalidTargetException("Enemy no available");
        }
    }

    public String getType(){
        return "SelectingAttackTargetPhase";
    }

}
