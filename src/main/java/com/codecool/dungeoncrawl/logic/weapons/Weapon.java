package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Weapon implements Drawable {
    private Cell cell;
    private int attack;

    public Weapon(Cell cell) {
        this.cell = cell;
        this.cell.setWeapon(this);
    }
}
