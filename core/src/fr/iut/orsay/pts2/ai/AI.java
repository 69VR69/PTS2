package fr.iut.orsay.pts2.ai;

import java.util.ArrayList;

import fr.iut.orsay.pts2.Building;
import fr.iut.orsay.pts2.CONSTANT;
import fr.iut.orsay.pts2.Civilization;
import fr.iut.orsay.pts2.Tools;
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
                                    if (Tools.getLuck(CONSTANT.FRIEND_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'G':
                                    if (Tools.getLuck(CONSTANT.GOODFRIEND_ALLIANCE))
                                        {
                                            r.alliance();
                                        }
                                    if (Tools.getLuck(CONSTANT.GOODFRIEND_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'A':
                                    if (Tools.getLuck(CONSTANT.ALLIANCE_COMMONWAR))
                                        {
                                            r.trade();//TODO: add an ennemie
                                        }
                                    if (Tools.getLuck(CONSTANT.ALLIANCE_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'W':
                                    if (Tools.getLuck(CONSTANT.WAR_PEACE))
                                        if (r.trade())
                                            r.setRelationStep('E');
                                    break;
                                case 'E':
                                    if (Tools.getLuck(CONSTANT.ENNEMIE_WAR))
                                        {
                                            r.war();
                                        }
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
