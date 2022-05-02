package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.weapons.Axe;
import com.codecool.dungeoncrawl.logic.weapons.Sword;
import com.codecool.dungeoncrawl.logic.weapons.Weapon;

import java.util.ArrayList;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    private Player player;
    private final Skeleton[][] skeletons;
    private final Weapon[][] weapons;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        skeletons = new Skeleton[width][height];
        weapons = new Weapon[width][height];
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

    public void addSkeleton(Cell cell) {
        skeletons[cell.getX()][cell.getY()] = new Skeleton(cell);
    }

    public void addSword(Cell cell) {
        weapons[cell.getX()][cell.getY()] = new Sword(5);
        cell.setWeapon(weapons[cell.getX()][cell.getY()]);
    }

    public void addAxe(Cell cell) {
        weapons[cell.getX()][cell.getY()] = new Axe(10);
        cell.setWeapon(weapons[cell.getX()][cell.getY()]);
    }

    public void removeWeapon(Cell cell) {
        weapons[cell.getX()][cell.getY()] = null;
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
    }

    public Player getPlayer() {
        return player;
    }

    public Skeleton getSkeleton(Cell cell) {
        return skeletons[cell.getX()][cell.getY()];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
