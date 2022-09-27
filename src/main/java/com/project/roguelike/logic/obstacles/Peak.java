package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Peak extends Obstacle{
    public Peak(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "peak";
    }
}
