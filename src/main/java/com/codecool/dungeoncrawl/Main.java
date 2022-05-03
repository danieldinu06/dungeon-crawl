package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
<<<<<<< HEAD
=======
import com.codecool.dungeoncrawl.logic.actors.Enemy;
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8

public class Main extends Application {
    private final static String[] maps = {"/map.txt", "/map2.txt", "/map3.txt"};
    private int currentLevel = 0;
    ArrayList<Enemy> enemies = new ArrayList<>();
    GameMap map = MapLoader.loadMap(enemies, maps[currentLevel]);
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Button quitButton = new Button("Quit");
    Label healthLabel = new Label();
    Label attackLabel = new Label();
    Label inventoryLabel = new Label();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        ui.add(new Label("Attack Damage: "), 0, 5);
        ui.add(attackLabel, 1, 0);

        ui.add(new Label("Inventory: "), 0, 10);
        ui.add(inventoryLabel, 10, 0);

<<<<<<< HEAD
        //ui.add(quitButton, 50, 150);
=======
//        ui.add(quitButton, 50, 150);
//        quitButton.setOnAction(this::handleQuitButtonEvent);

>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8

        quitButton.getStyleClass().add("quit-button");

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

<<<<<<< HEAD
=======



>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
        Scene scene = new Scene(borderPane);
        //scene.getStylesheets().add("CSS/Button.css");
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();

<<<<<<< HEAD
        //quitButton.setOnAction(this::handleQuitButtonEvent);
=======
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
    }

    private void handleQuitButtonEvent(javafx.event.ActionEvent actionEvent) {
        System.exit(100);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                refresh();
                break;
            case R:
                currentLevel = 0;
                enemies = new ArrayList<Enemy>();
                map = MapLoader.loadMap(enemies, maps[currentLevel]);
                refresh();
                break;
        }

<<<<<<< HEAD
        refreshSkeletons();

=======
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
        if (map.getPlayer().pickUpWeapon()) {
            map.removeWeapon(map.getPlayer().getCell());
            map.getPlayer().setPicked();
        }

    }

<<<<<<< HEAD
    public void refreshSkeletons() {
        for (Skeleton skeleton : map.getSkeletons()) {
            System.out.println(skeleton.getCell());
        }
    }

=======
    Sound sound = new Sound();

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }



>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        attackLabel.setText("\n" + map.getPlayer().getAttack());
    }
}
