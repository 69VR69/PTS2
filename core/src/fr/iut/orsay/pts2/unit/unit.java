package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public abstract class unit {
    protected int lvl=1;
    protected double hp;
    protected double dmg;
    protected int range;

    public boolean toAttack() {
        boolean isTouched = Gdx.input.isTouched();
        return isTouched;
    }
    public void toEvolve() {
        this.setHp(hp * 1.5);
        this.setDmg(dmg * 1.5);
        this.setLvl(lvl+1);
    }

    public static void display(unit u) {
        System.out.println(u.getLvl());
        System.out.println(u.getHp());
        System.out.println(u.getDmg());
        System.out.println(u.getRange());
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
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

}
