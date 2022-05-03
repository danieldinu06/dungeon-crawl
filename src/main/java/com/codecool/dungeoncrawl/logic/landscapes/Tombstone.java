package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;

public class Tombstone extends Landscape{
    public Tombstone(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tombstone";
    }
}
