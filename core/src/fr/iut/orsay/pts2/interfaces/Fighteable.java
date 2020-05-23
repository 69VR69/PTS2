package fr.iut.orsay.pts2.interfaces;

import java.util.HashMap;



public interface Fighteable extends Placeable
    {
        HashMap<Object, Integer> modificationTable = new HashMap<>();
        int hp = 100, damage = 0, range = 1, experienceReward = 10;
        
        boolean canAttack();
        
        void attack(Object o);

        int calculDamage(int damage, Object o);
        
        void upModification(int upValue, Object o);
        
        void downModification(int downValue, Object o);
    }