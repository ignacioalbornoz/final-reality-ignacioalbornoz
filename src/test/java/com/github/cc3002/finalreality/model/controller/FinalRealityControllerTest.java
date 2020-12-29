package com.github.cc3002.finalreality.model.controller;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.controller.gamephases.*;
import com.github.ignacioalbornoz.finalreality.model.character.Enemy;
import com.github.ignacioalbornoz.finalreality.model.character.ICharacter;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.Staff;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class FinalRealityControllerTest {
    private FinalRealityController controllerTest;
    private BlockingQueue<ICharacter> turnsTest;


    @BeforeEach
    void setUp() {
        turnsTest = new LinkedBlockingQueue<>();
        controllerTest = new FinalRealityController();
    }


    @Test
    void constructorTest(){
        assertTrue(controllerTest.getCollectionOfPlayerCharacters().isEmpty());
        assertTrue(controllerTest.getCollectionOfEnemy().isEmpty());
        assertTrue(controllerTest.getCollectionOfWeapon().isEmpty());
        assertTrue(controllerTest.getCollectionOfNamesEquippedWeapons().isEmpty());
        assertTrue(controllerTest.getCopyOfSetOfPlayerCharacterNames().isEmpty());
        assertTrue(controllerTest.getCopyOfSetOfEnemyNames().isEmpty());
        assertTrue(controllerTest.getSetOfWeaponNames().isEmpty());
        assertTrue(controllerTest.getSetOfPlayerCharacterEquippedNames().isEmpty());


    }

    @Test
    void checkCreateAndEquipBlackMage() {
        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testEnemy = controllerTest.getEnemyFromInitialList("EnemyTest");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));


        var testNamePlayerCharacter = controllerTest.getNameControllerCharacter(testPlayerCharacter);
        var testNameWeapon = controllerTest.getNameControllerWeapon(testWeapon);

        assertTrue(controllerTest.isCharacterInCharactersEquipped(testNamePlayerCharacter));
        assertTrue(controllerTest.isWeaponInCharactersEquipped(testNameWeapon));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);


        controllerTest.weaponCreateKnife("TestKnife",10,10);
        var testKnife = controllerTest.getWeaponFromList("TestKnife");
        controllerTest.equipController(testPlayerCharacter,testKnife);
        assertEquals(testKnife,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testKnife,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var weaponTestNullInitial = controllerTest.getEquippedWeaponController(testPlayerCharacter);
        controllerTest.unEquipController(testPlayerCharacter);
        var weaponTestNullFinal = controllerTest.getEquippedWeaponController(testPlayerCharacter);
        assertEquals(weaponTestNullInitial,weaponTestNullFinal);


    }


    @Test
    void checkCreateAndEquipWhiteMage() {

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createWhiteMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromInitialList("EnemyTest");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);
    }

    @Test
    void checkCreateAndEquipEngineer() {

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createEngineer("Test");
        controllerTest.weaponCreateAxe("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromInitialList("EnemyTest");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);
    }

    @Test
    void checkCreateAndEquipKnight() {

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createKnight("Test");
        controllerTest.weaponCreateAxe("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromInitialList("EnemyTest");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);
    }

    @Test
    void checkCreateAndEquipThief() {

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createThief("Test");
        controllerTest.weaponCreateSword("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromInitialList("EnemyTest");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);


        controllerTest.weaponCreateBow("TestBow",10,10);

        var testBow = controllerTest.getWeaponFromList("TestBow");

        controllerTest.equipController(testPlayerCharacter,testBow);
        assertEquals(testBow,controllerTest.getEquippedWeaponController(testPlayerCharacter));

    }

    @Test
    void checkCreateAndModifyEnemy() {

        controllerTest.createEnemy("EnemyTest",10);

        var testEnemy = controllerTest.getAliveEnemy("EnemyTest");


        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);

        assertNotEquals(testEnemy,testDifferentEnemy);
        assertEquals(controllerTest.controllerGetDamage(testEnemy),controllerTest.controllerGetDamage(testDifferentEnemy));

        controllerTest.controllerSetEnemyDamage(testEnemy,55);
        controllerTest.controllerSetEnemyDamage(testDifferentEnemy,55);

        assertNotEquals(testEnemy,testDifferentEnemy);
        assertEquals(controllerTest.controllerGetDamage(testEnemy),controllerTest.controllerGetDamage(testDifferentEnemy));
    }


    @Test
    void checkData() {
        controllerTest.createEnemy("Test",10);
        controllerTest.createEnemy("TestEnemy2",10);

        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("Test",10,10);

        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);


        var playerTest = controllerTest.getAlivePlayerCharacter("Test");
        var namePlayer = controllerTest.getNameControllerCharacter(playerTest);
        var enemyTest = controllerTest.getAliveEnemy("Test");


        var nameEnemy = controllerTest.getNameControllerCharacter(enemyTest);
        var weaponTest = controllerTest.getWeaponFromList("Test");
        var nameWeapon = controllerTest.getNameControllerWeapon(weaponTest);


        assertEquals(namePlayer, nameEnemy);
        assertEquals(namePlayer, nameWeapon);
        var otherName = "otherName";
        assertNotEquals(otherName, namePlayer);
        assertNotEquals(otherName, nameEnemy);
        assertNotEquals(otherName, nameWeapon);
        var blackMageClass = "BLACK_MAGE";
        var playerCharacterClass = controllerTest.getControllerCharacterClass(playerTest);
        var enemyClass = controllerTest.getControllerCharacterClass(enemyTest);
        var weaponTestType=controllerTest.getControllerWeaponType(weaponTest);
        var staffType= "STAFF";
        var AxeType= "AXE";
        assertEquals(blackMageClass,playerCharacterClass);
        assertNotEquals(playerCharacterClass,enemyClass);
        assertEquals(weaponTestType,staffType);
        assertNotEquals(weaponTestType,AxeType);
        var HPPlayerTest = controllerTest.controllerGetHP(playerTest);
        var CanContinuePlayerTest= controllerTest.controllerCanContinue(playerTest);
        var HPEnemyTest = controllerTest.controllerGetHP(enemyTest);
        var CanContinueEnemyTest= controllerTest.controllerCanContinue(enemyTest);
        assertEquals(HPPlayerTest,HPEnemyTest);
        assertEquals(CanContinuePlayerTest,CanContinueEnemyTest);
        var enemyDamageTest = controllerTest.controllerGetDamage(enemyTest);
        var enemyTestTwo = controllerTest.getAliveEnemy("TestEnemy2");
        var enemyTwoDamageTest = controllerTest.controllerGetDamage(enemyTestTwo);
        var enemyWeightTest = controllerTest.controllerGetWeight(enemyTest);
        assertEquals(enemyDamageTest,enemyTwoDamageTest);
        assertEquals(enemyWeightTest,10);
    }

    @Test
    void checkWeaponData(){
        controllerTest.weaponCreateStaff("Test",10,10);

        var weaponTest = controllerTest.getWeaponFromList("Test");

        var weightWeapon = controllerTest.controllerGetWeaponWeight(weaponTest);

        var damageWeapon = controllerTest.controllerGetWeaponDamage(weaponTest);

        var isNullWeapon = controllerTest.controllerGetWeaponIsNull(weaponTest);

        assertEquals(10,weightWeapon);
        assertEquals(10,damageWeapon);
        assertFalse(isNullWeapon);
    }

    @Test
    void checkControllerAttack(){

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createEnemy("EnemyTestTwo",10);
        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        var playerCharacterTest = controllerTest.getAlivePlayerCharacter("Test");

        var weaponTest = controllerTest.getWeaponFromList("TestWeapon");
        controllerTest.equipController(playerCharacterTest,weaponTest);

        var enemyTest = controllerTest.getAliveEnemy("EnemyTest");
        var enemyTestTwo = controllerTest.getAliveEnemy("EnemyTestTwo");


        controllerTest.controllerAttack(enemyTest,enemyTestTwo);
        assertEquals(controllerTest.controllerGetHP(enemyTestTwo),100-enemyTest.getDamage());

    }


    @Test
    void checkParty(){
        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.equipController(controllerTest.getAlivePlayerCharacter("Test"),controllerTest.getWeaponFromList("TestWeapon"));
        assertEquals(new Staff("TestWeapon",10,10),controllerTest.getEquippedWeaponController(controllerTest.getAlivePlayerCharacter("Test")));
        controllerTest.unEquipController(controllerTest.getAlivePlayerCharacter("Test"));
        assertEquals(new WeaponNull(), controllerTest.getEquippedWeaponController(controllerTest.getAlivePlayerCharacter("Test")));
        assertNotEquals(controllerTest.getEnemyFromInitialList("EnemyTest"),new Enemy(turnsTest,"EnemyTestDos",10));
    }

    @Test
    void isIn(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.createEnemy("TestEnemy",10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");


        assertTrue(controllerTest.isInAliveEnemyList(testEnemy));
        assertTrue(controllerTest.isInAlivePlayerCharacterList(testPlayerCharacter));
        assertTrue(controllerTest.isInWeaponList(testWeapon));



    }

    @Test
    void checkNameDisponible(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.createEnemy("TestEnemy",10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");

        var playerCharacterName = controllerTest.getNameControllerCharacter(testPlayerCharacter);
        var weaponName = controllerTest.getNameControllerWeapon(testWeapon);
        var enemyName = controllerTest.getNameControllerCharacter(testEnemy);

        controllerTest.setInitialPlayerCharacterList();
        controllerTest.setInitialEnemyList();

        assertFalse(controllerTest.isNameEnemyDisponible(enemyName));
        assertFalse(controllerTest.isNamePlayerCharacterDisponible(playerCharacterName));
        assertFalse(controllerTest.isNameWeaponDisponible(weaponName));

        assertTrue(controllerTest.isNameEnemyDisponible("Disponible"));
        assertTrue(controllerTest.isNamePlayerCharacterDisponible("Disponible"));
        assertTrue(controllerTest.isNameWeaponDisponible("Disponible"));
    }

    @Test
    void checkDelete(){

        controllerTest.createEnemy("EnemyTest",10);
        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        controllerTest.setInitialEnemyList();
        controllerTest.setInitialPlayerCharacterList();

        controllerTest.deletePlayerCharacterFromInitialList("Test");
        controllerTest.deleteEnemyFromInitialList("EnemyTest");
        controllerTest.deleteWeapon("TestWeapon");

        assertTrue(controllerTest.getCollectionOfPlayerCharacters().isEmpty());
        assertTrue(controllerTest.getCollectionOfEnemy().isEmpty());

        assertTrue(controllerTest.getCollectionOfWeapon().isEmpty());
        assertTrue(controllerTest.getCollectionOfNamesEquippedWeapons().isEmpty());

        assertTrue(controllerTest.getCopyOfSetOfPlayerCharacterNames().isEmpty());
        assertTrue(controllerTest.getCopyOfSetOfEnemyNames().isEmpty());
        assertTrue(controllerTest.getSetOfWeaponNames().isEmpty());


        assertTrue(controllerTest.getSetOfPlayerCharacterEquippedNames().isEmpty());


        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);

        controllerTest.deleteWeapon("TestWeapon");
        assertFalse(controllerTest.getCollectionOfWeapon().isEmpty());
        assertFalse(controllerTest.getCollectionOfNamesEquippedWeapons().isEmpty());
        assertFalse(controllerTest.getSetOfPlayerCharacterEquippedNames().isEmpty());


    }

    @Test
    void checkDeathListeners(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
        var testPlayerCharacterTwo = controllerTest.getAlivePlayerCharacter("TestPlayerCharacterTwo");

        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacterTwo,testWeapon);

        controllerTest.setInitialEnemyList();
        controllerTest.setInitialPlayerCharacterList();


        while(testEnemy.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacter,testEnemy);

        while(testPlayerCharacter.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacterTwo,testPlayerCharacter);


        assertEquals(controllerTest.getAliveEnemyList().size(),0);
    }

    @Test
    void checkPlayerCharacterAllDeadListenerAndPlayerLost(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
        var testPlayerCharacterTwo = controllerTest.getAlivePlayerCharacter("TestPlayerCharacterTwo");

        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");

        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacterTwo,testWeapon);



        controllerTest.controllerTurns();
        while(testPlayerCharacter.getCanContinue()) controllerTest.controllerAttack(testEnemy,testPlayerCharacter);
        assertFalse(controllerTest.isInAlivePlayerCharacterList(testPlayerCharacter));

        while(testPlayerCharacterTwo.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacterTwo,testPlayerCharacterTwo);
        assertFalse(controllerTest.isInAlivePlayerCharacterList(testPlayerCharacterTwo));

        assertEquals(controllerTest.getAlivePlayerCharacterList().size(),0);
        assertTrue(controllerTest.getGameOver());
    }

    @Test
    void checkCloneMaps(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");

        var testMap= controllerTest.cloneAndShuffleMap(controllerTest.getAlivePlayerCharacterList(),
                controllerTest.getAliveEnemyList());

        assertTrue(testMap.containsKey("TestPlayerCharacter"));
        assertTrue(testMap.containsKey("TestPlayerCharacterTwo"));
        assertTrue(testMap.containsKey("TestEnemy"));
    }

    @Test
    void checkGamePhases() throws InvalidTransitionException {

        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeaponTwo",10,10);

        controllerTest.createEnemy("TestEnemy",10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter(
                "TestPlayerCharacter");

        var testPlayerCharacterTwo = controllerTest.getAlivePlayerCharacter(
                "TestPlayerCharacterTwo");

        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");

        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testWeaponTwo = controllerTest.getWeaponFromList("TestWeaponTwo");

        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacter,testWeaponTwo);

        controllerTest.doPhaseAction();
        assertTrue(controllerTest.getGameStarted());
        controllerTest.doPhaseAction();
        assertEquals(controllerTest.getControllerTurnsQueue().peek(),controllerTest.getCharacterInTurn());
    }


    @Test
    void checkGamePhasesUntilGameOver() throws InvalidTransitionException {
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,51);
        controllerTest.weaponCreateStaff("TestWeaponTwo",10,51);
        controllerTest.weaponCreateStaff("TestWeaponThree",1,51);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");

        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        var testWeaponTwo = controllerTest.getWeaponFromList("TestWeaponTwo");
        var testWeaponThree = controllerTest.getWeaponFromList("TestWeaponThree");


        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacter,testWeaponTwo);


        while (!controllerTest.getGameOver()){
            if (controllerTest.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
                var testCharacterToEquip = controllerTest.getCharacterInTurn();
                controllerTest.equipController((IPlayerCharacter) testCharacterToEquip,testWeaponThree);
                controllerTest.controllerAttack(testCharacterToEquip,testEnemy);
            }
            else{
                controllerTest.doPhaseAction();}
        }

        assertEquals(controllerTest.getAliveEnemyList().size(),0);
    }

    @Test
    void checkInvalidTransitionException() throws InvalidTransitionException {

        assertEquals(controllerTest.getGamePhase().getType(),"PreGameStartedPhase");

        controllerTest.createEnemy("TestEnemy",10);

        assertEquals(controllerTest.getGamePhase().getType(),"PreGameStartedPhase");


        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);

        controllerTest.doPhaseAction();
        assertNotEquals(controllerTest.getGamePhase().getType(),"PreGameStartedPhase");

    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(InvalidTransitionException.class, () -> {
            controllerTest.doPhaseAction();
        });

        String expectedMessage = "You must create your characters and the enemies";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsTwo() {
        Exception exception = assertThrows(InvalidTransitionException.class, () -> {
            controllerTest.createBlackMage("TestPlayerCharacter");
            controllerTest.weaponCreateStaff("TestWeapon",10,10);
            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
            var testWeapon = controllerTest.getWeaponFromList("TestWeapon");
            controllerTest.equipController(testPlayerCharacter,testWeapon);
            controllerTest.doPhaseAction();
        });

        String expectedMessage = "You must create your characters and the enemies";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void whenExceptionThrown_thenAssertionSucceedsThree() {
        Exception exception = assertThrows(InvalidTransitionException.class, () -> {
            controllerTest.createEnemy("TestEnemy",10);
            controllerTest.doPhaseAction();
        });

        String expectedMessage = "You must create your characters and the enemies";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void whenExceptionThrown_thenAssertionSucceedsFour() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.getGamePhase().createEnemy("TestEnemy",10);
            controllerTest.getGamePhase().createEngineer("TestEngineer");
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().getAlivePlayerCharacter("TestEnemy");
        });

        String expectedMessage = "Not even a created player character";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsFive() {
        Exception exception = assertThrows(InvalidTransitionException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().setEnemyDamage(testEnemy,101);
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().doPhaseAction();
        });


        String expectedMessage = ("The game is over, I hope you enjoyed it. " +
                "If you want to play again, " +
                "you can close the tab and start the application again. " +"\n"+
                "You can contact the developer at: ignacio.albornoz@ug.uchile.cl");
        String actualMessage = exception.getMessage();

        assertEquals(controllerTest.getGamePhase().getType(),"GameOver");
        assertTrue(actualMessage.contains(expectedMessage));
    }





    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixEnemy() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createEnemy("secondEnemyTest", 10);
        });

        String expectedMessage = ("You can only create enemies when you are in \"PreGameStarted Phase\".");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }









    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixBlackMage() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createBlackMage("testBlackMage");
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create characters.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixEngineer() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createEngineer("testEngineer");
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create characters.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixKnight() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createKnight("testKnight");
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create characters.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixThief() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createThief("testThief");
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create characters.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixWhiteMage() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().createWhiteMage("testWhiteMage");
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create characters.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixAxe() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().weaponCreateAxe("secondTestAxe",1,1);
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixBow() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().weaponCreateBow("secondTestBow",1,1);
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixKnife() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().weaponCreateKnife("secondTestKnife",1,1);
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixStaff() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().weaponCreateStaff("secondTestStaff",1,1);
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSixSword() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().weaponCreateSword("secondTestSword",1,1);
        });

        String expectedMessage = ("You must be in \"PreGameStartedPhase\" to create weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
