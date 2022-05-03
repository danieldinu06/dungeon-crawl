package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Landscape implements Drawable {
    private Cell cell;

    public Landscape(Cell cell) {
        this.cell = cell;
        this.cell.setLandscape(this);
    }
}
