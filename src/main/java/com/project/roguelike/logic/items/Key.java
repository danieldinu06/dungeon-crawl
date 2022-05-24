package com.project.roguelike.logic.items;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.Drawable;

public class Key implements Drawable {

    public Key(Cell cell) {
        cell.setKey(this);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
