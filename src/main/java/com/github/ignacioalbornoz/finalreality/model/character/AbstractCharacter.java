package com.github.ignacioalbornoz.finalreality.model.character;

import com.github.ignacioalbornoz.finalreality.model.character.player.*;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz Alfaro.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected int HP = 100;

  protected int defense = 0;

  protected boolean canContinue = true;

  /**
   * List of the characters' turns.
   */
  protected final BlockingQueue<ICharacter> turnsQueue;

  /**
   * Name of an character.
   */
  protected final String name;

  /**
   * Timer to implement the turn list of the characters.
   */
  private ScheduledExecutorService scheduledExecutor;

  /**
   * The character's equipped weapon that initializes as a null weapon.
   */
  protected IWeapon equippedWeapon = new WeaponNull();

  /**
   * Character's constructor with the common attributes: name and queue with the characters ready to
   * play.
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name) {
    this.turnsQueue = turnsQueue;
    this.name = name;
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    this.respondWaitTurn();
  }

  /**
   * Sets a scheduled executor to make this player character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurnPlayer(){
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var playerCharacter = (IPlayerCharacter) this;
    scheduledExecutor
          .schedule(this::addToQueue, playerCharacter.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Sets a scheduled executor to make this enemy character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurnEnemy(){
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Responds to the waitTurn method
   */
  public abstract void respondWaitTurn();


  @Override
  public void attackedByBlackMage(BlackMage character) {
    this.attackedBy(realDamage(character));
  }

  @Override
  public void attackedByWhiteMage(WhiteMage character) {
    this.attackedBy(realDamage(character));

  }

  @Override
  public void attackedByEngineer(Engineer character) {
    this.attackedBy(realDamage(character));

  }

  @Override
  public void attackedByKnight(Knight character) {
    this.attackedBy(realDamage(character));

  }

  @Override
  public void attackedByThief(Thief character) {
    this.attackedBy(realDamage(character));

  }

  @Override
  public void attackedByEnemy(IEnemy enemy) {
    this.attackedBy(realDamageEnemy(enemy));
  }


  public int getDefense() {
    return defense;
  }

  public int getHP() {
    return HP;
  }

  public boolean getCanContinue() {
    return canContinue;
  }

  public void setHP(int HP) {
    if (0 >= HP){
      this.setCanContinue(false);}
    this.HP = Math.max(HP,0) ;
  }

  void attackedBy(int realDamage){
    this.setHP(this.getHP()-realDamage);
  }

  int realDamage(ICharacter character){
    return ((character.getEquippedWeapon().getDamage())-this.getDefense());
  }

  int realDamageEnemy(IEnemy enemy){
    return (enemy.getDamage()-this.getDefense());
  }

  public void setEquippedWeapon(IWeapon weapon) {
      this.equippedWeapon = weapon;
    }

  @Override
  public void setCanContinue(boolean canContinue) {
    this.canContinue = canContinue;
  }

}




