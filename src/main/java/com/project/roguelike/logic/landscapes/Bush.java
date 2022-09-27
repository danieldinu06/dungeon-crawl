package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;

public class Bush extends Landscape{
    public Bush(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "bush";
    }
}
