package fr.iut.orsay.pts2.Houses;

import fr.iut.orsay.pts2.ressources.Wood;

public class WoodHouse extends ProductionDistrict {
    Wood w=new Wood();
    public WoodHouse() {
        price=100;
        time=1;
        this.ressource=new Wood();
        rm.put(ressource,0);
    }
}
