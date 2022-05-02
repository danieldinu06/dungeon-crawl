package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Weapon{

    public Sword(int attack) {
        super(attack);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
