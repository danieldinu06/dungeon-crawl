package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;

public class Wall extends Obstacle{
    public Wall(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "wall";
    }
}
