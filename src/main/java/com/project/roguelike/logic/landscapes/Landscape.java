package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.Drawable;

public abstract class Landscape implements Drawable {
    private Cell cell;

    public Landscape(Cell cell) {
        this.cell = cell;
        this.cell.setLandscape(this);
    }
}
