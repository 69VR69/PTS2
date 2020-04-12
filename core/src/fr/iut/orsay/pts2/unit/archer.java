package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public class archer extends unit {
    private double hp;
    private double dmg;
    private int range;

    public archer() {
        this.hp = 2000;
        this.dmg = 180;
        this.range = 15;
    }

    public static void main(String[] args) {
        archer a1 = new archer();
        display(a1);
        a1.toEvolve();
        display(a1);
    }
}
