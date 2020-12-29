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
        throw new InvalidTransitionException("You must attack.");
    }

    @Override
    public void attackToEnemySelected(ICharacter character) throws InvalidAliveCharacterException,
            InvalidCharacterException, InvalidTransitionException, InvalidTargetException {

        var nameOfEnemyToAttack = controller.getEnemySelected();
        if(!controller.isNameEnemyDisponible(nameOfEnemyToAttack)){
            if(controller.isInAliveEnemyList(controller.getEnemyFromInitialList(nameOfEnemyToAttack))){
                var enemyToAttack = getAliveEnemy(nameOfEnemyToAttack);
                controller.controllerAttack(character, enemyToAttack);
                controller.setGamePhase(new SecondPhase());
            }
            else{
                throw new InvalidAliveCharacterException("The selected enemy is already dead.");
            }
        }
        else{
            throw new InvalidTargetException("Enemy no available.");
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
    public void unEquip(IPlayerCharacter playerCharacter) throws InvalidCharacterException {
        if (playerCharacter==null){
            throw new InvalidCharacterException("You must select a valid character.");
        } else{
            controller.unEquipController(playerCharacter);
        }
    }

    public String getType(){
        return "SelectingAttackTargetPhase";
    }

}
