package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Water extends Obstacle{
    public Water(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "water";
    }
}
