package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Key {
    private Cell cell;
    private boolean pickedUp = false;

    public Key(Cell cell) {
        this.cell = cell;
        this.cell.setKey(this);
    }

    public void pickUpKey() {
        pickedUp = true;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }
}
