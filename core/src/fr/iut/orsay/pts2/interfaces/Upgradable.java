package fr.iut.orsay.pts2.interfaces;

import java.util.HashMap;

public interface Upgradable
    {
        HashMap<Integer, Integer> levels = new HashMap<>(); //<numLevel,experienceRequired> : numLevel = 0-maxLevel
        int level = 0, experiencePoint = 0;
        
        void upLevel(int nbLevel);
        
        void downLevel(int nbLevel);
        
        void addExperiencePoint(int point);
        
        void removeExperiencePoint(int point);
    }
