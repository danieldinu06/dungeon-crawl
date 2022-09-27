package com.project.roguelike.logic.obstacles;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.Drawable;

public abstract class Obstacle implements Drawable {
    private Cell cell;

    public Obstacle(Cell cell) {
        this.cell = cell;
        this.cell.setObstacle(this);
    }
}
