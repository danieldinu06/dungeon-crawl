package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Fence extends Obstacle{
    public Fence(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
}
