package fr.iut.orsay.pts2.ai;

import java.util.ArrayList;
import java.util.Arrays;

import fr.iut.orsay.pts2.Building;
import fr.iut.orsay.pts2.CONSTANT;
import fr.iut.orsay.pts2.Civilization;
import fr.iut.orsay.pts2.Tools;
import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Boat;
import fr.iut.orsay.pts2.unit.Soldier;
import fr.iut.orsay.pts2.unit.Unit;

public class AI extends Civilization
    {
        public AI(String name, String description, Unit unit, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                super(name, description, unit, buildings, relationships);
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
        
        private void Buildings()
            {
                needRessource().upgrade();
            }
        
        private void Units()
            {
    
            }
    
        private void Technology()
            {
                System.out.println("technology");
            }
    
        private Building needRessource()//TODO: change stock by rate + add this.getBuildings().getRessourceDistrict.get(0)
        {
            Building temp = this.getBuildings().get(0);
            for (Building b : this.getBuildings())
                {
                    if (b.getStock() == temp.getStock())
                        temp = Tools.chooseBetween(b, temp);
                    else if (b.getStock() < temp.getStock())
                        temp = b;
                }
            return temp;
        }
        
        /*private Unit mostTroops()
            {
                return new Unit("j");
            }*/
    
        private void createUnit()
            {
                Unit[] units = {new Boat("Boat"), new Soldier("Soldier"), new Soldier("Soldier")};
                ArrayList<Unit> listOfUnits = new ArrayList<>(Arrays.asList(units));
            
                //TODO: aléat avec limit différence de X
                Unit newUnit = Tools.chooseBetween(listOfUnits.toArray(new Unit[0]));
                /*if (newUnit.getName() == "mostTroops().getName()") //TODO: implement mostTroops
                    true;
                if(this.getRelationships())*/
                //IN war
                //TODO: opti ennemi
                //aléat ennemi
                //TODO: % que opti ennemie = return sinon aléat entre others
            }
    
        private void moveUnit()
            {
            
            }
    }
