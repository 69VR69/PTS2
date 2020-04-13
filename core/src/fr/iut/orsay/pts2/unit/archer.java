package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public class archer extends unit {


    public archer() {
        hp = 2000;
        dmg = 180;
        range = 15;
    }

    public static void main(String[] args) {
        archer a1 = new archer();
        display(a1);
        a1.toEvolve();
        display(a1);
    }
}
