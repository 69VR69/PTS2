package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public class archer extends unit {
private double hp=2000;
private double dmg=180;
private int range=15;

    public archer(double hp, double dmg, int range) {
        this.hp = hp;
        this.dmg = dmg;
        this.range = range;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getHp() {
        return hp;
    }

    public double getDmg() {
        return dmg;
    }

    public int getRange() {
        return range;
    }
    public boolean toAttack(){
        boolean isTouched = Gdx.input.isTouched();
        return isTouched;
}
    public void toEvolve(){
        this.setHp(hp*1.5);
        this.setDmg(dmg*1.5);
    }
}
