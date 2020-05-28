package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.util.Arrays;

import fr.iut.orsay.pts2.interfaces.Fighteable;
import fr.iut.orsay.pts2.interfaces.Moveable;
import fr.iut.orsay.pts2.interfaces.Upgradable;

public abstract class Unit implements Fighteable, Moveable, Upgradable, Comparable<Unit>
    {
        private String name;
        private float posX = 0, posY = 0;
        private int range = 1;
        private FileHandle texturePath = Gdx.files.internal("data/sheitan-valorant.png");
        private boolean onBoard = true;
        private boolean isMoving = false;
    
        public Unit(String name, float posX, float posY)
            {
    
                this.name = name;
                this.posX = posX;
                this.posY = posY;
                //System.out.println("ok");
    
                move(5, 5);
                
            }
    
        public Texture texturize()
            {
                return new Texture(texturePath);
            }
        
        @Override public boolean canAttack()
            {
                return false;
            }
        
        @Override public void attack(Object o)
            {
    
            }
        
        @Override public int calculDamage(int damage, Object o)
            {
                return 0;
            }
        
        @Override public void upModification(int upValue, Object o)
            {
    
            }
        
        @Override public void downModification(int downValue, Object o)
            {
            
            }
    
        @Override public boolean move(float xDestination, float yDestination) {
            setMoving(true);
            float speed = 15;
            System.out.println(this.getPosX() + "" + this.getPosY());
            while (xDestination !=this.getPosX()&&yDestination!=this.getPosY()) {
                try {
                    if (xDestination > this.getPosX())
                        this.setPosX(this.getPosX() +  Gdx.graphics.getDeltaTime() * speed);
                    else if (xDestination < this.getPosX())
                        this.setPosX(this.getPosX()- Gdx.graphics.getDeltaTime() * speed);
                    if (Math.abs(xDestination - getPosY()) < Gdx.graphics.getDeltaTime() * speed) {
                        if (yDestination > this.getPosY())
                            this.setPosY(this.getPosY() +  Gdx.graphics.getDeltaTime() * speed);
                        else if (yDestination < this.getPosY())
                            this.setPosY(this.getPosY() - Gdx.graphics.getDeltaTime() * speed);
                        setMoving(false);
                        return true;
                    }
                } catch (Exception e) {
                    System.err.println("Error:" + Arrays.toString(e.getStackTrace()));
                    return false;
                }
            }
            return false;
        }


    
        @Override public void addForbiddenZone(Object... o)
            {
            
            }
        
        @Override public void removeForbiddenZone(Object... o)
            {
    
            }
        
        @Override public boolean addToBoard(int posX, int posY, int weight, float depressionRate)
            {
                return false;
            }
        
        @Override public boolean changePosition(int posX, int posY)
            {
                return false;
            }
        
        @Override public boolean swapPosition(Object o1, Object o2)
            {
                return false;
            }
        
        @Override public boolean removeFromBoard()
            {
                this.onBoard = false;
                return false;
            }
        
        @Override public void upDepressionRate(float upRate)
            {
    
            }
        
        @Override public void downDepressionRate(float downRate)
            {
    
            }
        
        @Override public void upWeight(int upValue)
            {
    
            }
        
        @Override public void downWeight(int downValue)
            {
    
            }
        
        @Override public void upLevel(int nbLevel)
            {
    
            }
        
        @Override public void downLevel(int nbLevel)
            {
    
            }
        
        @Override public void addExperiencePoint(int point)
            {
    
            }
        
        @Override public void removeExperiencePoint(int point)
            {
    
            }
    
    
        public int compareTo(Unit o)
            {
                return this.getName().compareTo(o.getName());
            }
    
        @Override public float getPosX()
            {
                return posX;
            }
    
        @Override public void setPosX(float x)
            {
                posX = x;
            }
    
        @Override public float getPosY()
            {
                return posY;
            }
    
        @Override public void setPosY(float y)
            {
                posY = y;
            }
    
        @Override public boolean isOnBoard()
            {
                return onBoard;
            }
    
        @Override public void setOnBoard(boolean board)
            {
                onBoard = board;
            }
    
        public String getName()
            {
                return name;
            }
    
        public void setName(String name)
            {
                this.name = name;
            }
    
        public boolean isMoving()
            {
                return isMoving;
            }
    
        public void setMoving(boolean moving)
            {
                isMoving = moving;
            }
    
        public int getRange()
            {
                return range;
            }
    }
