package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int attack;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
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

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setHealth(int health){
        this.health = health;
    }


    public boolean fight(Player player, Actor monster){
        while(player.getHealth() >= 1 && monster.getHealth() >= 1){
            monster.setHealth(monster.getHealth() - player.getAttack());
            player.setHealth(monster.getHealth() - player.getAttack());
        }
        if(monster.getHealth() <= 0){
            return true;
        }
        else return false;
    }

}
