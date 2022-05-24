package com.project.roguelike.logic.enemies;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.CellType;
import com.project.roguelike.logic.enemies.Enemy;

import java.util.Random;

public class Skeleton extends Enemy {
    public Skeleton(Cell cell, int health, int attack, int money) {
        super(cell, health, attack, money);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    public int[] move() {
        int dx = 0;
        int dy = 0;
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        do {
            switch (getMovementNumber()) {
                case 1:
                    dy = -1;
                    break;
                case 2:
                    dy = 1;
                    break;
                case 3:
                    dx = -1;
                    break;
                case 4:
                    dx = 1;
                    break;
            }
        } while(!restrictMovement(nextCell));

        return new int[] {dx, dy};
    }

    public int getMovementNumber(){
        Random number = new Random();
        int low = 1;
        int high = 5;
        return number.nextInt(high - low) + low;
    }
}
