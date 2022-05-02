package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Weapon implements Drawable {
    private final Cell cell;
    private final int attack;

    public Weapon(Cell cell, int attack) {
        this.attack = attack;
        this.cell = cell;
        this.cell.setWeapon(this);
    }

    public Cell getWeaponCell() {
        return this.cell;
    }

    public void removeWeaponFromMap() {
        this.cell.setType(CellType.FLOOR);
    }

    public int getAttack() { return this.attack; }
}
