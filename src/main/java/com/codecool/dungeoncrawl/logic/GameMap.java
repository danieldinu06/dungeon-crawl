package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.weapons.Weapon;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Weapon weapon;

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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Player getPlayer() {
        return player;
    }

    public Weapon getWeapon() { return weapon; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
