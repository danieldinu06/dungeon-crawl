package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

import java.util.Random;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

<<<<<<< HEAD
    public int[] move(){
=======
    public int[] move(int x){
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
        int dx = 0;
        int dy = 0;
        switch (getMovementNumber()){
            case 1:
                dy = -1;
                break;
            case 2:
                dy = 1;
                break;
            case 3:
                dx = -1;
                break;
            case 4:
                dx = 1;
                break;
        }
<<<<<<< HEAD

        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if (!restrictMovement(nextCell)) {
            move();
        }
        return new int[] {dx, dy};
=======
        return new int[]{dx, dy};
>>>>>>> f75e7abc1de481f38ed3fd9e2980775f69eed5a8
    }



    public int getMovementNumber(){
        Random number = new Random();
        int low = 1;
        int high = 5;
        return number.nextInt(high - low) + low;
    }
}
