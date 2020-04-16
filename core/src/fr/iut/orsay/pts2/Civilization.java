package fr.iut.orsay.pts2;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Unit;

public abstract class Civilization
    {
        private final String name, description;
        private ArrayList<Building> buildings;
        private ArrayList<Relationship> relationships;
        SortedMap<Integer, Unit> units;
        private int posX, posY;
        private static int test = 0;
    
        public Civilization(String name, String description, Unit unit, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                this.name = name;
                this.description = description;
                this.buildings = buildings;
                this.relationships = relationships;
                this.units = new TreeMap<>();
                this.addUnit(unit);
            }
        
        public void addUnit(Unit... unit)
            {
                for (Unit u : unit)
                    {
                        test++;
                        this.getUnits().put(u.getNbUnit() + 1, u);
                    }
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
        
        
        public String getName()
            {
                return name;
            }
        
        public String getDescription()
            {
                return description;
            }
    
        public SortedMap<Integer, Unit> getUnits()
            {
                return units;
            }
    
        public void setUnits(SortedMap<Integer, Unit> units)
            {
                this.units = units;
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
