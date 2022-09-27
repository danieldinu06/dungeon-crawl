package com.project.roguelike.logic;

import com.project.roguelike.logic.actors.Actor;
import com.project.roguelike.logic.enemies.Enemy;
import com.project.roguelike.logic.items.Key;
import com.project.roguelike.logic.landscapes.Landscape;
import com.project.roguelike.logic.obstacles.Door;
import com.project.roguelike.logic.obstacles.Obstacle;
import com.project.roguelike.logic.weapons.Weapon;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Enemy enemy;
    private Weapon weapon;
    private Obstacle obstacle;
    private Door door;
    private Key key;

    private Landscape landscape;
    private final GameMap gameMap;
    private final int x, y;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public void setLandscape(Landscape landscape) {
        this.landscape = landscape;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Actor getActor() {
        return actor;
    }

    public Obstacle getObstacle() { return obstacle; }

    public Enemy getEnemy() { return enemy; }

    public Weapon getWeapon() { return weapon; }

    public Key getKey() { return key; }

    public Door getDoor() { return door; }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
