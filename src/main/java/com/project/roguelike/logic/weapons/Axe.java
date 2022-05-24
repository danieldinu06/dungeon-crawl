package com.project.roguelike.logic.weapons;

import com.project.roguelike.logic.Cell;

public class Axe extends Weapon{

    public Axe(int attack) {
        super(attack);
    }

    @Override
    public String getTileName() {
        return "axe";
    }
}
