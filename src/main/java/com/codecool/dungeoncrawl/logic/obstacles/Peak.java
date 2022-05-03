package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Peak extends Obstacle{
    public Peak(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "peak";
    }
}
