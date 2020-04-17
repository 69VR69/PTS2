package fr.iut.orsay.pts2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Unit;

public abstract class Civilization
    {
        private final String name, description;
        private ArrayList<Building> buildings;
        private ArrayList<Relationship> relationships;
        private ArrayList<Unit> unitList;
        private SortedMap<String, Integer> unitQuantity;
        private int posX, posY;
    
        public Civilization(String name, String description, Unit unit, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                this.name = name;
                this.description = description;
                this.buildings = buildings;
                this.relationships = relationships;
                this.unitQuantity = new TreeMap<>();
                this.unitList = new ArrayList<>();
                this.addUnit(unit);
            }
        
        public void addUnit(Unit... unit)
            {
                for (Unit u : unit)
                    {
                        if (this.getUnitQuantity().containsKey(u.getName()))
                            {
                                this.getUnitQuantity().replace(u.getName(), this.getUnitQuantity().get(u.getName()) + 1);
                                this.getUnitList().add(u);
                            }
                        else
                            {
                                this.getUnitQuantity().put(u.getName(), 1);
                                this.getUnitList().add(u);
                            }
                    }
                Collections.sort(this.getUnitList());
                SortedSet<Integer> values = new TreeSet<>(this.getUnitQuantity().values());
            }
        
        public void addBuilding(Building... building)
            {
                for (Building b : building)
                    this.getBuildings().add(b);
            }
        
        public void addRelationship(Relationship... relationship)
            {
                for (Relationship r : relationship)
                    this.getRelationships().add(r);
            }
    
        public boolean isWar()
            {
                boolean result = false;
                for (Relationship r : this.getRelationships())
                    {
                        if (r.getRelationStep() == 'W')
                            result = true;
                    }
                return result;
            }
    
        public ArrayList<Civilization> listCiv()
            {
                ArrayList<Civilization> civList = new ArrayList<>();
                for (Relationship r : this.getRelationships())
                    {
                        if (this.getName().equals(r.getCiv1().getName()))
                            civList.add(r.getCiv2());
                        else
                            civList.add(r.getCiv1());
                    }
                return civList;
            }
    
        public Unit mostTroop()
            {
                Unit result = null;
                for (Unit u : this.getUnitList())
                    {
                        if (u.getName().equals(this.getUnitQuantity().firstKey()))
                            {
                                result = u;
                                break;
                            }
                    }
                return result;
            }
        
        public String getName()
            {
                return name;
            }
        
        public String getDescription()
            {
                return description;
            }
    
        public ArrayList<Unit> getUnitList()
            {
                return unitList;
            }
    
        public void setUnitList(ArrayList<Unit> unitList)
            {
                this.unitList = unitList;
            }
    
        public SortedMap<String, Integer> getUnitQuantity()
            {
                return unitQuantity;
            }
    
        public void setUnitQuantity(SortedMap<String, Integer> unitQuantity)
            {
                this.unitQuantity = unitQuantity;
            }
        
        public ArrayList<Building> getBuildings()
            {
                return buildings;
            }
        
        public void setBuildings(ArrayList<Building> buildings)
            {
                this.buildings = buildings;
            }
        
        public ArrayList<Relationship> getRelationships()
            {
                return relationships;
            }
        
        public void setRelationships(ArrayList<Relationship> relationships)
            {
                this.relationships = relationships;
            }
    
        public int getPosX()
            {
                return posX;
            }
    
        public void setPosX(int posX)
            {
                this.posX = posX;
            }
    
        public int getPosY()
            {
                return posY;
            }
    
        public void setPosY(int posY)
            {
                this.posY = posY;
            }
    }
