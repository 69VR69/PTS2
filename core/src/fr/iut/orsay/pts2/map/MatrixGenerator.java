package fr.iut.orsay.pts2.map;

//import fr.iut.orsay.pts2.InputProcessor;
import fr.iut.orsay.pts2.config.MAP_CONFIG;

class MatrixGenerator implements Cloneable
    {
        private int width = MAP_CONFIG.WIDTH;
        private int height = MAP_CONFIG.HEIGHT;
        private Element[][] mapContent;
        private int totalAdded = 0;
      //  private InputProcessor ip;
    
        MatrixGenerator()
            {
                this.totalAdded = getHeight() * getWidth();
                this.mapContent = new Element[this.width][this.height];
                this.RandomSeed();
                //this.printMatrix();
                //this.getPosition();

            }
        private void RandomSeed()
            {
                for (int h = 0; h < this.getHeight(); h++)
                    for (int w = 0; w < this.getWidth(); w++)
                        if (this.mapContent[w][h] == null)
                            {
                                this.setElementAtThisPosition(w, h, MAP_CONFIG.RandomElement().clone());
                                extendSeed(mapContent[w][h].clone());
                            }
                for (int i = 0; i < MAP_CONFIG.TOLERANCE; i++)
                    this.cleanMap();
            }
        
        
        private void extendSeed(Element element)
            {
                if (comparationElementPercent(element))
                    switch (MAP_CONFIG.RND.nextInt(4))
                        {
                            case 0:
                                if (element.getLocationW() > 0 && mapContent[element.getLocationW() - 1][element.getLocationH()] == null)
                                    this.setElementAtThisPosition(element.getLocationW() - 1, element.getLocationH(), element.clone());
                                break;
                            case 1:
                                if (element.getLocationW() < getWidth() - 1 && mapContent[element.getLocationW() + 1][element.getLocationH()] == null)
                                    this.setElementAtThisPosition(element.getLocationW() + 1, element.getLocationH(), element.clone());
                                break;
                            case 2:
                                if (element.getLocationH() > 0 && mapContent[element.getLocationW()][element.getLocationH() - 1] == null)
                                    this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() - 1, element.clone());
                                break;
                            case 3:
                                if (element.getLocationH() < getHeight() - 1 && mapContent[element.getLocationW()][element.getLocationH() + 1] == null)
                                    this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() + 1, element.clone());
                                break;
                        }
            }
        
        private void cleanMap()
            {
                for (Element[] elements : mapContent)
                    for (Element element : elements)
                        this.matchElementWithEnvironnement(element.clone());
            }
        
        private void matchElementWithEnvironnement(Element element)
            {
                boolean added = false;
                while (!added)
                    switch (MAP_CONFIG.RND.nextInt(4))
                        {
                            case 0:
                                if (element.getLocationW() > 0)
                                    {
                                        Element newElement = this.mapContent[element.getLocationW() - 1][element.getLocationH()].clone();
                                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement);
                                        added = true;
                                    }
                                break;
                            case 1:
                                if (element.getLocationH() < getHeight() - 1)
                                    {
                                        Element newElement = this.mapContent[element.getLocationW()][element.getLocationH() + 1].clone();
                                        setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement);
                                        added = true;
                                    }
                                break;
                            case 2:
                                if (element.getLocationW() < this.getWidth() - 1)
                                    {
                                        Element newElement = this.mapContent[element.getLocationW() + 1][element.getLocationH()].clone();
                                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement);
                                        added = true;
                                    }
                                break;
                            case 3:
                                if (element.getLocationH() > 0)
                                    {
                                        Element newElement = this.mapContent[element.getLocationW()][element.getLocationH() - 1].clone();
                                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement);
                                        added = true;
                                    }
                                break;
                        }
            }
        
        private boolean comparationElementPercent(Element element)
            {
                float allElement = 0;
                for (Element[] elements : mapContent)
                    for (Element value : elements)
                        if (value != null)
                            if (value.getElementType().getType() == element.getElementType().getType())
                                allElement++;
                
                float totalPercent = (float) ((element.getElementType().getPercent() / 100) * totalAdded) / 100;
                return (allElement / 100) <= totalPercent;
            }
        
        Element[][] getMapContent()
            {
                return mapContent;
            }
        
        int getTotalAdded()
            {
                return totalAdded;
            }
    
        public int getWidth()
            {
                return this.width;
            }
    
        public int getHeight()
            {
                return this.height;
            }
        
        private void printMatrix()
            {
                for (int h = 0; h < this.getHeight(); h++)
                    {
                        for (int w = 0; w < this.getWidth(); w++)
                            if (this.mapContent[w][h] == null)
                                System.out.print(" " + " ");
                            else
                                System.out.print(this.mapContent[w][h].getElementType().getType() + " ");
                        
                        System.out.println();
                    }
            }
        
        private void getPosition()
            {
                for (Element[] elements : mapContent)
                    for (Element element : elements)
                        System.out.println(element.getLocationW() + " : " + element.getLocationH());
            }
        
        private void setElementAtThisPosition(int elementWidth, int elementHeight, Element element)
            {
                this.mapContent[elementWidth][elementHeight] = element;
                element.setLocation(elementWidth, elementHeight);
                
            }
    }