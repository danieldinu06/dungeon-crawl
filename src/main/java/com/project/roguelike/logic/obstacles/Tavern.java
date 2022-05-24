package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Tavern extends Obstacle{
    public Tavern(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tavern";
    }
}
