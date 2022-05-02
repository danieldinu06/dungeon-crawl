package com.codecool.dungeoncrawl.logic.weapons;

import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Weapon implements Drawable {
    private final int attack;

    public Weapon(int attack) {
        this.attack = attack;
    }

    public int getAttack() { return this.attack; }
}
