package fr.iut.orsay.pts2;

import java.util.ArrayList;

import fr.iut.orsay.pts2.buildings.Building;
import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Unit;

public class Player extends Civilization
    {
        public Player(String name, String description, ArrayList<Unit> unit, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                super(name, description, unit, buildings, relationships);
            }
    }
