package fr.iut.orsay.pts2;

import java.util.ArrayList;

import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Unit;

public class Civilization
    {
        private final String name, description;
        private ArrayList<Unit> troops;
        private ArrayList<Building> buildings;
        private ArrayList<Relationship> relationships;
        
        public Civilization(String name, String description, ArrayList<Unit> troops, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                this.name = name;
                this.description = description;
                this.troops = troops;
                this.buildings = buildings;
                this.relationships = relationships;
            }
        
        public void addUnit(Unit... unit)
            {
                for (Unit u : unit)
                    this.getTroops().add(u);
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
        
        
        public String getName()
            {
                return name;
            }
        
        public String getDescription()
            {
                return description;
            }

        public ArrayList<Unit> getTroops()
            {
                return troops;
            }
        
        public void setTroops(ArrayList<Unit> troops)
            {
                this.troops = troops;
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
    }
