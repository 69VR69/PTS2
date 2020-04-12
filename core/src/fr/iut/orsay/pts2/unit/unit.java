package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public abstract class unit {
    private double hp;
    private double dmg;
    private int range;

    public boolean toAttack() {
        boolean isTouched = Gdx.input.isTouched();
        return isTouched;
    }
    public void toEvolve() {
        this.setHp(hp * 1.5);
        this.setDmg(dmg * 1.5);
    }
    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
    public static void display(unit u) {
        System.out.println(u.getHp());
        System.out.println(u.getDmg());
        System.out.println(u.getRange());
    }
}
