package fr.iut.orsay.pts2.unit;

public class boat {
    private double hp;
    private double dmg;
    private int range;

    public boat(double hp, double dmg, int range) {
        this.hp = 5000;
        this.dmg = 300;
        this.range = 10;
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
    public void toEvolve(){
        this.setHp(hp*1.5);
        this.setDmg(dmg*1.5);
    }
    public static void display(soldier a){
        System.out.println(a.getHp());
        System.out.println(a.getDmg());
        System.out.println(a.getRange());
    }
}
