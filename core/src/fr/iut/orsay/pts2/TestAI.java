package fr.iut.orsay.pts2;

import fr.iut.orsay.pts2.ai.AI;

public class TestAI
    {
        public static void main(String[] args)
            {
                AI ai = new AI();
                System.out.println("Result: " + ai.Action());
            }
    }
