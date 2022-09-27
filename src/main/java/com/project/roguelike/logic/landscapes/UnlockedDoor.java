package com.project.roguelike.logic.landscapes;

import com.project.roguelike.logic.Cell;
import com.project.roguelike.logic.Drawable;

public class UnlockedDoor extends Landscape {
    public UnlockedDoor(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "unlockeddoor";
    }
}
