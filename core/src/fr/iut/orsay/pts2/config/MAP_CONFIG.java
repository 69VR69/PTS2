package fr.iut.orsay.pts2.config;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import fr.iut.orsay.pts2.map.Element;
import fr.iut.orsay.pts2.map.ElementType;

public abstract class MAP_CONFIG
    {
        //Constants
        public final static Random RND = new Random();
        public final static int WIDTH = 4; //1 2 4 5 8 10 16 20 32 40 80
        public final static int HEIGHT = 4;
        public final static int TOLERANCE = 4;
        private final static int PERCENTGROUND = 70;
        private final static int PERCENTWATER = 10;
        private final static int PERCENTSAND = 20;
        private final static int PERCENTFOREST = 20;
        private final static int PERCENTMOUNTAIN = 20;
        private static Element[] possibleElement = setPossibleElement();
        
        //Methods
        private static Element[] setPossibleElement()
            {
                Element[] possibleElement = new Element[5];
                possibleElement[0] = new Element(new ElementType(0, MAP_CONFIG.PERCENTGROUND, Gdx.files.internal("texture/terre.png")));
                possibleElement[1] = new Element(new ElementType(1, MAP_CONFIG.PERCENTWATER, Gdx.files.internal("texture/eau.png"), Gdx.files.internal("texture/eau2.png")));
                possibleElement[2] = new Element(new ElementType(2, MAP_CONFIG.PERCENTFOREST, Gdx.files.internal("texture/foret.png")));
                possibleElement[3] = new Element(new ElementType(3, MAP_CONFIG.PERCENTSAND, Gdx.files.internal("texture/sable.png")));
                possibleElement[4] = new Element(new ElementType(4, MAP_CONFIG.PERCENTMOUNTAIN, Gdx.files.internal("texture/montagne.png")));
                return possibleElement;
            }
        
        public static Element RandomElement()
            {
                Element x = null;
                while (x == null)
                    {
                        Element a = possibleElement[MAP_CONFIG.RND.nextInt(possibleElement.length)];
                        if (Tools.getLuck(a.getElementType().getPercent()))
                            x = a;
                    }
                return x;
            }
    }
