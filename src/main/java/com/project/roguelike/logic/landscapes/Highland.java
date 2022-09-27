package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;

public class Highland extends Landscape{
    public Highland(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "highland";
    }
}
