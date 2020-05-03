package fr.iut.orsay.pts2.Houses;


import fr.iut.orsay.pts2.ressources.Ore;

public class OreHouse extends ProductionDistrict {

    public OreHouse() {
        price=500;
        time=4;
        this.ressource=new Ore();
        rm.put(ressource,0);

    }


}
