package fr.iut.orsay.pts2.config;

import com.badlogic.gdx.Gdx;

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
        public final static double OPTI_UNIT_CREATE = 25;
    
        //Unit
        public final static String WILDLAND = "Wildland";
        
        //Civilization
        public final static int NB_RESSOURCES = 3;
        public final static int BASIC_RESSOURCES = 300;
    
        //Tools
        public final static Random RND = new Random();
        public final static int NB_UNITTYPE = 2; //start to 0
    
        public final static int screenwidth = Gdx.graphics.getWidth(), screenHeight = Gdx.graphics.getHeight();
        public final static int textureWidth = screenwidth / MAP_CONFIG.WIDTH, textureHeight = screenHeight / MAP_CONFIG.HEIGHT;
    }
