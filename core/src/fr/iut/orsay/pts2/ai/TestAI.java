package fr.iut.orsay.pts2.ai;

import java.util.ArrayList;
import java.util.Map;

import fr.iut.orsay.pts2.buildings.Building;
import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Boat;
import fr.iut.orsay.pts2.unit.Soldier;

public class TestAI
    {
        public static void main(String[] args)
            {
                AI ai = new AI("russian", "empire", new Boat("boat"), new ArrayList<Building>(), new ArrayList<Relationship>());
                ai.addUnit(new Boat("boat"));
                ai.addUnit(new Soldier("soldier"));
                ai.addUnit(new Soldier("soldier"));
                ai.addUnit(new Soldier("soldier"));
                System.out.println("\nHERE:");
                for (Map.Entry<String, Integer> entry : ai.getUnitQuantity().entrySet())
                    {
                        System.out.println(entry.getKey() + ':' + entry.getValue());
                    }
    
            }
    }
