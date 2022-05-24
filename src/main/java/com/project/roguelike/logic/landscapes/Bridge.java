package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;

public class Bridge extends Landscape{
    public Bridge(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "bridge";
    }
}
