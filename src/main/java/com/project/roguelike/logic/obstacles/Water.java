package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Water extends Obstacle{
    public Water(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "water";
    }
}
