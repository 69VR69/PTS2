package fr.iut.orsay.pts2.unit;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.iut.orsay.pts2.interfaces.Fighteable;
import fr.iut.orsay.pts2.interfaces.Moveable;
import fr.iut.orsay.pts2.interfaces.Upgradable;

public abstract class Unit implements Fighteable, Moveable, Upgradable
    {
        private FileHandle texturePath= Gdx.files.internal("badlogic.jpg");

        public void draw(SpriteBatch batchUnit){
            batchUnit.begin();
            batchUnit.draw(new Texture(texturePath), posX, posY);
            batchUnit.end();
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
        
        @Override public boolean move(int x, int y)
            {
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
}
