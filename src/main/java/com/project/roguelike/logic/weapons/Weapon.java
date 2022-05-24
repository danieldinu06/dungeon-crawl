package com.project.roguelike.logic.weapons;

import com.project.roguelike.logic.Drawable;

public abstract class Weapon implements Drawable {
    private final int attack;

    public Weapon(int attack) {
        this.attack = attack;
    }

    public int getAttack() { return this.attack; }
}
