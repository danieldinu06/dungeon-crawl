package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.items.Key;

public class Door extends Obstacle{
    public Door(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
}
