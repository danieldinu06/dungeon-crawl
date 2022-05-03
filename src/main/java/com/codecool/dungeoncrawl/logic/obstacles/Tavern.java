package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Tavern extends Obstacle{
    public Tavern(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tavern";
    }
}
