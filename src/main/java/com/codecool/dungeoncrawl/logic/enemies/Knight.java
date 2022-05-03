package com.codecool.dungeoncrawl.logic.enemies;

import com.codecool.dungeoncrawl.logic.Cell;

public class Knight extends Enemy {

    public Knight(Cell cell, int health, int attack, int money) {
        super(cell, health, attack, money);
    }

    @Override
    public String getTileName() { return "knight"; }

    @Override
    public int[] move() {
        return new int[0];
    }
}
