package fr.iut.orsay.pts2.Houses;

import java.util.HashMap;

import fr.iut.orsay.pts2.CONSTANT;
import fr.iut.orsay.pts2.ressource.Ressource;

public class ProductionDistrict extends Building {
    protected int maxStock=200;
    protected int rate=2;
    protected static HashMap<Ressource, Integer> rm=new HashMap<>();
    protected Ressource ressource;


    public HashMap<Ressource, Integer> getRm() {
        return rm;
    }

    public void setRm(HashMap<Ressource, Integer> rm) {
        this.rm = rm;
    }

    public void produce() {
        rm.put(this.getRessource(),rm.get(this.getRessource())+this.getRate());
    }

    public void upgrade(){
        this.setLevel(this.getLevel()+1);
        this.setMaxStock((int) (this.getMaxStock()* CONSTANT.upMaxStock));
        this.setTime((int) (this.getTime()*CONSTANT.upTime));
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }
}
