package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public class boat extends unit {
    private double hp;
    private double dmg;
    private int range;

    public boat() {
        this.hp = 5000;
        this.dmg = 300;
        this.range = 10;
    }
}
