package com.project.roguelike.logic.actors;

import com.project.roguelike.logic.Cell;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }



    public String getTileName() {
        return "player";
    }
}
