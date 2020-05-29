package fr.iut.orsay.pts2.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.config.CONSTANT;
import fr.iut.orsay.pts2.config.Tools;
import fr.iut.orsay.pts2.interfaces.Fighteable;
import fr.iut.orsay.pts2.interfaces.Moveable;
import fr.iut.orsay.pts2.interfaces.Upgradable;

public abstract class Unit implements Fighteable, Moveable, Upgradable, Comparable<Unit>
    {
        private String name;
        private float posX = 0, posY = 0;
        private float xDestination = 0, yDestination = 0;
        private int range = 1;
        private FileHandle texturePath = Gdx.files.internal("data/sheitan-valorant.png");
        private boolean onBoard = true;
        private boolean isMoving = false;
        private SpriteBatch batchUnit;
        
        public Unit(String name, float posX, float posY)
            {
                
                this.name = name;
                this.posX = posX;
                this.posY = posY;
            }
        
        public Texture texturize()
            {
                return new Texture(texturePath);
            }
        
        public void draw()
            {
                float resizeRatio = 0.9f;
                final Texture texture = Tools.resize(this.texturize(), (int) (CONSTANT.textureWidth * resizeRatio), (int) (CONSTANT.textureHeight * resizeRatio));
                final int deltaWidth = (int) (CONSTANT.textureWidth - CONSTANT.textureWidth * resizeRatio) / 2;
                final int deltaHeight = (int) (CONSTANT.textureHeight - CONSTANT.textureHeight * resizeRatio) / 2;
                batchUnit.draw(texture, (this.getPosX() * CONSTANT.textureWidth + deltaWidth), (this.getPosY() * CONSTANT.textureHeight + deltaHeight));
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
        
        public void move()
            {
                batchUnit.begin();
                if (xDestination > this.getPosX())
                    this.setPosX(this.getPosX() + 1);
                else if (xDestination < this.getPosX())
                    this.setPosX(this.getPosX() - 1);
                if (yDestination > this.getPosY())
                    this.setPosY(this.getPosY() + 1);
                else if (yDestination < this.getPosY())
                    this.setPosY(this.getPosY() - 1);
                this.draw();
                batchUnit.end();
            }
        
        @Override public boolean move(float xDestination, float yDestination)
            {
                setMoving(true);
                batchUnit.begin();
                if (xDestination > this.getPosX())
                    this.setPosX(this.getPosX() + 1);
                else if (xDestination < this.getPosX())
                    this.setPosX(this.getPosX() - 1);
                if (yDestination > this.getPosY())
                    this.setPosY(this.getPosY() + 1);
                else if (yDestination < this.getPosY())
                    this.setPosY(this.getPosY() - 1);
                this.draw();
                if (xDestination == this.getPosX() && yDestination == this.getPosY())
                    setMoving(false);
                batchUnit.end();
                return true;
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
        
        public SpriteBatch getBatchUnit()
            {
                return batchUnit;
            }
        
        public void setBatchUnit(SpriteBatch batchUnit)
            {
                this.batchUnit = batchUnit;
            }
        
        public float getxDestination()
            {
                return xDestination;
            }
        
        public void setxDestination(float xDestination)
            {
                this.xDestination = xDestination;
            }
        
        public float getyDestination()
            {
                return yDestination;
            }
        
        public void setyDestination(float yDestination)
            {
                this.yDestination = yDestination;
            }
    }
