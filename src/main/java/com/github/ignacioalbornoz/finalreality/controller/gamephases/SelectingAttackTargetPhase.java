package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;

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

    @Override
    public void equipToCharacterInTurn(IWeapon weapon) throws InvalidTargetException, InvalidCharacterException, InvalidPhaseException, InvalidAliveCharacterException, InvalidTransitionException {
        var characterInTurnPhase = this.getAlivePlayerCharacter(this.getNameOfCharacterInTurn());
            controller.equipController(characterInTurnPhase, weapon);
            if(!(controller.getEquippedWeaponController(characterInTurnPhase)==weapon)){
                throw new InvalidTargetException("You cannot equip the weapon to this character.");
            }
    }

    @Override
    public void unEquip(IPlayerCharacter playerCharacter) {
        controller.unEquipController(playerCharacter);
    }

    public String getType(){
        return "SelectingAttackTargetPhase";
    }

}
