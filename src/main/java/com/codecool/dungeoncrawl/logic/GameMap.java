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
    private final ArrayList<Skeleton> skeletons = new ArrayList<>();
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

    public void addSkeleton(Cell cell) {
        skeletons.add(new Skeleton(cell));
    }

    public void removeSkeleton(Cell cell) {
        skeletons.remove(cell.getActor());
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
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

    public void removeWeapon(Cell cell) {
        weapons.remove(cell.getWeapon());
        cells[cell.getX()][cell.getY()].setType(CellType.FLOOR);
    }

    public Player getPlayer() {
        return player;
    }

<<<<<<< HEAD
    public ArrayList<Skeleton> getSkeletons() {
=======
    public Skeleton[][] getSkeleton() {
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
        return skeletons;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
