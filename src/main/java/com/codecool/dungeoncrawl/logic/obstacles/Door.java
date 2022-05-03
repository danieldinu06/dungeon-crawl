package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Key;

public class Door extends Obstacle{
    public Door(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
}
