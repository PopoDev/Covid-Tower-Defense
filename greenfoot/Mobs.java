import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Math;

/**
 * Write a description of class Mobs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobs extends SmoothMover
{
    int gridSize = 50;
    
    int health = 0;
    
    GreenfootImage lastImage = new GreenfootImage("straightRoad 50x50.png");
    boolean neverTurned = true;
    
    public void turnAtCorner()
    {
        int angle = getRotation();
        
        if(isTouching(CurvedRoad.class))
        {
            Actor intersect = getOneIntersectingObject(CurvedRoad.class);
            
            if(lastImage.equals(intersect.getImage()))
            {
                neverTurned = false;
            } else {
                neverTurned = true;
            }
            
            double ecartX = Math.abs(getExactX() - intersect.getX());
            double ecartY = Math.abs(getExactY() - intersect.getY());

            if(ecartX <= 2.5 && ecartY <= 2.5)
            {
                int x = 0;
                int y = 0;
                boolean set = false;
                    
                    List<Roads> neighbourRight = getObjectsAtOffset(gridSize, 0, Roads.class);
                    List<Roads> neighbourLeft = getObjectsAtOffset(-gridSize, 0, Roads.class);
                    List<Roads> neighbourUp = getObjectsAtOffset(0, -gridSize, Roads.class);
                    List<Roads> neighbourDown = getObjectsAtOffset(0, gridSize, Roads.class);
                    
                    if(!neighbourRight.isEmpty() && set == false && angle != 180)
                    {
                        x = neighbourRight.get(0).getX();
                        y = neighbourRight.get(0).getY();
                        set = true;
                    }
                    else if(!neighbourLeft.isEmpty() && set == false && angle != 0)
                    {
                        x = neighbourLeft.get(0).getX();
                        y = neighbourLeft.get(0).getY();
                        set = true;
                    }
                    else if(!neighbourUp.isEmpty() && set == false && angle != 90)
                    {
                        x = neighbourUp.get(0).getX();
                        y = neighbourUp.get(0).getY();
                        set = true;
                    }
                    else if(!neighbourDown.isEmpty() && set == false && angle != -90)
                    {
                        x = neighbourDown.get(0).getX();
                        y = neighbourDown.get(0).getY();
                        set = true;
                    }
                    
                    if(neverTurned)
                    {
                        setLocation(intersect.getX(), intersect.getY());
                        turnTowards(x, y);
                        lastImage = intersect.getImage();
                        neverTurned = false;
                    }
            }
        }
    }
    
    public int getHealth()
    {
        return this.health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public boolean isAlive()
    {
        boolean alive;
        if(health <= 0)
        {
            alive = false;
        } else {
            alive = true;
        }
        return alive;
    }
    
    public boolean isAtBorder()
    {
        if(getExactX() > ((Map)getWorld()).mapWidth || getExactY() > ((Map)getWorld()).mapHeight)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public void removeDead()
    {
        if(!isAlive())
        {
            getWorld().removeObject(this);
            // System.out.println(this.getClass() + " is dead.");
        }
    }
}
