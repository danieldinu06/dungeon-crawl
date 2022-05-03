package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static final Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static final Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("door", new Tile(4, 9));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("bat", new Tile(26, 8));
        tileMap.put("sword", new Tile(4, 30));
        tileMap.put("water", new Tile(8, 5));
        tileMap.put("bridge", new Tile(4, 6));
        tileMap.put("tree", new Tile(4, 2));
        tileMap.put("tavern", new Tile(8, 20));
        tileMap.put("bear", new Tile(30, 8));
        tileMap.put("fence", new Tile(2, 3));
        tileMap.put("bush", new Tile(7, 1));
        tileMap.put("knight", new Tile(29, 0));
        tileMap.put("beacon", new Tile(22, 3));
        tileMap.put("axe", new Tile(8, 29));
        tileMap.put("peasant", new Tile(25, 1));
        tileMap.put("end", new Tile(23, 11));
        tileMap.put("peak", new Tile(1, 12));
        tileMap.put("highland", new Tile(2, 11));
        tileMap.put("tombstone", new Tile(0, 14));
        tileMap.put("unlockeddoor", new Tile(6, 9));

    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
