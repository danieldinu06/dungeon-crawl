package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Cell;

public class Axe extends Weapon{

    public Axe(int attack) {
        super(attack);
    }

    @Override
    public String getTileName() {
        return "axe";
    }
}
