package fr.iut.orsay.pts2.unit;

public abstract class Unit
    {
        private String name;
        protected int nbUnit = 0;
    
        Unit(String name)
            {
                this.name = name;
            }
    
        public String getName()
            {
                return name;
            }
    
        public void setName(String name)
            {
                this.name = name;
            }
    
        public int getNbUnit()
            {
                return nbUnit;
            }
    
        public void setNbUnit(int nbUnit)
            {
                this.nbUnit = nbUnit;
            }
    }
