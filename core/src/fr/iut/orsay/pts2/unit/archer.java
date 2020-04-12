package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

public class archer extends unit {
private double hp;
private double dmg;
private int range;

    public archer(double hp, double dmg, int range) {
        this.hp = 2000;
        this.dmg = 180;
        this.range = 15;
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
    public static void display(archer a){
        System.out.println(a.getHp());
        System.out.println(a.getDmg());
        System.out.println(a.getRange());
    }
    public static void main(String[] args) {
        archer a1 = new archer(0,0,0);
        display(a1);
        a1.toEvolve();
        display(a1);
    }
}
