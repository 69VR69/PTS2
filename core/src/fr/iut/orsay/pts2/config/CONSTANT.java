package fr.iut.orsay.pts2;

import java.util.Random;

public abstract class CONSTANT
    {
        //AI
        public final static double ALLIANCE_COMMONWAR = 50;
        public final static double ALLIANCE_RESSOURCE = 70;
        public final static double FRIEND_RESSOURCE = 70;
        public final static double GOODFRIEND_ALLIANCE = 70;
        public final static double GOODFRIEND_RESSOURCE = 70;
        public final static double ENNEMIE_WAR = 70;
        public final static double WAR_PEACE = 70;
    
        //Civilization
        public final static int NB_RESSOURCES = 3;
        public final static int BASIC_RESSOURCES = 300;
    
        //Tools
        public final static Random RND = new Random();
        public static final int NB_UNITTYPE = 2; //start to 0

        //unit
        public final static double evolve=1.5;

        //ProductionDistrict
        public final static double upMaxStock=1.5;
        public final static double upTime = 0.9;
    }
