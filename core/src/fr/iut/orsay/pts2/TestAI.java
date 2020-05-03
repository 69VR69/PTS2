package fr.iut.orsay.pts2;

import fr.iut.orsay.pts2.Houses.WoodHouse;
import fr.iut.orsay.pts2.Houses.OreHouse;


public class TestAI
    {
        public static void main(String[] args)
            {

                OreHouse o=new OreHouse();
                WoodHouse w=new WoodHouse();
                o.produce();
                System.out.println(w.getRm().toString());
            }
    }
