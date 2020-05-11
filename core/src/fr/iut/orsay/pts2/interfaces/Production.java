package fr.iut.orsay.pts2.interfaces;

import java.util.HashMap;

import fr.iut.orsay.pts2.ressource.Ressource;

public interface Production
    {
        HashMap<Ressource, Integer> stock = new HashMap<>();
        HashMap<Ressource, Float> rate = new HashMap<>();
        HashMap<Ressource, Integer> stockMax = new HashMap<>();
        
        void produce(Ressource ressource);
        
        void consume(Ressource ressource, int quantity);
        
        void upStockMax(int upStock);
        
        void downStockMax(int downStock);
    }
