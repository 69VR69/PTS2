package fr.iut.orsay.pts2.config;

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
                
                double cursor = 100 * MAP_CONFIG.RND.nextDouble();
                return (cursor >= 0 && cursor <= coef);
            }
    }