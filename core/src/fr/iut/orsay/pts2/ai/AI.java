package fr.iut.orsay.pts2.ai;

import java.util.ArrayList;

import fr.iut.orsay.pts2.Building;
import fr.iut.orsay.pts2.Civilization;
import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Unit;

public class AI extends Civilization
    {
        public AI(String name, String description, ArrayList<Unit> troops, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                super(name, description, troops, buildings, relationships);
            }
        
        public boolean Action()
            {
                boolean result = false;
                
                try
                    {
                        Diplomacy();
                        Technology();
                        Buildings();
                        Units();
                        result = true;
                    }
                catch (Exception e) //TODO: specify exception type
                    {
                        System.out.println("Error: " + e.getCause());
                    }
                
                
                return result;
            }
        
        private void Diplomacy()
            {
                for (Relationship r : this.getRelationships())
                    {
                            switch (r.getRelationStep())
                                {
                                    case 'F':
                                        //ressources
                                        break;
                                    case 'G':
                                        //alliance, ressources
                                        break;
                                    case 'A':
                                        //join in war, ressources
                                        break;
                                    case 'W':
                                        if()
                                        break;
                                    case 'E':
                                        //war
                                        break;
                                    case 'R':
                                        break;
                                    default:
                                        break;
                                }
                        
                    }
            }
        
        private void Technology()
            {
                System.out.println("technology");
            }
        
        private void Buildings()
            {
                System.out.println("buildings");
            }
        
        private void Units()
            {
                System.out.println("units");
            }
        
    }
