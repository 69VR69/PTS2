package fr.iut.orsay.pts2;

import java.util.ArrayList;
import java.util.Map;

import fr.iut.orsay.pts2.ai.AI;
import fr.iut.orsay.pts2.relationship.Relationship;
import fr.iut.orsay.pts2.unit.Boat;
import fr.iut.orsay.pts2.unit.Soldier;
import fr.iut.orsay.pts2.unit.Unit;

public class TestAI
    {
        public static void main(String[] args)
            {
                AI ai = new AI("russian", "empire", new Boat("boat1"), new ArrayList<Building>(), new ArrayList<Relationship>());
                ai.addUnit(new Boat("boat2"));
                ai.addUnit(new Soldier("soldier1"));
                ai.addUnit(new Soldier("soldier2"));
                System.out.println("HERE:");
                for (Map.Entry<Integer, Unit> entry : ai.getUnits().entrySet())
                    {
                        System.out.println(entry.getKey() + ":" + entry.getValue().getName());
                    }
            }
    }
