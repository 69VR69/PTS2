package fr.iut.orsay.pts2.relationship;

import java.util.ArrayList;

import fr.iut.orsay.pts2.Civilization;
import fr.iut.orsay.pts2.Ressource;

public class Relationship
    {
        private Civilization civ1,civ2;
        private int relationLevel;
        private char relationStep;
        
        public Relationship(Civilization civ1, Civilization civ2, int relationLevel)
            {
                this.civ1 = civ1;
                this.civ2 = civ2;
                this.relationLevel = relationLevel;
                calculStep();
            }
        
        public void calculStep() //TODO: add in update method
            {
                if (this.getRelationLevel() < 20)
                    this.setRelationStep('E');
                else if (this.getRelationLevel() < 40)
                    this.setRelationStep('R');
                else if (this.getRelationLevel() < 60)
                    this.setRelationStep('N');
                else if (this.getRelationLevel() < 80)
                    this.setRelationStep('F');
                else if (this.getRelationLevel() < 100)
                    this.setRelationStep('G');
            }
        
        public boolean trade(ArrayList<Ressource> offer, ArrayList<Ressource> demand) //ressources
            {
                boolean result = false;
                
                if(offer == demand) //TODO: create accept conditions
                    {
                        System.out.println("This trade is accepted");
                        result = true;
                    }
                
                return result;
            }
        
        public boolean trade() //truce
            {
                boolean result = false;
                
                if(this.getRelationStep() == 'W') //TODO: create accept conditions (&& military power of foreign ... + troops position...)
                    {
                        System.out.println("This truce demand is accepted");
                        result = true;
                    }
                
                return result;
            }
        
        
        public boolean trade(Civilization foreignCiv) //commom war
            {
                boolean result = false;
                
                if(this.getCiv1() != foreignCiv && this.getCiv2() != foreignCiv) //TODO: create accept conditions (&& military power of foreign ... + troops position...)
                    {
                        System.out.println("This common war demand is accepted");
                        result = true;
                    }
                
                return result;
            }
        
        public void war() //TODO: active with button
            {
                if (this.getRelationStep() == 'E')
                    {
                        this.setRelationStep('W');
                    }
                else
                    System.out.println(this.getCiv1().getName() + " cannot be in war with " + this.getCiv2().getName());
            }
        
        public void alliance() //TODO: active with button
            {
                if (this.getRelationStep() == 'G')
                    {
                        this.setRelationStep('A');
                    }
                else
                    System.out.println(this.getCiv1().getName() + " cannot be in alliance with " + this.getCiv2().getName());
            }
    
        public Civilization getCiv1()
            {
                return civ1;
            }
    
        public void setCiv1(Civilization civ1)
            {
                this.civ1 = civ1;
            }
    
        public Civilization getCiv2()
            {
                return civ2;
            }
    
        public void setCiv2(Civilization civ2)
            {
                this.civ2 = civ2;
            }
    
        public int getRelationLevel()
            {
                return relationLevel;
            }
        
        public void setRelationLevel(int relationLevel)
            {
                this.relationLevel = relationLevel;
            }
        
        public char getRelationStep()
            {
                return relationStep;
            }
        
        public void setRelationStep(char relationStep)
            {
                this.relationStep = relationStep;
            }
    }
