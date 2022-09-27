package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Fence extends Obstacle{
    public Fence(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
}
