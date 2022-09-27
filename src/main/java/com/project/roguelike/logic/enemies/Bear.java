package com.project.roguelike.logic.enemies;

import com.project.roguelike.logic.Cell;

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
