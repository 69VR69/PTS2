package fr.iut.orsay.pts2;

import java.util.Random;

public abstract class Tools
    {
        public static boolean getLuck(double coef)
            {
                boolean result = false;
                if (coef < 0 || coef > 100)
                    try
                        {
                            throw new Exception("coef is out of bounds");
                        }
                    catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                Random rnd = new Random();
                double cursor = 100 * rnd.nextDouble();
                result = (cursor >= 0 && cursor <= coef);
                return result;
            }
    }
