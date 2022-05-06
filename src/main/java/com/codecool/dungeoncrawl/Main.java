package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.enemies.Enemy;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

import static javafx.animation.Animation.INDEFINITE;

public class Main extends Application {
    private final static String[] maps = {"/map.txt", "/map2.txt", "/map3.txt"};
    private int currentLevel = 0;
    GameMap map = MapLoader.loadMap(maps[currentLevel]);
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Button quitButton = new Button("Quit");
    Label healthText = new Label();
    Label attackText = new Label();
    Label inventoryText = new Label();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(300);
        ui.setPadding(new Insets(30, 30, 30, 30));

        Label healthLabel = new Label("Health");
        GridPane.setConstraints(healthLabel, 0, 0);
        GridPane.setConstraints(healthText, 1, 0);

        Label attackLabel = new Label("Attack");
        GridPane.setConstraints(attackLabel, 0, 1);
        GridPane.setConstraints(attackText, 1, 1);

        Label inventoryLabel = new Label("Inventory");
        GridPane.setConstraints(inventoryLabel, 0, 2);
        GridPane.setConstraints(inventoryText, 1, 2);

        Button quitButton = new Button("Quit");
        GridPane.setConstraints(quitButton, 0, 5);

        quitButton.setOnAction(this::handleQuitButtonEvent);


        ui.getChildren().addAll(healthLabel, healthText, attackLabel, attackText, inventoryLabel, inventoryText, quitButton);

        quitButton.getStyleClass().add("quit-button");

        BorderPane borderPane = new BorderPane();
        canvas.setFocusTraversable(true);
        ui.setFocusTraversable(true);
        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("CSS/Button.css");
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
        //playMusic();
        quitButton.setOnAction(this::handleQuitButtonEvent);
    }

//    private void playMusic(){
//        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sound/music.mp3").toExternalForm()));
//        mediaPlayer.play();
//    }

    private void handleQuitButtonEvent(javafx.event.ActionEvent actionEvent) {
        System.exit(100);
    }

    private void moveEnemies() {
        //map.getEnemies().forEach(Enemy::move);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                moveEnemies();
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                moveEnemies();
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                moveEnemies();
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                moveEnemies();
                refresh();
                break;
            case T:
                currentLevel = 0;
                map = MapLoader.loadMap(maps[currentLevel]);
                map = MapLoader.loadMap(maps[currentLevel]);
                refresh();
                break;
        }
        if (map.getPlayer().getCell().getType().equals(CellType.TELEPORT)) {
            currentLevel++;
            int currentHealth = map.getPlayer().getHealth();
            int currentAttack = map.getPlayer().getAttack();
            ArrayList<String> currentItems = map.getPlayer().getItems();

            map = MapLoader.loadMap(maps[currentLevel]);
            map.getPlayer().setHealth(currentHealth);
            map.getPlayer().setAttack(currentAttack);
            map.getPlayer().setItems(currentItems);

            context.getCanvas().setHeight(map.getHeight() * Tiles.TILE_WIDTH);
            context.getCanvas().setWidth(map.getWidth() * Tiles.TILE_WIDTH);
            refresh();
        }
        if (map.getPlayer().getCell().getType().equals(CellType.END)) {
            System.out.println("You win!");
            System.exit(100);
        }
        if (map.getPlayer().getHealth() <= 0) {
            System.out.println("Game Over!");
            System.exit(100);
        }

        if (map.getPlayer().pickUpWeapon()) {
            if (Objects.equals(inventoryText.getText(), "")) {
                inventoryText.setText(map.getPlayer().getCell().getWeapon().getTileName());
            } else {
                inventoryText.setText(inventoryText.getText() + ", " + map.getPlayer().getCell().getWeapon().getTileName());
            }
            map.removeWeapon(map.getPlayer().getCell());
            map.getPlayer().setPicked();
        }
    }

    private void refresh() {
        context.setFill(Color.WHITE);
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
        healthText.setText(String.valueOf(map.getPlayer().getHealth()));
        attackText.setText(String.valueOf(map.getPlayer().getAttack()));
    }
}
