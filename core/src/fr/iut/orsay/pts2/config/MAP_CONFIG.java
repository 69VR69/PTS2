package fr.iut.orsay.pts2.config;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import fr.iut.orsay.pts2.map.Element;
import fr.iut.orsay.pts2.map.ElementType;

public abstract class MAP_CONFIG
    {
        //Constants
        public final static Random RND = new Random();
        public final static int WIDTH = 32; //desktop: 1 8 16 32 64 128
        public final static int HEIGHT = 32; //android: 8 12 24
        public final static int TOLERANCE = 45;
        private final static int PERCENTGROUND = 50;
        private final static int PERCENTWATER = 1;
        private final static int PERCENTSAND = 30;
        private final static int PERCENTFOREST = 30;
        private final static int PERCENTMOUNTAIN = 0;
        private static Element[] possibleElement = setPossibleElement();
        
        //Methods
        private static Element[] setPossibleElement()
            {
                Element[] possibleElement = new Element[5];
                possibleElement[0] = new Element(new ElementType(0, MAP_CONFIG.PERCENTGROUND, Gdx.files.internal("texture/Grass.png")));
                possibleElement[1] = new Element(new ElementType(1, MAP_CONFIG.PERCENTWATER, Gdx.files.internal("texture/water.png")));
                possibleElement[2] = new Element(new ElementType(2, MAP_CONFIG.PERCENTFOREST, Gdx.files.internal("texture/Forest.png")));
                possibleElement[3] = new Element(new ElementType(3, MAP_CONFIG.PERCENTSAND, Gdx.files.internal("texture/Sand.png")));
                //possibleElement[4] = new Element(new ElementType(4, MAP_CONFIG.PERCENTMOUNTAIN, Gdx.files.internal("texture/montagne.png")));
                return possibleElement;
            }
        
        public static Element RandomElement()
            {
                Element x = null;
                while (x == null)
                    {
                        x = possibleElement[MAP_CONFIG.RND.nextInt(possibleElement.length)];
                    }
                return x;
            }
    }
