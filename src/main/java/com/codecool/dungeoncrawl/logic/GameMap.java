package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.enemies.Bat;
import com.codecool.dungeoncrawl.logic.enemies.Enemy;
import com.codecool.dungeoncrawl.logic.enemies.Knight;
import com.codecool.dungeoncrawl.logic.enemies.Skeleton;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Fence;
import com.codecool.dungeoncrawl.logic.obstacles.Obstacle;
import com.codecool.dungeoncrawl.logic.obstacles.Wall;
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
    private final ArrayList<Obstacle> obstacles = new ArrayList<>();


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

    public void addKnight(Cell cell, int health, int attack) {
        enemies.add(new Knight(cell, health, attack));
    }

    public void addSkeleton(Cell cell, int health, int attack) {
        enemies.add(new Skeleton(cell, health, attack));
    }

    public void addBat(Cell cell, int health, int attack) {
        enemies.add(new Bat(cell, health, attack));
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

    public void removeSkeleton(Cell cell) {
        enemies.remove(cell.getActor());
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
    }

    public void removeWeapon(Cell cell) {
        weapons.remove(cell.getWeapon());
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
