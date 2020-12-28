package com.github.cc3002.finalreality.model.controller;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.controller.gamephases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePhaseTest {
    private FinalRealityController controllerTest;

    @BeforeEach
    void setUp() {
        controllerTest = new FinalRealityController();
    }


    @Test
    void constructorTest() throws InvalidTargetException,
            InvalidPhaseException,
            InvalidCharacterException,
            InvalidTransitionException,
            InvalidAliveCharacterException, InvalidWeaponException {


        assertEquals(controllerTest.getGamePhase().getController(),controllerTest);
        assertEquals(controllerTest.getGamePhase(),new PreGameStartedPhase());
        assertEquals(controllerTest.getGamePhase().hashCode(),new PreGameStartedPhase().hashCode());


        controllerTest.createEnemy("testEnemy",50);
        controllerTest.createWhiteMage("testWhiteMage");
        controllerTest.weaponCreateStaff("testStaff",5,20);


        var testPlayerCharacter = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testWhiteMage");

        var testWeapon = controllerTest.getGamePhase().getWeapon("testStaff");



        assertNotEquals(controllerTest.getGamePhase(),testPlayerCharacter);
        assertNotEquals(controllerTest.getGamePhase().hashCode(),testPlayerCharacter.hashCode());
        controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);



        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfEnemyNames(),controllerTest.getCopyOfSetOfAliveEnemyCharacters());
        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfPlayerCharacterNames(),
                controllerTest.getCopyOfSetOfAlivePlayerCharacters());


        controllerTest.getGamePhase().doPhaseAction();
        assertNotEquals(controllerTest.getGamePhase(),new PreGameStartedPhase());
        assertNotEquals(controllerTest.getGamePhase().hashCode(),new PreGameStartedPhase().hashCode());

        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfEnemyNames(),controllerTest.getCopyOfSetOfEnemyNames());
        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfPlayerCharacterNames(),
                controllerTest.getCopyOfSetOfPlayerCharacterNames());


        while((controllerTest.getCharacterInTurn()==null)){
            controllerTest.getGamePhase().doPhaseAction();}

        assertEquals(controllerTest.getNameOfCharacterInTurn(),
                    controllerTest.getGamePhase().getNameOfCharacterInTurn());
    }




    @Test
    void checkCreateWeaponsEnemiesPlayerCharacters() throws InvalidTargetException,
            InvalidPhaseException,
            InvalidCharacterException,
            InvalidTransitionException,
            InvalidAliveCharacterException, InvalidWeaponException {


        controllerTest.getGamePhase().createWhiteMage("testWhiteMage");
        controllerTest.getGamePhase().createEngineer("testEngineer");
        controllerTest.getGamePhase().createKnight("testKnight");
        controllerTest.getGamePhase().createThief("testThief");
        controllerTest.getGamePhase().createBlackMage("testBlackMage");

        controllerTest.getGamePhase().createEnemy("testEnemy",30);
        controllerTest.getGamePhase().weaponCreateStaff("testStaff",5,20);
        controllerTest.getGamePhase().weaponCreateAxe("testAxe",1,1);
        controllerTest.getGamePhase().weaponCreateBow("testBow",1,1);
        controllerTest.getGamePhase().weaponCreateKnife("testKnife",1,1);
        controllerTest.getGamePhase().weaponCreateSword("testSword",1,1);
        controllerTest.getGamePhase().weaponCreateAxe("testAxeTwo",1,1);
        controllerTest.getGamePhase().weaponCreateStaff("testStaffTwo",5,20);

        var testWhiteMage = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testWhiteMage");
        var testEngineer = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testEngineer");
        var testKnight = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testKnight");
        var testThief = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testThief");
        var testBlackMage = controllerTest.getGamePhase().getAlivePlayerCharacter(
                "testBlackMage");


        var testStaff = controllerTest.getGamePhase().getWeapon("testStaff");
        var testAxe = controllerTest.getGamePhase().getWeapon("testAxe");
        var testBow = controllerTest.getGamePhase().getWeapon("testBow");
        var testKnife = controllerTest.getGamePhase().getWeapon("testKnife");
        var testSword = controllerTest.getGamePhase().getWeapon("testSword");
        var testStaffTwo = controllerTest.getGamePhase().getWeapon("testStaffTwo");

        var testAxeTwo = controllerTest.getGamePhase().getWeapon("testAxeTwo");

        assertNotEquals(controllerTest.getGamePhase(),testWhiteMage);
        assertNotEquals(controllerTest.getGamePhase().hashCode(),testWhiteMage.hashCode());

        controllerTest.getGamePhase().equip(testWhiteMage,testStaff);
        controllerTest.getGamePhase().equip(testEngineer,testAxeTwo);
        controllerTest.getGamePhase().equip(testKnight,testAxe);
        controllerTest.getGamePhase().equip(testThief,testSword);
        controllerTest.getGamePhase().equip(testBlackMage,testStaffTwo);

        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfEnemyNames(),controllerTest.getCopyOfSetOfAliveEnemyCharacters());
        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfPlayerCharacterNames(),
                controllerTest.getCopyOfSetOfAlivePlayerCharacters());


        controllerTest.getGamePhase().doPhaseAction();
        assertNotEquals(controllerTest.getGamePhase(),new PreGameStartedPhase());
        assertNotEquals(controllerTest.getGamePhase().hashCode(),new PreGameStartedPhase().hashCode());

        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfEnemyNames(),controllerTest.getCopyOfSetOfEnemyNames());
        assertEquals(controllerTest.getGamePhase().getCopyOfSetOfPlayerCharacterNames(),
                controllerTest.getCopyOfSetOfPlayerCharacterNames());


        while((controllerTest.getCharacterInTurn()==null)){
            controllerTest.getGamePhase().doPhaseAction();}

        assertEquals(controllerTest.getNameOfCharacterInTurn(),
                controllerTest.getGamePhase().getNameOfCharacterInTurn());
    }



    @Test
    public void setNextAndPreviousPrePhase() throws InvalidTargetException, InvalidWeaponException, InvalidAliveCharacterException {


        controllerTest.createEnemy("testEnemy",50);
        controllerTest.createWhiteMage("testWhiteMage");
        controllerTest.weaponCreateStaff("testStaff",5,20);


        controllerTest.getGamePhase().setNextWeapon();
        controllerTest.getGamePhase().setNextPlayerCharacter();
        controllerTest.getGamePhase().setNextEnemy();
        controllerTest.getGamePhase().setPreviousEnemy();
        controllerTest.getGamePhase().setPreviousPlayerCharacter();
        controllerTest.getGamePhase().setPreviousWeapon();

        assertEquals(controllerTest.getWeaponSelected(),"testStaff");
        assertEquals(controllerTest.getGamePhase().getWeapon("testStaff"),
                controllerTest.getWeaponFromList("testStaff"));


        assertEquals(controllerTest.getPlayerCharacterSelected(),"testWhiteMage");
        controllerTest.getPlayerCharacterFromInitialList(("testWhiteMage"));


        assertEquals(controllerTest.getEnemySelected(),"testEnemy");
        controllerTest.getEnemyFromInitialList(("testEnemy"));
    }


    @Test
    public void GetAlivePlayerCharacter() throws InvalidTargetException, InvalidPhaseException, InvalidCharacterException, InvalidTransitionException, InvalidAliveCharacterException, InvalidWeaponException {
        controllerTest.createEnemy("TestEnemy",50);controllerTest.createBlackMage("TestBlackMage");
        controllerTest.createWhiteMage("TestWhiteMage");
        controllerTest.weaponCreateStaff("TestStaff",5,20);

        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
        var testWeapon = controllerTest.getWeaponFromList("TestStaff");
        assertEquals(controllerTest.getGamePhase().getAlivePlayerCharacter("TestBlackMage"),testPlayerCharacter);
        controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
        controllerTest.getGamePhase().doPhaseAction();
        assertEquals(controllerTest.getGamePhase().getAlivePlayerCharacter("TestBlackMage"),testPlayerCharacter);
    }

    @Test
    public void GetAliveEnemyCharacter() throws InvalidTargetException, InvalidPhaseException, InvalidCharacterException, InvalidTransitionException, InvalidAliveCharacterException, InvalidWeaponException {
        controllerTest.createEnemy("TestEnemy",50);controllerTest.createBlackMage("TestBlackMage");
        controllerTest.createWhiteMage("TestWhiteMage");
        controllerTest.weaponCreateStaff("TestStaff",5,20);


        var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
        var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
        var testWeapon = controllerTest.getWeaponFromList("TestStaff");
        assertEquals(controllerTest.getGamePhase().getAliveEnemy("TestEnemy"),testEnemy);
        controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
        controllerTest.getGamePhase().doPhaseAction();
        assertEquals(controllerTest.getGamePhase().getAliveEnemy("TestEnemy"),testEnemy);
    }


    @Test
    public void checkPreGameStartedExceptionGetAlivePlayerCharacter() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.getGamePhase().getAlivePlayerCharacter("NoCreated");
        });

        String expectedMessage = ("You must select a valid player character.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkPreGameStartedExceptionGetAliveEnemy() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.getGamePhase().getAliveEnemy("NoCreated");
        });

        String expectedMessage = ("You must select a valid enemy character.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsGetEnemyCharacter() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().getAliveEnemy("noCreatedEnemyCharacter");
        });

        String expectedMessage = ("Not even a created enemy character");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsGetAliveEnemyCharacter() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createEnemy("SecondTestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.removeAliveEnemy("TestEnemy");
            controllerTest.getGamePhase().getAliveEnemy("TestEnemy");
        });

        String expectedMessage = ("Not a enemy character alive");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetNextEnemy() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.getGamePhase().setNextEnemy();
        });

        String expectedMessage = ("There are no enemies alive.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetPreviousEnemy() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.getGamePhase().setPreviousEnemy();
        });

        String expectedMessage = ("There are no enemies alive.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetNextPlayerCharacter() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.getGamePhase().setNextPlayerCharacter();;
        });

        String expectedMessage = ("There are no player characters alive.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetPreviousPlayerCharacter() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.getGamePhase().setPreviousPlayerCharacter();;
        });

        String expectedMessage = ("There are no player characters alive.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetNextWeapon() {
        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            controllerTest.getGamePhase().setNextWeapon();
        });

        String expectedMessage = ("There are no weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsSetPreviousWeapon() {
        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            controllerTest.getGamePhase().setPreviousWeapon();
        });

        String expectedMessage = ("There are no weapons.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    @Test
    public void whenExceptionThrown_thenAssertionSucceedsAttack() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testEnemy = controllerTest.getAliveEnemy("TestEnemy");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().attack(testPlayerCharacter,testEnemy);
        });

        String expectedMessage = ("You must be in \"SelectingAttackTargetPhase\" to be able to attack an enemy.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsGetPlayerCharacter() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.getGamePhase().getAlivePlayerCharacter("noCreatedPlayerCharacter");
        });

        String expectedMessage = ("Not even a created player character");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsGetAlivePlayerCharacter() {
        Exception exception = assertThrows(InvalidAliveCharacterException.class, () -> {
            controllerTest.createEnemy("TestEnemy",2);
            controllerTest.createBlackMage("TestBlackMage");
            controllerTest.createWhiteMage("TestWhiteMage");
            controllerTest.weaponCreateStaff("TestStaff",100,20);

            var testPlayerCharacter = controllerTest.getAlivePlayerCharacter("TestBlackMage");
            var testWeapon = controllerTest.getWeaponFromList("TestStaff");
            controllerTest.getGamePhase().equip(testPlayerCharacter,testWeapon);
            controllerTest.getGamePhase().doPhaseAction();
            controllerTest.removeAlivePlayerCharacter("TestBlackMage");
            controllerTest.getGamePhase().getAlivePlayerCharacter("TestBlackMage");
        });

        String expectedMessage = ("Not a player character alive");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkInvalidExceptionSetEnemyDamagePreGamePhase() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.getGamePhase().setEnemyDamage(null,999);
        });

        String expectedMessage = ("You must select a valid enemy.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkInvalidExceptionEquipPreGamePhase() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            controllerTest.getGamePhase().weaponCreateStaff("testWeapon",1,1);
            var testWeapon= controllerTest.getGamePhase().getWeapon("testWeapon");
            controllerTest.getGamePhase().equip(null,testWeapon);
        });

        String expectedMessage = ("You must select a valid character.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkInvalidExceptionGetNameOfCharacterInTurnPreGamePhase() {
        Exception exception = assertThrows(InvalidPhaseException.class, () -> {
            controllerTest.getGamePhase().getNameOfCharacterInTurn();
        });

        String expectedMessage = ("You must advance to the next phase for the game turns to begin.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkInvalidExceptionEquipWeaponPreGamePhase() {
        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            controllerTest.getGamePhase().createWhiteMage("test");
            var testPlayerCharacter =
                    controllerTest.getGamePhase().getAlivePlayerCharacter("test");

            controllerTest.getGamePhase().equip(testPlayerCharacter,null);
        });

        String expectedMessage = ("You must select a valid weapon.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkInvalidExceptionCantEquipWeaponToThisCharacterPreGamePhase() {
        Exception exception = assertThrows(InvalidTargetException.class, () -> {
            controllerTest.getGamePhase().createThief("testThief");
            var testThief =
                    controllerTest.getGamePhase().getAlivePlayerCharacter("testThief");

            controllerTest.getGamePhase().weaponCreateKnife("testKnife",1,1);
            var testKnife =
                    controllerTest.getGamePhase().getWeapon("testKnife");

            controllerTest.getGamePhase().equip(testThief,testKnife);
        });

        String expectedMessage = ("You cannot equip the weapon to this character.");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}
