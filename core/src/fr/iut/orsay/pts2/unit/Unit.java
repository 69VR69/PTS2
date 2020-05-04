package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;

import fr.iut.orsay.pts2.CONSTANT;

import static fr.iut.orsay.pts2.Tools.getDistance;

public abstract class Unit {
    protected int lvl=1;
    protected double hp;
    protected double dmg;
    protected int range;
    private int posX, posY;
    private int weight;

    public void attack(Unit u1) {
        boolean isTouched = Gdx.input.isTouched(); //TODO : préciser action de toucher l'écran
        if(isTouched && getDistance(u1, this)<=range){
            u1.setHp(u1.getHp()-this.getDmg());
            this.setHp(this.getHp()-(u1.getDmg()/2.5));
        }
    }
    public void evolve() {
        this.setHp(hp * CONSTANT.evolve);
        this.setDmg(dmg * CONSTANT.evolve);
        this.setLvl(lvl+1);
    }
    public void move{

    }
    @Override
    public String toString() {
        return "unit{" +
                "lvl=" + lvl +
                ", hp=" + hp +
                ", dmg=" + dmg +
                ", range=" + range +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}