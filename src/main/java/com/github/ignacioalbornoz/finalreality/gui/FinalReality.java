package com.github.ignacioalbornoz.finalreality.gui;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;
import com.github.ignacioalbornoz.finalreality.controller.gamephases.*;
import com.github.ignacioalbornoz.finalreality.model.character.IEnemy;
import com.github.ignacioalbornoz.finalreality.model.character.player.IPlayerCharacter;
import com.github.ignacioalbornoz.finalreality.model.weapon.IWeapon;
import com.github.ignacioalbornoz.finalreality.model.weapon.WeaponNull;
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
 * <The combat game between a group of player characters and a group of enemies>
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
  private final Label guiEnemySelected = new Label();
  private final Label guiPlayerCharacterSelected = new Label();
  private final Label guiWeaponSelected = new Label();
  private final Label totalWeaponLabel = new Label();

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


    ImageView playerCharacter = null;
    try {
      playerCharacter = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "Center.png")));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    assert playerCharacter != null;
    playerCharacter.setX(395);
    playerCharacter.setY(200);

    playerCharacter.setFitHeight(250);
    playerCharacter.setFitWidth(450);

    root.getChildren().add(playerCharacter);







    Label canOnlyAttack = new Label("Instructions:");
    canOnlyAttack.setLayoutY(10);
    canOnlyAttack.setLayoutX(1050);
    root.getChildren().add(canOnlyAttack);


    Label ready = new Label("Press Next when you are ready for the next phase of the game");
    ready .setLayoutY(30);
    ready .setLayoutX(930);
    root.getChildren().add(ready);

    Label canOnlyAttackTwo = new Label("You can only attack when you are in SelectingAttackTargetPhase");
    canOnlyAttackTwo.setLayoutY(50);
    canOnlyAttackTwo.setLayoutX(930);
    root.getChildren().add(canOnlyAttackTwo);



    guiCharacterInTurn.setLayoutY(210);
    guiCharacterInTurn.setLayoutX(400);
    root.getChildren().add(guiCharacterInTurn);


    guiEquippedWeaponOfCharacterInTurn.setLayoutY(230);
    guiEquippedWeaponOfCharacterInTurn.setLayoutX(400);
    root.getChildren().add(guiEquippedWeaponOfCharacterInTurn);

    guiHpOfCharacterInTurn.setLayoutY(260);
    guiHpOfCharacterInTurn.setLayoutX(400);
    root.getChildren().add(guiHpOfCharacterInTurn);

    guiPotencialDamageOfCharacterInTurn.setLayoutY(280);
    guiPotencialDamageOfCharacterInTurn.setLayoutX(400);
    root.getChildren().add(guiPotencialDamageOfCharacterInTurn);

    guiEnemySelected.setLayoutY(100);
    guiEnemySelected.setLayoutX(950);
    root.getChildren().add(guiEnemySelected);

    guiPlayerCharacterSelected.setLayoutY(160);
    guiPlayerCharacterSelected.setLayoutX(950);
    root.getChildren().add(guiPlayerCharacterSelected);

    guiWeaponSelected.setLayoutY(220);
    guiWeaponSelected.setLayoutX(950);
    root.getChildren().add(guiWeaponSelected);

    gamePhase.setLayoutY(400);
    gamePhase.setLayoutX(400);

    totalPlayerCharactersLabel.setLayoutY(210);
    totalPlayerCharactersLabel.setLayoutX(20);

    alivePlayerCharactersLabel.setLayoutY(230);
    alivePlayerCharactersLabel.setLayoutX(20);


    totalEnemyCharactersLabel.setLayoutY(250);
    totalEnemyCharactersLabel.setLayoutX(20);


    aliveEnemyCharactersLabel.setLayoutY(270);
    aliveEnemyCharactersLabel.setLayoutX(20);

    totalWeaponLabel.setLayoutY(290);
    totalWeaponLabel.setLayoutX(20);

    gameOver.setLayoutY(310);
    gameOver.setLayoutX(20);


    root.getChildren().add(totalPlayerCharactersLabel);
    root.getChildren().add(totalEnemyCharactersLabel);
    root.getChildren().add(alivePlayerCharactersLabel);
    root.getChildren().add(aliveEnemyCharactersLabel);
    root.getChildren().add(gamePhase);
    root.getChildren().add(gameOver);
    root.getChildren().add(totalWeaponLabel);

    Button next = new Button("Next");
    next.setLayoutY(460);
    next.setLayoutX(400);
    next.setOnAction(event -> {
      try {
        controller.doPhaseAction();
      } catch (InvalidTransitionException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(next);

    Button attackEnemy = new Button("Attack the Enemy");
    attackEnemy.setLayoutY(320);
    attackEnemy.setLayoutX(930);
    attackEnemy.setOnAction(event -> {
      String nameOfCharacter = null;
      try {
        nameOfCharacter = controller.getGamePhase().getNameOfCharacterInTurn();
      } catch (InvalidPhaseException | InvalidCharacterException e) {
        System.out.println(e.getMessage());
      }
      IPlayerCharacter playerCharacterAttacker = null;
      try {
        playerCharacterAttacker = controller.getGamePhase().getAlivePlayerCharacter(nameOfCharacter);
      } catch (InvalidAliveCharacterException | InvalidCharacterException | InvalidTransitionException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().attackToEnemySelected(playerCharacterAttacker);
      } catch (InvalidTargetException | InvalidAliveCharacterException | InvalidCharacterException | InvalidTransitionException | InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
    });


    root.getChildren().add(attackEnemy);



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



    Button nextEnemy = new Button("nextEnemy ");
    nextEnemy.setLayoutY(120);
    nextEnemy.setLayoutX(1050);
    nextEnemy.setOnAction(event -> {
      try {
        controller.getGamePhase().setNextEnemy();
      } catch (InvalidAliveCharacterException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(nextEnemy);


    Button previousEnemy = new Button("previousEnemy");
    previousEnemy.setLayoutY(120);
    previousEnemy.setLayoutX(950);
    previousEnemy.setOnAction(event -> {
      try {
        controller.getGamePhase().setPreviousEnemy();
      } catch (InvalidAliveCharacterException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(previousEnemy);


    Button nextPlayerCharacter = new Button("nextPlayerCharacter ");
    nextPlayerCharacter.setLayoutY(180);
    nextPlayerCharacter.setLayoutX(1100);
    nextPlayerCharacter.setOnAction(event -> {
      try {
        controller.getGamePhase().setNextPlayerCharacter();
      } catch (InvalidAliveCharacterException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(nextPlayerCharacter);


    Button previousPlayerCharacter = new Button("previousPlayerCharacter");
    previousPlayerCharacter.setLayoutY(180);
    previousPlayerCharacter.setLayoutX(950);
    previousPlayerCharacter.setOnAction(event -> {
      try {
        controller.getGamePhase().setPreviousPlayerCharacter();
      } catch (InvalidAliveCharacterException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(previousPlayerCharacter);




    Button nextWeapon = new Button("nextWeapon ");
    nextWeapon.setLayoutY(240);
    nextWeapon.setLayoutX(1060);
    nextWeapon.setOnAction(event -> {
      try {
        controller.getGamePhase().setNextWeapon();
      } catch (InvalidTargetException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(nextWeapon);


    Button previousWeapon = new Button("previousWeapon");
    previousWeapon.setLayoutY(240);
    previousWeapon.setLayoutX(950);
    previousWeapon.setOnAction(event -> {
      try {
        controller.getGamePhase().setPreviousWeapon();
      } catch (InvalidTargetException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(previousWeapon);



    Button addEquippedWhiteMage = new Button("Add Equipped White Mage");
    addEquippedWhiteMage.setLayoutY(480);
    addEquippedWhiteMage.setLayoutX(10);
    addEquippedWhiteMage.setOnAction(event -> {

      var sizeOfPlayerCharacterList = controller.getAlivePlayerCharacterList().size();

      try {
        controller.getGamePhase().createWhiteMage("WhiteMage"+sizeOfPlayerCharacterList);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().weaponCreateStaff("StaffWhiteMage"+sizeOfPlayerCharacterList,10,10);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }

      var WhiteMageOne = controller.getAlivePlayerCharacter("WhiteMage"+sizeOfPlayerCharacterList);
      var StaffWhiteMage = controller.getWeaponFromList("StaffWhiteMage"+sizeOfPlayerCharacterList);

      try {
        controller.getGamePhase().equip(WhiteMageOne,StaffWhiteMage);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addEquippedWhiteMage);


    Button addEquippedEngineer = new Button("Add Equipped Engineer");
    addEquippedEngineer.setLayoutY(510);
    addEquippedEngineer.setLayoutX(10);
    addEquippedEngineer.setOnAction(event -> {
      var sizeOfPlayerCharacterList = controller.getAlivePlayerCharacterList().size();

      try {
        controller.getGamePhase().createEngineer("Engineer"+sizeOfPlayerCharacterList);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().weaponCreateAxe("AxeEngineer"+sizeOfPlayerCharacterList,10,10);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }

      var EngineerOne = controller.getAlivePlayerCharacter("Engineer"+sizeOfPlayerCharacterList);
      var AxeEngineer = controller.getWeaponFromList("AxeEngineer"+sizeOfPlayerCharacterList);

      try {
        controller.getGamePhase().equip(EngineerOne,AxeEngineer);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(addEquippedEngineer);







    Button addEquippedKnight = new Button("Add Equipped Knight");
    addEquippedKnight.setLayoutY(540);
    addEquippedKnight.setLayoutX(10);
    addEquippedKnight.setOnAction(event -> {
      var sizeOfPlayerCharacterList = controller.getAlivePlayerCharacterList().size();
      try {
        controller.getGamePhase().createKnight("Knight"+sizeOfPlayerCharacterList);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().weaponCreateAxe("AxeKnight"+sizeOfPlayerCharacterList,10,10);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }

      var Knight = controller.getAlivePlayerCharacter("Knight"+sizeOfPlayerCharacterList);
      var AxeKnight = controller.getWeaponFromList("AxeKnight"+sizeOfPlayerCharacterList);

      try {
        controller.getGamePhase().equip(Knight,AxeKnight);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(addEquippedKnight);




    Button addPowerfulAxe = new Button("add Powerful Axe");
    addPowerfulAxe.setLayoutY(10);
    addPowerfulAxe.setLayoutX(10);
    addPowerfulAxe.setOnAction(event -> {
      try {
        controller.getGamePhase().weaponCreateAxe("AxePowerful",20,55);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addPowerfulAxe);


    Button addPowerfulBow = new Button("add Powerful Bow ");
    addPowerfulBow.setLayoutY(40);
    addPowerfulBow.setLayoutX(10);
    addPowerfulBow.setOnAction(event -> {
      try {
        controller.getGamePhase().weaponCreateBow("BowPowerful",20,55);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addPowerfulBow );

    Button addPowerfulKnife = new Button("add Powerful Knife ");
    addPowerfulKnife.setLayoutY(70);
    addPowerfulKnife.setLayoutX(10);
    addPowerfulKnife.setOnAction(event -> {
      try {
        controller.getGamePhase().weaponCreateKnife("KnifePowerful",20,55);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addPowerfulKnife);






    Button addEquippedThief = new Button("Add Equipped Thief");
    addEquippedThief.setLayoutY(570);
    addEquippedThief.setLayoutX(10);
    addEquippedThief.setOnAction(event -> {
      var sizeOfPlayerCharacterList = controller.getAlivePlayerCharacterList().size();
      try {
        controller.getGamePhase().createThief("Thief"+sizeOfPlayerCharacterList);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().weaponCreateSword("SwordThief"+sizeOfPlayerCharacterList,10,10);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      var ThiefOne = controller.getAlivePlayerCharacter("Thief"+(sizeOfPlayerCharacterList));
        var SwordThief = controller.getWeaponFromList("SwordThief"+(sizeOfPlayerCharacterList));
      try {
        controller.getGamePhase().equip(ThiefOne,SwordThief);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }


    });
    root.getChildren().add(addEquippedThief);


    Button addPowerfulSword = new Button("Add Powerful Sword");
    addPowerfulSword.setLayoutY(100);
    addPowerfulSword.setLayoutX(10);
    addPowerfulSword.setOnAction(event -> {
      try {
        controller.getGamePhase().weaponCreateSword("SwordPowerful",20,55);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addPowerfulSword);




    Button addEquippedBlackMage = new Button("Add Equipped Black Mage");
    addEquippedBlackMage.setLayoutY(600);
    addEquippedBlackMage.setLayoutX(10);
    addEquippedBlackMage.setOnAction(event -> {
      var sizeOfPlayerCharacterList = controller.getAlivePlayerCharacterList().size();
      try {
        controller.getGamePhase().createBlackMage("BlackMageOne"+sizeOfPlayerCharacterList);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().weaponCreateStaff("StaffBlackMage"+sizeOfPlayerCharacterList,10,10);
      } catch (InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      var BlackMageOne = controller.getAlivePlayerCharacter("BlackMageOne"+(sizeOfPlayerCharacterList));
      var StaffBlackMage = controller.getWeaponFromList("StaffBlackMage"+(sizeOfPlayerCharacterList));
      try {
        controller.getGamePhase().equip(BlackMageOne,StaffBlackMage);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addEquippedBlackMage);



    Button addPowerfulStaff = new Button(" add Powerful Staff");
    addPowerfulStaff.setLayoutY(130);
    addPowerfulStaff.setLayoutX(10);
    addPowerfulStaff.setOnAction(event -> {
        try {
          controller.getGamePhase().weaponCreateStaff("StaffPowerful",20,55);
        } catch (InvalidPhaseException e) {
          System.out.println(e.getMessage());
        }
    });
    root.getChildren().add(addPowerfulStaff);



    Button addEnemy = new Button("Add Enemy");
    addEnemy.setLayoutY(630);
    addEnemy.setLayoutX(10);
    addEnemy.setOnAction(event -> {
      var sizeOfEnemyList = controller.getAliveEnemyList().size();
              try {
                controller.getGamePhase().createEnemy("Enemy "+sizeOfEnemyList,10);
              } catch (InvalidPhaseException e) {
                System.out.println(e.getMessage());
              }
            }
    );
    root.getChildren().add(addEnemy);



    Button addEnemyPowerful = new Button("Convert selected enemy into powerful enemy.");
    addEnemyPowerful.setLayoutY(360);
    addEnemyPowerful.setLayoutX(930);
    addEnemyPowerful.setOnAction(event -> {

      IEnemy enemy = null;
      try {
        enemy = controller.getGamePhase().getAliveEnemy(controller.getGamePhase().getEnemySelected());
      } catch (InvalidAliveCharacterException | InvalidCharacterException | InvalidTransitionException e) {
        System.out.println(e.getMessage());
      }

      try {
        controller.getGamePhase().setEnemyDamage((enemy), 101);
      } catch (InvalidPhaseException | InvalidCharacterException e) {
        System.out.println(e.getMessage());
      }
    });
    root.getChildren().add(addEnemyPowerful);






    Button equipWeapon = new Button("Equip Selected Weapon To Selected Player Character");
    equipWeapon.setLayoutY(400);
    equipWeapon.setLayoutX(930);
    equipWeapon.setOnAction(event -> {
      IPlayerCharacter playerCharacterSelected = null;

      try {
        playerCharacterSelected = controller.getGamePhase().getAlivePlayerCharacter(controller.getGamePhase().getPlayerCharacterSelected());
      } catch (InvalidAliveCharacterException | InvalidCharacterException | InvalidTransitionException e) {
        System.out.println(e.getMessage());
      }

      String weaponSelectedNameGui = null;
      try {
        weaponSelectedNameGui = controller.getGamePhase().getWeaponSelected();
      } catch (InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }

      var weapon = controller.getGamePhase().getWeapon(weaponSelectedNameGui);
      IWeapon equippedWeapon = new WeaponNull();
      if (!(playerCharacterSelected==null)){
        equippedWeapon = controller.getEquippedWeaponController(playerCharacterSelected);
      }
      try {
        controller.getGamePhase().unEquip(playerCharacterSelected);
      } catch (InvalidPhaseException | InvalidCharacterException | InvalidTargetException e) {
        System.out.println(e.getMessage());
      }

      try {
        controller.getGamePhase().equip(playerCharacterSelected,weapon);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }

      if(!(playerCharacterSelected==null)){
        if (controller.controllerGetWeaponIsNull(controller.getEquippedWeaponController(playerCharacterSelected))){
          controller.equipController(playerCharacterSelected,equippedWeapon);

        }
      }

    });
    root.getChildren().add(equipWeapon);

    Button equipWeaponCharacterInTurn = new Button("Equip The Player Character in Turn with the selected weapon.");
    equipWeaponCharacterInTurn.setLayoutY(440);
    equipWeaponCharacterInTurn.setLayoutX(930);
    equipWeaponCharacterInTurn.setOnAction(event -> {
      IPlayerCharacter playerCharacterSelected = null;
      try {
        playerCharacterSelected = controller.getGamePhase().getAlivePlayerCharacter(controller.getGamePhase().getNameOfCharacterInTurn());
      } catch (InvalidAliveCharacterException | InvalidCharacterException | InvalidTransitionException | InvalidPhaseException e) {
        System.out.println(e.getMessage());
      }
      String weaponName = null;
      try {
        weaponName = controller.getGamePhase().getWeaponSelected();
      } catch (InvalidCharacterException | InvalidWeaponException e) {
        System.out.println(e.getMessage());
      }
      var weapon = controller.getGamePhase().getWeapon(weaponName);

      try {
        controller.getGamePhase().unEquip(playerCharacterSelected);
      } catch (InvalidPhaseException | InvalidCharacterException | InvalidTargetException e) {
        System.out.println(e.getMessage());
      }
      try {
        controller.getGamePhase().equipToCharacterInTurn(weapon);
      } catch (InvalidPhaseException | InvalidTargetException | InvalidCharacterException | InvalidAliveCharacterException | InvalidTransitionException e) {
        System.out.println(e.getMessage());
      }

    });
    root.getChildren().add(equipWeaponCharacterInTurn);



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

        Set<String> setTotalPlayerCharacters = controller.getGamePhase().getCopyOfSetOfPlayerCharacterNames();
        int totalPlayerCharacters = setTotalPlayerCharacters.size();
        totalPlayerCharactersLabel.setText("Total Player characters: " +totalPlayerCharacters);

        Set<String> setTotalEnemyCharacters = controller.getGamePhase().getCopyOfSetOfEnemyNames();
        int totalEnemyCharacters = setTotalEnemyCharacters.size();
        totalEnemyCharactersLabel.setText("Total Enemy characters: " +totalEnemyCharacters);

        Set<String> setAliveEnemyCharacters = controller.getCopyOfSetOfAliveEnemyCharacters();
        int aliveEnemyCharacters = setAliveEnemyCharacters.size();
        aliveEnemyCharactersLabel.setText("Alive Enemy characters: " +aliveEnemyCharacters);

        Set<String> setTotalWeapon = controller.getSetOfWeaponNames();
        int totalWeapon = setTotalWeapon.size();
        totalWeaponLabel.setText("Total Weapons: " +totalWeapon);

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

        String stringGamePhase = controller.getGamePhase().getType();
        boolean stringGameOver = controller.getGameOver();

        String stringEnemySelected = controller.getEnemySelected();
        guiEnemySelected.setText("Selected Enemy: " +stringEnemySelected );

        String stringPlayerCharacterSelected = controller.getPlayerCharacterSelected();
        guiPlayerCharacterSelected.setText("Selected PlayerCharacter: " +stringPlayerCharacterSelected );

        String stringWeaponSelected = controller.getWeaponSelected();
        guiWeaponSelected.setText("Selected Weapon: " +stringWeaponSelected );

        gamePhase.setText("Game Phase: " +stringGamePhase);
        gameOver.setText("Game Over: " +stringGameOver);
        guiCharacterInTurn.setText("Game Character in Turn: " +stringGuiCharacterInTurn);
        guiEquippedWeaponOfCharacterInTurn.setText("Equipped Weapon: " +stringGuiEquippedWeaponOfCharacterInTurn);
        guiHpOfCharacterInTurn.setText("HP: " +stringGuiHpOfCharacterInTurn );
        guiPotencialDamageOfCharacterInTurn.setText("Potencial Damage: " +stringGuiPotencialDamageOfCharacterInTurn );

      }
    };
    timer.start();
  }

}