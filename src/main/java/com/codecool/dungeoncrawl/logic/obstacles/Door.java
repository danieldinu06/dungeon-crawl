package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Key;

public class Door extends Obstacle{
    private Key key;
    private boolean locked = true;

    public Door(Cell cell) {
        super(cell);
    }

    public void unlockDoor() {
        if (!key.isPickedUp()) {
            this.locked = false;
        }
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String getTileName() {
        return null;
    }
}
