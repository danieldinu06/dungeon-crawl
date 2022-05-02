package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.weapons.Sword;
import com.codecool.dungeoncrawl.logic.weapons.Weapon;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int attack = 5;
    private boolean picked = false;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public boolean restrictMovement(Cell nextCell) {
        return nextCell.getType() != CellType.WALL &&
                nextCell.getType() != CellType.WATER &&
                nextCell.getType() != CellType.FENCE &&
                nextCell.getType() != CellType.HOUSE &&
//                nextCell.getType() != CellType.SWORD &&
                nextCell.getType() != CellType.AXE &&
                nextCell.getType() != CellType.BEAR &&
                nextCell.getType() != CellType.KNIGHT &&
                nextCell.getType() != CellType.SKELETON;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (restrictMovement(nextCell)) {
            cell.setActor(null);
            if (nextCell.getType() == CellType.SWORD || nextCell.getType() == CellType.AXE) {
                this.attack += nextCell.getWeapon().getAttack();
                this.picked = true;
            }
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public boolean pickUpWeapon() {
        return picked;
    }

    public void setPicked() {
        this.picked = false;
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public int getAttack(){
        return attack;
    }

    public void setHealth(int health){
        this.health = health;
    }


    public boolean fight(Player player, Actor monster){
        while(player.getHealth() >= 1 && monster.getHealth() >= 1){
            monster.setHealth(monster.getHealth() - player.getAttack());
            player.setHealth(monster.getHealth() - player.getAttack());
        }
        return monster.getHealth() <= 0;
    }
}
