package fr.iut.orsay.pts2.config;

import java.util.ArrayList;
import java.util.Arrays;

import fr.iut.orsay.pts2.Civilization;

public abstract class Tools
    {
        public static boolean getLuck(double coef)
            {
                if (coef < 0 || coef > 100)
                    try
                        {
                            throw new Exception("coef is out of bounds");
                        }
                    catch (Exception e)
                        {
                            e.printStackTrace();
                        }
    
                double cursor = 100 * CONSTANT.RND.nextDouble();
                return (cursor >= 0 && cursor <= coef);
            }
    
        public static Object chooseBetween(Object... object)
            {
                ArrayList<Object> values = new ArrayList<>(Arrays.asList(object));
                return values.get(CONSTANT.RND.nextInt(values.size()));
            }
    
        public static double getDistance(Civilization civ1, Civilization civ2)
            {
                return Math.sqrt((civ2.getPosX() - civ1.getPosX()) ^ 2 + (civ2.getPosY() - civ1.getPosY()) ^ 2);
            }
    }