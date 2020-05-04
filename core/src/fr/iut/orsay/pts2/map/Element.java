package fr.iut.orsay.pts2.map;

public class Element implements Cloneable
    {
        private ElementType elementType;
        private int locationW;
        private int locationH;
        
        public Element(ElementType elementType)
            {
                this.elementType = elementType;
            }
        
        public Element clone()
            {
                Element e = null;
                try
                    {
                        e = ((Element) super.clone());
                    }
                catch (CloneNotSupportedException cnse)
                    {
                        cnse.printStackTrace(System.err);
                    }
                return e;
            }
    
        public ElementType getElementType()
            {
                return elementType;
            }
        
        int getLocationW()
            {
                return locationW;
            }
        
        int getLocationH()
            {
                return locationH;
            }
        
        void setLocation(int elementWidth, int elementHeight)
            {
                this.locationW = elementWidth;
                this.locationH = elementHeight;
            }
    }
