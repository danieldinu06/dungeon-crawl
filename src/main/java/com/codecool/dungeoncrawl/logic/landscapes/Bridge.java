package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bridge extends Landscape{
    public Bridge(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "bridge";
    }
}
