package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;

public class Highland extends Landscape{
    public Highland(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "highland";
    }
}
