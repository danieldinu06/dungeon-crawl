package com.project.roguelike.logic.weapons;

import com.project.roguelike.logic.Cell;

public class Sword extends Weapon{

    public Sword(int attack) {
        super(attack);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
