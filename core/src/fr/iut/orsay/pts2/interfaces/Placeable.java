package fr.iut.orsay.pts2.interfaces;

public interface Placeable
    {
        int posX = 0, posY = 0;
        int weight = 10;
        float depressionRate = 0.2f;
        boolean onBoard = false;
        
        boolean addToBoard(int posX, int posY, int weight, float depressionRate);
        
        boolean changePosition(int posX, int posY);
        
        boolean swapPosition(Object o1, Object o2);
        
        boolean removeFromBoard();
        
        void upDepressionRate(float upRate);
        
        void downDepressionRate(float downRate);
        
        void upWeight(int upValue);
        
        void downWeight(int downValue);
    
        float getPosX();
    
        void setPosX(float x);
    
        float getPosY();
    
        void setPosY(float y);
    
        boolean isOnBoard();
    
        void setOnBoard(boolean board);
    }