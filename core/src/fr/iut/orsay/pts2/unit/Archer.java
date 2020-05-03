package fr.iut.orsay.pts2.unit;

public class Archer extends Unit {


    public Archer() {
        hp = 2000;
        dmg = 180;
        range = 15;
    }

    @Override
    public String toString() {
        return "archer{" +
                "lvl=" + lvl +
                ", hp=" + hp +
                ", dmg=" + dmg +
                ", range=" + range +
                '}';
    }

    public static void main(String[] args) {
        Archer a=new Archer();
        System.out.println(a.toString());
    }
}
