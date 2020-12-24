package com.github.cc3002.finalreality.model.controller;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.controller.gamephases.InvalidTransitionException;
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
        assertTrue(controllerTest.getCollectionOfEquippedWeapons().isEmpty());
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
        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");
        var testWeapon = controllerTest.getWeapon("TestWeapon");
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
        var testKnife = controllerTest.getWeapon("TestKnife");
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
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");
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
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");
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
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");
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
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        assertEquals(testWeapon,controllerTest.getEquippedWeaponController(testPlayerCharacter));

        controllerTest.unEquipController(testPlayerCharacter);
        var testWeaponNull = new WeaponNull();
        var testDifferentEnemy = new Enemy(turnsTest,"EnemyTestDos",10);
        assertEquals(testWeaponNull, controllerTest.getEquippedWeaponController(testPlayerCharacter));
        assertNotEquals(testEnemy,testDifferentEnemy);


        controllerTest.weaponCreateBow("TestBow",10,10);

        var testBow = controllerTest.getWeapon("TestBow");

        controllerTest.equipController(testPlayerCharacter,testBow);
        assertEquals(testBow,controllerTest.getEquippedWeaponController(testPlayerCharacter));

    }

    @Test
    void checkCreateAndModifyEnemy() {

        controllerTest.createEnemy("EnemyTest",10);

        var testEnemy = controllerTest.getEnemyFromEnemyList("EnemyTest");


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
        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("Test",10,10);
        controllerTest.createEnemy("TestWeapon",10);
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        var playerTest = controllerTest.getAlivePlayerCharacter("Test");
        var namePlayer = controllerTest.getNameControllerCharacter(playerTest);
        var enemyTest = controllerTest.getEnemyFromEnemyList("Test");
        var nameEnemy = controllerTest.getNameControllerCharacter(enemyTest);
        var weaponTest = controllerTest.getWeapon("Test");
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
        var enemyWeightTest = controllerTest.controllerGetWeight(enemyTest);
        assertEquals(enemyDamageTest,1);
        assertEquals(enemyWeightTest,10);
    }

    @Test
    void checkWeaponData(){
        controllerTest.weaponCreateStaff("Test",10,10);

        var weaponTest = controllerTest.getWeapon("Test");

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

        var weaponTest = controllerTest.getWeapon("TestWeapon");
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
        controllerTest.equipController(controllerTest.getAlivePlayerCharacter("Test"),controllerTest.getWeapon("TestWeapon"));
        assertEquals(new Staff("TestWeapon",10,10),controllerTest.getEquippedWeaponController(controllerTest.getAlivePlayerCharacter("Test")));
        controllerTest.unEquipController(controllerTest.getAlivePlayerCharacter("Test"));
        assertEquals(new WeaponNull(), controllerTest.getEquippedWeaponController(controllerTest.getAlivePlayerCharacter("Test")));
        assertNotEquals(controllerTest.getEnemyFromEnemyList("EnemyTest"),new Enemy(turnsTest,"EnemyTestDos",10));
    }

    @Test
    void isIn(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.createEnemy("TestEnemy",10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("TestEnemy");


        assertTrue(controllerTest.isInEnemyList(testEnemy));
        assertTrue(controllerTest.isInParty(testPlayerCharacter));
        assertTrue(controllerTest.isInWeaponList(testWeapon));



    }

    @Test
    void checkNameDisponible(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.createEnemy("TestEnemy",10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testEnemy = controllerTest.getEnemyFromEnemyList("TestEnemy");

        var playerCharacterName = controllerTest.getNameControllerCharacter(testPlayerCharacter);
        var weaponName = controllerTest.getNameControllerWeapon(testWeapon);
        var enemyName = controllerTest.getNameControllerCharacter(testEnemy);

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

        controllerTest.deletePlayerCharacter("Test");
        controllerTest.deleteEnemy("EnemyTest");
        controllerTest.deleteWeapon("TestWeapon");
        assertTrue(controllerTest.getCollectionOfPlayerCharacters().isEmpty());
        assertTrue(controllerTest.getCollectionOfEnemy().isEmpty());

        assertTrue(controllerTest.getCollectionOfWeapon().isEmpty());
        assertTrue(controllerTest.getCollectionOfEquippedWeapons().isEmpty());

        assertTrue(controllerTest.getCopyOfSetOfPlayerCharacterNames().isEmpty());
        assertTrue(controllerTest.getCopyOfSetOfEnemyNames().isEmpty());
        assertTrue(controllerTest.getSetOfWeaponNames().isEmpty());


        assertTrue(controllerTest.getSetOfPlayerCharacterEquippedNames().isEmpty());


        controllerTest.createBlackMage("Test");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("Test");
        var testWeapon = controllerTest.getWeapon("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);

        controllerTest.deleteWeapon("TestWeapon");
        assertFalse(controllerTest.getCollectionOfWeapon().isEmpty());
        assertFalse(controllerTest.getCollectionOfEquippedWeapons().isEmpty());
        assertFalse(controllerTest.getSetOfPlayerCharacterEquippedNames().isEmpty());


    }

    @Test
    void checkDeathListeners(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getEnemyFromEnemyList("TestEnemy");
        var testPlayerCharacterTwo = controllerTest.getAlivePlayerCharacter("TestPlayerCharacterTwo");

        var testWeapon = controllerTest.getWeapon("TestWeapon");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacterTwo,testWeapon);


        while(testEnemy.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacter,testEnemy);
        assertFalse(controllerTest.isInAliveEnemyList(testEnemy));

        while(testPlayerCharacter.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacterTwo,testPlayerCharacter);
        assertFalse(controllerTest.isInAlivePlayerCharacterList(testPlayerCharacter));

        assertEquals(controllerTest.getAliveEnemyList().size(),0);
        while(testPlayerCharacterTwo.getCanContinue()) controllerTest.controllerAttack(testPlayerCharacterTwo,testPlayerCharacterTwo);
        assertFalse(controllerTest.isInAlivePlayerCharacterList(testPlayerCharacterTwo));
        assertEquals(controllerTest.getAlivePlayerCharacterList().size(),0);
    }

    @Test
    void checkPlayerCharacterAllDeadListenerAndPlayerLost(){
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getEnemyFromEnemyList("TestEnemy");
        var testPlayerCharacterTwo = controllerTest.getAlivePlayerCharacter("TestPlayerCharacterTwo");

        var testWeapon = controllerTest.getWeapon("TestWeapon");

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

        var testMap= controllerTest.cloneAndShuffleMap(controllerTest.getAlivePlayerCharacterList(),controllerTest.getAliveEnemyList());

        assertTrue(testMap.containsKey("TestPlayerCharacter"));
        assertTrue(testMap.containsKey("TestPlayerCharacterTwo"));
        assertTrue(testMap.containsKey("TestEnemy"));
    }

    @Test
    void checkGamePhases() throws InvalidTransitionException {

        controllerTest.createBlackMage("TestPlayerCharacter");


        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.weaponCreateStaff("TestWeaponTwo",10,10);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");

        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testWeaponTwo = controllerTest.getWeapon("TestWeaponTwo");

        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacter,testWeaponTwo);

        controllerTest.doPhaseAction();
        assertTrue(controllerTest.getGameStarted());
        controllerTest.doPhaseAction();
        assertEquals(controllerTest.getControllerTurnsQueue().peek(),controllerTest.getCharacterInTurn());
        controllerTest.doPhaseAction();
    }


    @Test
    void checkGamePhasesUntilGameOver() throws InvalidTransitionException {
        controllerTest.createEnemy("TestEnemy",10);
        controllerTest.createBlackMage("TestPlayerCharacter");
        controllerTest.createBlackMage("TestPlayerCharacterTwo");
        controllerTest.weaponCreateStaff("TestWeapon",10,10);
        controllerTest.weaponCreateStaff("TestWeaponTwo",10,10);
        controllerTest.weaponCreateStaff("TestWeaponThree",1,50);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestPlayerCharacter");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");

        var testWeapon = controllerTest.getWeapon("TestWeapon");
        var testWeaponTwo = controllerTest.getWeapon("TestWeaponTwo");
        var testWeaponThree = controllerTest.getWeapon("TestWeaponThree");
        controllerTest.equipController(testPlayerCharacter,testWeapon);
        controllerTest.equipController(testPlayerCharacter,testWeaponTwo);


        while (!controllerTest.getGameOver()){
            controllerTest.doPhaseAction();
            if (controllerTest.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
                var testCharacterToEquip = controllerTest.getCharacterInTurn();
                controllerTest.equipController((IPlayerCharacter) testCharacterToEquip,testWeaponThree);
                controllerTest.controllerAttack(testCharacterToEquip,testEnemy);
            }
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
        var testWeapon = controllerTest.getWeapon("TestWeapon");
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
            var testWeapon = controllerTest.getWeapon("TestWeapon");
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

}
