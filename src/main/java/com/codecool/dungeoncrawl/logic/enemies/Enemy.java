package com.codecool.dungeoncrawl.logic.enemies;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.Random;

public abstract class Enemy implements Drawable {
    protected static Random random = new Random();
    private final Cell cell;
    private int health;
    private final int attack;
    private final int money;

    public Enemy(Cell cell, int health, int attack, int money){
        this.cell = cell;
        this.health = health;
        this.attack = attack;
        this.money = money;
        this.cell.setEnemy(this);
    }

    public Cell getCell() {
        return cell;
    }

    public int getHealth() { return health; }

    public int getAttack() { return attack; }

    public int getMoney() { return money; }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean restrictMovement(Cell nextCell) {
        return nextCell.getType() != CellType.WALL &&
                nextCell.getType() != CellType.WATER &&
                nextCell.getType() != CellType.FENCE &&
                nextCell.getType() != CellType.TAVERN &&
                nextCell.getType() != CellType.SWORD &&
                nextCell.getType() != CellType.AXE &&
                nextCell.getType() != CellType.BEAR &&
                nextCell.getType() != CellType.KNIGHT &&
                nextCell.getType() != CellType.SKELETON;
    }
    public abstract int[] move();

}
