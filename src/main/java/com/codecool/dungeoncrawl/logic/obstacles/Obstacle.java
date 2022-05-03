package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Obstacle implements Drawable {
    private Cell cell;

    public Obstacle(Cell cell) {
        this.cell = cell;
        this.cell.setObstacle(this);
    }
}
