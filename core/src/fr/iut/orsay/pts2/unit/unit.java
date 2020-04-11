package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public abstract class unit {
    private double hp;
    private double dmg;
    private int range;

    abstract boolean toAttack();

    abstract void toEvolve();
}
