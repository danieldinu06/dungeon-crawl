package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Peasant extends Obstacle{
    public Peasant(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "peasant";
    }
}
