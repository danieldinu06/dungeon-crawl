package com.codecool.dungeoncrawl.logic.enemies;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bear extends Enemy{
    public Bear(Cell cell, int health, int attack, int money) {
        super(cell, health, attack, money);
    }

    @Override
    public String getTileName() {
        return "bear";
    }

    @Override
    public int[] move() {
        return new int[0];
    }
}
