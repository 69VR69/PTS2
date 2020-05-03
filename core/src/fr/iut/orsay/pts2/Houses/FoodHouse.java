package fr.iut.orsay.pts2.Houses;

import fr.iut.orsay.pts2.ressources.Food;

public class FoodHouse extends ProductionDistrict {

    public FoodHouse() {
        price=500;
        time=4;
        this.ressource=new Food();
        rm.put(ressource,0);
    }
}
