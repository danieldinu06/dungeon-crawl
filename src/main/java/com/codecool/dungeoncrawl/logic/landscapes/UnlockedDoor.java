package com.codecool.dungeoncrawl.logic.landscapes;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public class UnlockedDoor extends Landscape {
    public UnlockedDoor(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "unlockeddoor";
    }
}
