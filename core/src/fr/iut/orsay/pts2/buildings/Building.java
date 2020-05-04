package fr.iut.orsay.pts2.buildings;

public class Building
    {
        int stock;
        String name;
    
        public int getStock()
            {
                return stock;
            }
    
        public void setStock(int stock)
            {
                this.stock = stock;
            }
    
        public void upgrade()
            {
                System.out.println(this.getName() + " is upgrade");
            }
    
        public String getName()
            {
                return name;
            }
    
        public void setName(String name)
            {
                this.name = name;
            }
    }
