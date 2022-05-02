package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Weapon{

    public Sword(Cell cell, int attack) {
        super(cell, attack);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
