package fr.iut.orsay.pts2;

import java.util.ArrayList;
import java.util.Arrays;

import fr.iut.orsay.pts2.unit.Unit;

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
    
        public static int chooseBetween(int... numbers)
            {
                ArrayList<Integer> values = new ArrayList<>();
                for (int i : numbers)
                    {
                        values.add(i);
                    }
                return values.get(CONSTANT.RND.nextInt(values.size()));
            }
    
        public static Building chooseBetween(Building... building)
            {
                ArrayList<Building> values = new ArrayList<>(Arrays.asList(building));
                return values.get(CONSTANT.RND.nextInt(values.size()));
            }
    
        public static Unit chooseBetween(Unit... unit)
            {
                ArrayList<Unit> values = new ArrayList<>(Arrays.asList(unit));
                return values.get(CONSTANT.RND.nextInt(values.size()));
            }
    
        public static double getDistance(Civilization civ1, Civilization civ2)
            {
                return Math.sqrt((civ2.getPosX() - civ1.getPosX()) ^ 2 + (civ2.getPosY() - civ1.getPosY()) ^ 2);
            }
        public static double getDistance(Unit u1, Unit u2)
        {
            return Math.sqrt((u2.getPosX() - u1.getPosX()) ^ 2 + (u2.getPosY() - u1.getPosY()) ^ 2);
        }
    }
