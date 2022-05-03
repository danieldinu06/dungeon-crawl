package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.enemies.*;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.landscapes.*;
import com.codecool.dungeoncrawl.logic.obstacles.*;
import com.codecool.dungeoncrawl.logic.weapons.Axe;
import com.codecool.dungeoncrawl.logic.weapons.Sword;
import com.codecool.dungeoncrawl.logic.weapons.Weapon;

import java.util.ArrayList;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private Player player;
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<Weapon> weapons = new ArrayList<>();


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addKnight(Cell cell, int health, int attack, int money) {
        Enemy knight = new Knight(cell, health, attack, money);
        enemies.add(knight);
        cell.setEnemy(knight);
    }

    public void addSkeleton(Cell cell, int health, int attack, int money) {
        Enemy skeleton = new Skeleton(cell, health, attack, money);
        enemies.add(skeleton);
        cell.setEnemy(skeleton);
    }

    public void addBat(Cell cell, int health, int attack, int money) {
        Enemy bat = new Bat(cell, health, attack, money);
        enemies.add(bat);
        cell.setEnemy(bat);
    }

    public void addBear(Cell cell, int health, int attack, int money) {
        Enemy bear = new Bear(cell, health, attack, money);
        enemies.add(bear);
        cell.setEnemy(bear);
    }

    public void addSword(Cell cell) {
        Weapon sword = new Sword(5);
        weapons.add(sword);
        cell.setWeapon(sword);
    }

    public void addAxe(Cell cell) {
        Weapon axe = new Axe(10);
        weapons.add(axe);
        cell.setWeapon(axe);
    }

    public void addWall(Cell cell) {
        Obstacle wall = new Wall(cell);
        cell.setObstacle(wall);
    }

    public void addDoor(Cell cell) {
        Obstacle door = new Door(cell);
        cell.setObstacle(door);
    }

    public void addKey(Cell cell) {
        Key key = new Key(cell);
        cell.setKey(key);
    }

    public void addWater(Cell cell) {
        Obstacle water = new Wall(cell);
        cell.setObstacle(water);
    }

    public void addFence(Cell cell) {
        Obstacle fence = new Fence(cell);
        cell.setObstacle(fence);
    }

    public void addBridge(Cell cell) {
        Landscape bridge = new Bridge(cell);
        cell.setLandscape(bridge);
    }

    public void addTree(Cell cell) {
        Landscape tree = new Tree(cell);
        cell.setLandscape(tree);
    }

    public void addBush(Cell cell) {
        Landscape bush = new Bush(cell);
        cell.setLandscape(bush);
    }

    public void addHighland(Cell cell) {
        Landscape highland = new Highland(cell);
        cell.setLandscape(highland);
    }

    public void addPeak(Cell cell) {
        Obstacle peak = new Peak(cell);
        cell.setObstacle(peak);
    }

    public void addPeasant(Cell cell) {
        Obstacle peasant = new Peasant(cell);
        cell.setObstacle(peasant);
    }

    public void addTavern(Cell cell) {
        Obstacle tavern = new Tavern(cell);
        cell.setObstacle(tavern);
    }

    public void removeWeapon(Cell cell) {
        weapons.remove(cell.getWeapon());
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
