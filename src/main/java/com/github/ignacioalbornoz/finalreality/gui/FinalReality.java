package com.github.ignacioalbornoz.finalreality.gui;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.controller.gamephases.InvalidTransitionException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
  private final Label guiHpOfCharacterInTurn = new Label();
  private final Label guiPotencialDamageOfCharacterInTurn = new Label();

  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage){
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);
    Group root = new Group();
    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1280, 720);


    ImageView background =
            null;
    try {
      background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "3660.jpg")));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    root.getChildren().add(background);



    ImageView enemyCharacter = null;

    try {
      enemyCharacter = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "enemyCharacterColor.png")));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    assert enemyCharacter != null;
    enemyCharacter.setX(605);
    enemyCharacter.setY(200);

    enemyCharacter.setFitHeight(250);
    enemyCharacter.setFitWidth(200);

    root.getChildren().add(enemyCharacter);


    ImageView playerCharacter = null;
    try {
      playerCharacter = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "yourCharacterColor.png")));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    assert playerCharacter != null;
    playerCharacter.setX(395);
    playerCharacter.setY(200);

    playerCharacter.setFitHeight(250);
    playerCharacter.setFitWidth(200);

    root.getChildren().add(playerCharacter);







    Label canOnlyAttack = new Label("Instructions:");
    canOnlyAttack.setLayoutY(200);
    canOnlyAttack.setLayoutX(1050);
    root.getChildren().add(canOnlyAttack);


    Label ready = new Label("Press Next when you are ready for the next phase of the game");
    ready .setLayoutY(220);
    ready .setLayoutX(930);
    root.getChildren().add(ready);

    Label canOnlyAttackTwo = new Label("You can only attack when you are in SelectingAttackTargetPhase");
    canOnlyAttackTwo.setLayoutY(240);
    canOnlyAttackTwo.setLayoutX(930);
    root.getChildren().add(canOnlyAttackTwo);



    guiCharacterInTurn.setLayoutY(35);
    guiCharacterInTurn.setLayoutX(950);
    root.getChildren().add(guiCharacterInTurn);


    guiEquippedWeaponOfCharacterInTurn.setLayoutY(55);
    guiEquippedWeaponOfCharacterInTurn.setLayoutX(950);
    root.getChildren().add(guiEquippedWeaponOfCharacterInTurn);

    guiHpOfCharacterInTurn.setLayoutY(75);
    guiHpOfCharacterInTurn.setLayoutX(950);
    root.getChildren().add(guiHpOfCharacterInTurn);

    guiPotencialDamageOfCharacterInTurn.setLayoutY(95);
    guiPotencialDamageOfCharacterInTurn.setLayoutX(950);
    root.getChildren().add(guiPotencialDamageOfCharacterInTurn);


    gamePhase.setLayoutY(190);
    gamePhase.setLayoutX(20);

    totalPlayerCharactersLabel.setLayoutY(210);
    totalPlayerCharactersLabel.setLayoutX(20);

    alivePlayerCharactersLabel.setLayoutY(230);
    alivePlayerCharactersLabel.setLayoutX(20);


    totalEnemyCharactersLabel.setLayoutY(250);
    totalEnemyCharactersLabel.setLayoutX(20);


    aliveEnemyCharactersLabel.setLayoutY(270);
    aliveEnemyCharactersLabel.setLayoutX(20);

    gameOver.setLayoutY(290);
    gameOver.setLayoutX(20);

    root.getChildren().add(totalPlayerCharactersLabel);
    root.getChildren().add(totalEnemyCharactersLabel);
    root.getChildren().add(alivePlayerCharactersLabel);
    root.getChildren().add(aliveEnemyCharactersLabel);
    root.getChildren().add(gamePhase);
    root.getChildren().add(gameOver);


    Button next = new Button("Next");
    next.setLayoutY(10);
    next.setLayoutX(10);
    next.setOnAction(event -> {
      try {
        controller.doPhaseAction();
      } catch (InvalidTransitionException e) {
        System.out.print("You must do something before moving on to the next phase. Remember to read the instructions.\n");
      }
    });
    root.getChildren().add(next);




    Button equipPowerfulWeapons = new Button("Equip Powerful Weapons ");
    equipPowerfulWeapons.setLayoutY(40);
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



    Button attackEnemy = new Button("Attack the Enemy");
    attackEnemy.setLayoutY(70);
    attackEnemy.setLayoutX(10);
    attackEnemy.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
        if(controller.isInAliveEnemyList(controller.getEnemyFromEnemyList("TestEnemy"))){
          var nameOfCharacter = controller.getNameControllerCharacter(controller.getCharacterInTurn());
          var testEnemy = controller.getAliveEnemy("TestEnemy");
          controller.controllerAttack(controller.getAlivePlayerCharacter(nameOfCharacter),testEnemy);}}
    });
    root.getChildren().add(attackEnemy);




    Button attackPowerfulEnemy = new Button("Attack the Powerful Enemy");
    attackPowerfulEnemy.setLayoutY(100);
    attackPowerfulEnemy.setLayoutX(10);
    attackPowerfulEnemy.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("SelectingAttackTargetPhase")){
        if(controller.isInAliveEnemyList(controller.getEnemyFromEnemyList("PowerfulEnemy"))){
          var nameOfCharacter = controller.getNameControllerCharacter(controller.getCharacterInTurn());
          var PowerfulEnemy = controller.getAliveEnemy("PowerfulEnemy");
          controller.controllerAttack(controller.getAlivePlayerCharacter(nameOfCharacter),PowerfulEnemy);}}
    });
    root.getChildren().add(attackPowerfulEnemy);


    Label addCharactersInstructions = new Label("Instructions:");
    addCharactersInstructions.setLayoutY(340);
    addCharactersInstructions.setLayoutX(100);
    root.getChildren().add(addCharactersInstructions);

    Label addCharacters = new Label("You can only add your characters when \nyou are in \"PreGameStartedPhase\"");
    addCharacters.setLayoutY(360);
    addCharacters.setLayoutX(20);
    root.getChildren().add(addCharacters);

    Label addCharactersTwo = new Label("Your characters must be equipped before \nbefore exiting \"PreGameStartedPhase\"");
    addCharactersTwo.setLayoutY(400);
    addCharactersTwo.setLayoutX(20);
    root.getChildren().add(addCharactersTwo);




    Button addEquippedWhiteMage = new Button("Add Equipped White Mage");
    addEquippedWhiteMage.setLayoutY(480);
    addEquippedWhiteMage.setLayoutX(10);
    addEquippedWhiteMage.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createWhiteMage("WhiteMageOne");
        controller.weaponCreateStaff("StaffWhiteMage",10,10);
        controller.weaponCreateStaff("StaffWhiteMagePowerful",10,55);
        var WhiteMageOne = controller.getAlivePlayerCharacter("WhiteMageOne");
        var StaffWhiteMage = controller.getWeapon("StaffWhiteMage");
        controller.equipController(WhiteMageOne,StaffWhiteMage);}
    });
    root.getChildren().add(addEquippedWhiteMage);


    Button addEquippedEngineer = new Button("Add Equipped Engineer");
    addEquippedEngineer.setLayoutY(510);
    addEquippedEngineer.setLayoutX(10);
    addEquippedEngineer.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createEngineer("EngineerOne");
        controller.weaponCreateAxe("AxeEngineer",10,10);
        controller.weaponCreateAxe("AxeEngineerPowerful",10,55);
        var EngineerOne = controller.getAlivePlayerCharacter("EngineerOne");
        var AxeEngineer = controller.getWeapon("AxeEngineer");
        controller.equipController(EngineerOne,AxeEngineer);}

    });
    root.getChildren().add(addEquippedEngineer);



    Button addEquippedKnight = new Button("Add Equipped Knight");
    addEquippedKnight.setLayoutY(540);
    addEquippedKnight.setLayoutX(10);
    addEquippedKnight.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createKnight("KnightOne");
        controller.weaponCreateAxe("AxeKnight",10,10);
        controller.weaponCreateAxe("AxeKnightPowerful",10,55);
        var KnightOne = controller.getAlivePlayerCharacter("KnightOne");
        var AxeKnight = controller.getWeapon("AxeKnight");
        controller.equipController(KnightOne,AxeKnight);}

    });
    root.getChildren().add(addEquippedKnight);





    Button addEquippedThief = new Button("Add Equipped Thief");
    addEquippedThief.setLayoutY(570);
    addEquippedThief.setLayoutX(10);
    addEquippedThief.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createThief("ThiefOne");
        controller.weaponCreateSword("SwordThief",10,10);
        controller.weaponCreateSword("SwordThiefPowerful",10,55);
        var ThiefOne = controller.getAlivePlayerCharacter("ThiefOne");
        var SwordThief = controller.getWeapon("SwordThief");
        controller.equipController(ThiefOne,SwordThief);
      }

    });
    root.getChildren().add(addEquippedThief);




    Button addEquippedBlackMage = new Button("Add Black Mage");
    addEquippedBlackMage.setLayoutY(600);
    addEquippedBlackMage.setLayoutX(10);
    addEquippedBlackMage.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createBlackMage("BlackMageOne");
        controller.weaponCreateStaff("StaffBlackMage",10,10);
        controller.weaponCreateStaff("StaffBlackMagePowerful",10,55);
        var BlackMageOne = controller.getAlivePlayerCharacter("BlackMageOne");
        var StaffBlackMage = controller.getWeapon("StaffBlackMage");
        controller.equipController(BlackMageOne,StaffBlackMage);
      }
    });
    root.getChildren().add(addEquippedBlackMage);





    Button addEnemy = new Button("Add Enemy");
    addEnemy.setLayoutY(630);
    addEnemy.setLayoutX(10);
    addEnemy.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")){
        controller.createEnemy("TestEnemy",10);}
    });
    root.getChildren().add(addEnemy);



    Button addEnemyPowerful = new Button("Add Powerful Enemy");
    addEnemyPowerful.setLayoutY(660);
    addEnemyPowerful.setLayoutX(10);
    addEnemyPowerful.setOnAction(event -> {
      if (controller.getGamePhase().getType().equals("PreGameStartedPhase")) {
        controller.createEnemy("PowerfulEnemy", 2);
        controller.controllerSetEnemyDamage(controller.getAliveEnemy("PowerfulEnemy"), 101);
      }
    });

    root.getChildren().add(addEnemyPowerful);


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

        String stringGuiCharacterInTurn = "";
        String stringGuiEquippedWeaponOfCharacterInTurn = "";
        String stringGuiHpOfCharacterInTurn = "";
        String stringGuiPotencialDamageOfCharacterInTurn = "";


        if (controller.getCharacterInTurn()!=null){

          if ( controller.isInAlivePlayerCharacterList(controller.getCharacterInTurn())){
          var realCharacterInTurn = controller.getAlivePlayerCharacter(controller.getNameControllerCharacter(controller.getCharacterInTurn()));
          stringGuiCharacterInTurn =  controller.getNameControllerCharacter(controller.getCharacterInTurn());

          int guiHpOfCharacterInTurn = controller.controllerGetHP(realCharacterInTurn);
          stringGuiHpOfCharacterInTurn = String.valueOf(guiHpOfCharacterInTurn);

          var equippedWeapon = controller.getEquippedWeaponController(realCharacterInTurn);
          if (!controller.getControllerWeaponType(equippedWeapon).equals("NULL")){
            stringGuiEquippedWeaponOfCharacterInTurn = controller.getNameControllerWeapon(equippedWeapon);}
            int guiPotencialDamageOfCharacterInTurn = controller.controllerGetWeaponDamage(equippedWeapon);
            stringGuiPotencialDamageOfCharacterInTurn = String.valueOf(guiPotencialDamageOfCharacterInTurn);
        }
          if( controller.isInAliveEnemyList(controller.getCharacterInTurn())){
            var realCharacterInTurn = controller.getAliveEnemy(controller.getNameControllerCharacter(controller.getCharacterInTurn()));
            stringGuiCharacterInTurn =  controller.getNameControllerCharacter(controller.getCharacterInTurn());

            int guiHpOfCharacterInTurn = controller.controllerGetHP(realCharacterInTurn);
            stringGuiHpOfCharacterInTurn = String.valueOf(guiHpOfCharacterInTurn);
            int guiPotencialDamageOfCharacterInTurn = controller.controllerGetDamage(realCharacterInTurn);
            stringGuiPotencialDamageOfCharacterInTurn = String.valueOf(guiPotencialDamageOfCharacterInTurn);

          }

        }



        gamePhase.setText("Game Phase: " +stringGamePhase);
        gameOver.setText("Game Over: " +stringGameOver);
        guiCharacterInTurn.setText("Game Character in Turn: " +stringGuiCharacterInTurn);
        guiEquippedWeaponOfCharacterInTurn.setText("Equipped Weapon: " +stringGuiEquippedWeaponOfCharacterInTurn);
        guiHpOfCharacterInTurn.setText("HP: " +stringGuiHpOfCharacterInTurn );
        guiPotencialDamageOfCharacterInTurn.setText("Potencial Damage: " +stringGuiPotencialDamageOfCharacterInTurn );


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