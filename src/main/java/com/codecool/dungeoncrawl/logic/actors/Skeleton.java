package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

import java.util.Random;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    public int[] move(int x){
        int dx = 0;
        int dy = 0;
        switch (getMovementNumber()){
            case 1:
                dx = 0;
                dy = -1;
                break;
            case 2:
                dx = 0;
                dy = 1;
                break;
            case 3:
                dx = -1;
                dy = 0;
                break;
            case 4:
                dx = 1;
                dy = 0;
                break;
        }
        return new int[]{dx, dy};
    }



    public int getMovementNumber(){
        Random number = new Random();
        int low = 1;
        int high = 5;
        return number.nextInt(high - low) + low;
    }
}
