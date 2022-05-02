package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    BAT("bat"),
    KNIGHT("knight"),
    BEAR("bear"),
    SWORD("sword"),
    WATER("water"),
    BRIDGE("bridge"),
    HOUSE("house"),
    DOOR("door"),
    KEY("key"),
    AXE("axe"),
    TREE("tree"),
    FENCE("fence"),
    BUSH("bush"),
    WALL("wall");


    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
