package com.codecool.dungeoncrawl.logic.enemies;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bat extends Enemy{
    public Bat(Cell cell, int health, int attack, int money) {
        super(cell, health, attack, money);
    }

    @Override
    public String getTileName() {
        return "bat";
    }

    @Override
    public int[] move() {
        return new int[0];
    }


}
