package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bush extends Landscape{
    public Bush(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "bush";
    }
}
