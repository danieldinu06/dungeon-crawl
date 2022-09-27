package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Peasant extends Obstacle{
    public Peasant(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "peasant";
    }
}
