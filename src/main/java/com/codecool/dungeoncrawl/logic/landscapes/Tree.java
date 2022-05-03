package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;

public class Tree extends Landscape{
    public Tree(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tree";
    }
}
