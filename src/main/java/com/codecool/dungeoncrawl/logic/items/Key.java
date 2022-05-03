package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public class Key implements Drawable {

    public Key(Cell cell) {
        cell.setKey(this);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
