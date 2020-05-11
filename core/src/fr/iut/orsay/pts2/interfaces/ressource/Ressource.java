package fr.iut.orsay.pts2.interfaces.ressource;

import fr.iut.orsay.pts2.interfaces.Production;

public abstract class Ressource implements Production {
    @Override
    public void produce(fr.iut.orsay.pts2.ressource.Ressource ressource) {

    }

    @Override
    public void consume(fr.iut.orsay.pts2.ressource.Ressource ressource, int quantity) {

    }

    @Override
    public void upStockMax(int upStock) {

    }

    @Override
    public void downStockMax(int downStock) {

    }
}
