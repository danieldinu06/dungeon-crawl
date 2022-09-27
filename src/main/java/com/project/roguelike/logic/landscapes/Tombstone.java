package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;

public class Tombstone extends Landscape{
    public Tombstone(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tombstone";
    }
}
