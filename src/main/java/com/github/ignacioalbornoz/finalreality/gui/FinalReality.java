package com.github.ignacioalbornoz.finalreality.gui;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Set;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Ignacio Albornoz A.
 */
public class FinalReality extends Application {

  private static final String RESOURCE_PATH = "src/main/resources/";

  private final Label alivePlayerCharactersLabel = new Label();

  private final FinalRealityController controller = new FinalRealityController();

  private final Label totalPlayerCharactersLabel = new Label();
  private final Label gamePhase = new Label();
  private final Label totalEnemyCharactersLabel = new Label();
  private final Label aliveEnemyCharactersLabel = new Label();
  private final Label gameOver = new Label();
  private final Label guiCharacterInTurn = new Label();
  private final Label guiEquippedWeaponOfCharacterInTurn = new Label();

  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);
    Group root = new Group();
    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1280, 720);



    guiEquippedWeaponOfCharacterInTurn.setLayoutY(30);
    guiEquippedWeaponOfCharacterInTurn.setLayoutX(800);
    root.getChildren().add(guiEquippedWeaponOfCharacterInTurn);

    guiCharacterInTurn.setLayoutY(10);
    guiCharacterInTurn.setLayoutX(800);
    root.getChildren().add(guiCharacterInTurn);


    gamePhase.setLayoutY(10);
    gamePhase.setLayoutX(10);

    totalPlayerCharactersLabel.setLayoutY(30);
    totalPlayerCharactersLabel.setLayoutX(10);

    alivePlayerCharactersLabel.setLayoutY(50);
    alivePlayerCharactersLabel.setLayoutX(10);


    totalEnemyCharactersLabel.setLayoutY(70);
    totalEnemyCharactersLabel.setLayoutX(10);


    aliveEnemyCharactersLabel.setLayoutY(90);
    aliveEnemyCharactersLabel.setLayoutX(10);

    gameOver.setLayoutY(110);
    gameOver.setLayoutX(10);

    root.getChildren().add(totalPlayerCharactersLabel);
    root.getChildren().add(totalEnemyCharactersLabel);
    root.getChildren().add(alivePlayerCharactersLabel);
    root.getChildren().add(aliveEnemyCharactersLabel);
    root.getChildren().add(gamePhase);
    root.getChildren().add(gameOver);


    Button next = new Button("Next");
    next.setLayoutY(130);
    next.setLayoutX(10);
    next.setOnAction(event -> controller.doPhaseAction());
    root.getChildren().add(next);


    Button addEquippedBlackMage = new Button("Add Black Mage");
    addEquippedBlackMage.setLayoutY(160);
    addEquippedBlackMage.setLayoutX(10);
    addEquippedBlackMage.setOnAction(event -> {

      controller.createBlackMage("BlackMageOne");

      controller.weaponCreateStaff("StaffBlackMage",10,10);

      controller.weaponCreateStaff("StaffBlackMagePowerful",10,55);

      var BlackMageOne = controller.getAlivePlayerCharacter("BlackMageOne");

      var StaffBlackMage = controller.getWeapon("StaffBlackMage");

      controller.equipController(BlackMageOne,StaffBlackMage);

    });
    root.getChildren().add(addEquippedBlackMage);


    Button addEquippedWhiteMage = new Button("Add White Mage");
    addEquippedWhiteMage.setLayoutY(190);
    addEquippedWhiteMage.setLayoutX(10);
    addEquippedWhiteMage.setOnAction(event -> {

      controller.createWhiteMage("WhiteMageOne");
      controller.weaponCreateStaff("StaffWhiteMage",10,10);
      controller.weaponCreateStaff("StaffWhiteMagePowerful",10,55);

      var WhiteMageOne = controller.getAlivePlayerCharacter("WhiteMageOne");

      var StaffWhiteMage = controller.getWeapon("StaffWhiteMage");


      controller.equipController(WhiteMageOne,StaffWhiteMage);

    });
    root.getChildren().add(addEquippedWhiteMage);


    Button addEquippedEngineer = new Button("Add Engineer");
    addEquippedEngineer.setLayoutY(220);
    addEquippedEngineer.setLayoutX(10);
    addEquippedEngineer.setOnAction(event -> {

      controller.createEngineer("EngineerOne");
      controller.weaponCreateAxe("AxeEngineer",10,10);
      controller.weaponCreateAxe("AxeEngineerPowerful",10,55);

      var EngineerOne = controller.getAlivePlayerCharacter("EngineerOne");

      var AxeEngineer = controller.getWeapon("AxeEngineer");


      controller.equipController(EngineerOne,AxeEngineer);

    });
    root.getChildren().add(addEquippedEngineer);



    Button addEquippedKnight = new Button("Add Equipped Knight");
    addEquippedKnight.setLayoutY(250);
    addEquippedKnight.setLayoutX(10);
    addEquippedKnight.setOnAction(event -> {

      controller.createKnight("KnightOne");
      controller.weaponCreateAxe("AxeKnight",10,10);
      controller.weaponCreateAxe("AxeKnightPowerful",10,55);

      var KnightOne = controller.getAlivePlayerCharacter("KnightOne");

      var AxeKnight = controller.getWeapon("AxeKnight");


      controller.equipController(KnightOne,AxeKnight);

    });
    root.getChildren().add(addEquippedKnight);





    Button addEquippedThief = new Button("Add Equipped Thief");
    addEquippedThief.setLayoutY(280);
    addEquippedThief.setLayoutX(10);
    addEquippedThief.setOnAction(event -> {

      controller.createThief("ThiefOne");
      controller.weaponCreateSword("SwordThief",10,10);
      controller.weaponCreateSword("SwordThiefPowerful",10,55);

      var ThiefOne = controller.getAlivePlayerCharacter("ThiefOne");

      var SwordThief = controller.getWeapon("SwordThief");


      controller.equipController(ThiefOne,SwordThief);

    });
    root.getChildren().add(addEquippedThief);







    Button addEnemy = new Button("Add Enemy");
    addEnemy.setLayoutY(310);
    addEnemy.setLayoutX(10);
    addEnemy.setOnAction(event -> controller.createEnemy("TestEnemy",10));
    root.getChildren().add(addEnemy);


    Button attackEnemy = new Button("Attack Enemy");
    attackEnemy.setLayoutY(600);
    attackEnemy.setLayoutX(10);
    attackEnemy.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
        var nameOfCharacter = controller.getNameControllerCharacter(controller.getCharacterInTurn());
        var testEnemy = controller.getAliveEnemy("TestEnemy");
        controller.controllerAttack(controller.getAlivePlayerCharacter(nameOfCharacter),testEnemy);}

    });
    root.getChildren().add(attackEnemy);



    Button equipPowerfulWeapons = new Button("Equip Powerful Weapons ");
    equipPowerfulWeapons.setLayoutY(630);
    equipPowerfulWeapons.setLayoutX(10);
    equipPowerfulWeapons.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
        var StaffWhiteMagePowerful = controller.getWeapon("StaffWhiteMagePowerful");
        var StaffBlackMagePowerful = controller.getWeapon("StaffBlackMagePowerful");
        var AxeEngineerPowerful = controller.getWeapon("AxeEngineerPowerful");
        var AxeKnightPowerful = controller.getWeapon("AxeKnightPowerful");
        var SwordThiefPowerful = controller.getWeapon("SwordThiefPowerful");

        var nameOfCharacter = controller.getNameControllerCharacter(controller.getCharacterInTurn());


        if (controller.getControllerCharacterClass(controller.getCharacterInTurn()).equals("WHITE_MAGE")){
          controller.unEquipController(controller.getAlivePlayerCharacter(nameOfCharacter));
          controller.equipController(controller.getAlivePlayerCharacter(nameOfCharacter),StaffWhiteMagePowerful);
        }
        if (controller.getControllerCharacterClass(controller.getCharacterInTurn()).equals("BLACK_MAGE")){
          controller.unEquipController(controller.getAlivePlayerCharacter(nameOfCharacter));
          controller.equipController(controller.getAlivePlayerCharacter(nameOfCharacter),StaffBlackMagePowerful);
        }
        if (controller.getControllerCharacterClass(controller.getCharacterInTurn()).equals("ENGINEER")){
          controller.unEquipController(controller.getAlivePlayerCharacter(nameOfCharacter));
          controller.equipController(controller.getAlivePlayerCharacter(nameOfCharacter),AxeEngineerPowerful);
        }

        if (controller.getControllerCharacterClass(controller.getCharacterInTurn()).equals("KNIGHT")){
          controller.unEquipController(controller.getAlivePlayerCharacter(nameOfCharacter));
          controller.equipController(controller.getAlivePlayerCharacter(nameOfCharacter),AxeKnightPowerful);
        }

        if (controller.getControllerCharacterClass(controller.getCharacterInTurn()).equals("THIEF")){
          controller.unEquipController(controller.getAlivePlayerCharacter(nameOfCharacter));
          controller.equipController(controller.getAlivePlayerCharacter(nameOfCharacter),SwordThiefPowerful);
        }


      }

    });
    root.getChildren().add(equipPowerfulWeapons);



    setupTimer();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void setupTimer() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        Set<String> setAlivePlayerCharacters = controller.getCopyOfSetOfAlivePlayerCharacters();
        int alivePlayerCharacters = setAlivePlayerCharacters.size();
        alivePlayerCharactersLabel.setText("Alive Player characters: " +alivePlayerCharacters);

        Set<String> setTotalPlayerCharacters = controller.getCopyOfSetOfPlayerCharacterNames();
        int totalPlayerCharacters = setTotalPlayerCharacters.size();
        totalPlayerCharactersLabel.setText("Total Player characters: " +totalPlayerCharacters);

        String stringGamePhase = controller.getGamePhase().getType();
        boolean stringGameOver = controller.getGameOver();
        String stringGuiCharacterInTurn = "Null";
        String stringGuiEquippedWeaponOfCharacterInTurn = "Null";


        if (controller.getCharacterInTurn()!=null){
          stringGuiCharacterInTurn =  controller.getNameControllerCharacter(controller.getCharacterInTurn());
          var equippedWeapon = controller.getEquippedWeaponController(
                  controller.getAlivePlayerCharacter(
                          controller.getNameControllerCharacter(
                                  controller.getCharacterInTurn())));

          if (!controller.getControllerWeaponType(equippedWeapon).equals("NULL")){
            stringGuiEquippedWeaponOfCharacterInTurn = controller.getNameControllerWeapon(equippedWeapon);}
        }

        gamePhase.setText("Game Phase: " +stringGamePhase);
        gameOver.setText("Game Over: " +stringGameOver);
        guiCharacterInTurn.setText("Game Character in Turn: " +stringGuiCharacterInTurn);
        guiEquippedWeaponOfCharacterInTurn.setText("Equipped Weapon Of Character In Turn: " +stringGuiEquippedWeaponOfCharacterInTurn);




        Set<String> setTotalEnemyCharacters = controller.getCopyOfSetOfEnemyNames();
        int totalEnemyCharacters = setTotalEnemyCharacters.size();
        totalEnemyCharactersLabel.setText("Total Enemy characters: " +totalEnemyCharacters);

        Set<String> setAliveEnemyCharacters = controller.getCopyOfSetOfAliveEnemyCharacters();
        int aliveEnemyCharacters = setAliveEnemyCharacters.size();
        aliveEnemyCharactersLabel.setText("Alive Enemy characters: " +aliveEnemyCharacters);
      }
    };
    timer.start();
  }

}