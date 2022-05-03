package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Wall extends Obstacle{
    public Wall(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "wall";
    }
}
