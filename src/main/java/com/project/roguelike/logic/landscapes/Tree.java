package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;

public class Tree extends Landscape{
    public Tree(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tree";
    }
}
