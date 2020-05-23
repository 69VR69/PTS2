package fr.iut.orsay.pts2.interfaces;

import java.util.ArrayList;

public interface Moveable extends Placeable
    {
        ArrayList<Object> forbiddenZone = new ArrayList<>();
        int moveLimit = 1;
        
        boolean move(int x, int y); //if (!forbiddenZone)
        
        void addForbiddenZone(Object... o);
        
        void removeForbiddenZone(Object... o);
    
    
    }
