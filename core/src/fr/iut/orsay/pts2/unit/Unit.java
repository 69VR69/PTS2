package fr.iut.orsay.pts2.unit;

public abstract class Unit implements Comparable<Unit>
    {
        private String name;
        private int movementPoint;
        
        Unit(String name)
            {
                this.name = name;
            }
    
        public void move(int x, int y)
            {
                //TODO: complete
            }
    
        public boolean moveOn(String owner)
            {
                //TODO: complete : move on territory owner if possible
                return false;
            }
    
        public boolean nextBorder(String owner)
            {
                boolean result = false;
                //TODO: complete
    /*
                switch (nextPos)
                    {
                        case 1:
                            uTest.move(0,1);
                            break;
                        case 2:
                            uTest.move(1,1);
                            break;
                        case 3:
                            uTest.move(1,0);
                            break;
                        case 4:
                            uTest.move(1,-1);
                            break;
                        case 5:
                            uTest.move(0,-1);
                            break;
                        case 6:
                            uTest.move(-1,-1);
                            break;
                        case 7:
                            uTest.move(-1,0);
                            break;
                        case 8:
                            uTest.move(-1,1);
                            break;
                        default:
                            System.out.println("Error nextPos invalid number");
                            break;
                */
                return result;
            }
    
        public int compareTo(Unit o)
            {
                return this.getName().compareTo(o.getName());
            }
        
        public String getName()
            {
                return name;
            }
    
        public void setName(String name)
            {
                this.name = name;
            }
    
        public int getMovementPoint()
            {
                return movementPoint;
            }
    
        public void setMovementPoint(int movementPoint)
            {
                this.movementPoint = movementPoint;
            }
    
    }
