package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.enemies.Enemy;
import com.codecool.dungeoncrawl.logic.landscapes.Tombstone;

import java.util.ArrayList;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int attack = 5;
    private boolean picked = false;
    private final ArrayList<String> items = new ArrayList<>();

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public boolean restrictMovement(Cell nextCell) {
        return nextCell.getObstacle() == null &&
                nextCell.getEnemy() == null;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (restrictMovement(nextCell)) {
            cell.setActor(null);
            if (nextCell.getType() == CellType.SWORD || nextCell.getType() == CellType.AXE) {
                this.attack += nextCell.getWeapon().getAttack();
                items.add(nextCell.getWeapon().getTileName());
                this.picked = true;
            }
            nextCell.setActor(this);
            cell = nextCell;
        }
        if (nextCell.getEnemy() != null) {
            fight(this, nextCell.getEnemy());
            if (nextCell.getEnemy().getHealth() <= 0) {
                nextCell.setEnemy(null);
                nextCell.setLandscape(new Tombstone(nextCell));
                nextCell.setType(CellType.TOMBSTONE);
            }
        }
    }

    public boolean pickUpWeapon() {
        return picked;
    }

    public void setPicked() {
        this.picked = false;
    }

    public int getHealth() { return health; }

    public Cell getCell() {
        return cell;
    }

    public int getAttack(){
        return attack;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    private boolean isDoorClosed(Cell nextCell){
        return nextCell.getType().equals(CellType.DOOR);
    }

    public void fight(Actor player, Enemy enemy){
        enemy.setHealth(enemy.getHealth() - player.getAttack());
        player.setHealth(player.getHealth() - enemy.getAttack());
    }
}
