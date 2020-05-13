package fr.iut.orsay.pts2.interfaces.houses;

import fr.iut.orsay.pts2.interfaces.Placeable;
import fr.iut.orsay.pts2.interfaces.Production;
import fr.iut.orsay.pts2.interfaces.Upgradable;
import fr.iut.orsay.pts2.ressource.Ressource;

public abstract class Building implements Placeable, Production, Upgradable
    {
        @Override public boolean changePosition(int posX, int posY)
            {
                return false;
            }
        
        @Override public boolean swapPosition(Object o1, Object o2)
            {
                return false;
            }
        
        @Override public boolean addToBoard(int posX, int posY, int weight, float depressionRate)
            {
                return false;
            }
        
        @Override public boolean removeFromBoard()
            {
                return false;
            }
        
        @Override public void upDepressionRate(float upRate)
            {
            
            }
        
        @Override public void downDepressionRate(float downRate)
            {
            
            }
        
        @Override public void upWeight(int upValue)
            {
            
            }
        
        @Override public void downWeight(int downValue)
            {
            
            }
        
        @Override public void produce(Ressource ressource)
            {
            
            }
        
        @Override public void consume(Ressource ressource, int quantity)
            {
            
            }
        
        @Override public void upStockMax(int upStock)
            {
            
            }
        
        @Override public void downStockMax(int downStock)
            {
            
            }
        
        @Override public void upLevel(int nbLevel)
            {
            
            }
        
        @Override public void downLevel(int nbLevel)
            {
            
            }
        
        @Override public void addExperiencePoint(int point)
            {
            
            }
        
        @Override public void removeExperiencePoint(int point)
            {
            
            }
    }
