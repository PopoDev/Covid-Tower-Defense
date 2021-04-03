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
    
    public void turnAtCorner()
    {
        int angle = getRotation();
        
        if(isTouching(CurvedRoad.class))
        {
            int angleRoad = getOneIntersectingObject(CurvedRoad.class).getRotation();
            Actor intersect = getOneIntersectingObject(CurvedRoad.class);
            
            //int roundedX = (int) Math.round(getExactX());
            //int roundedY = (int) Math.round(getExactY());
            //System.out.println("Virus : " + roundedX + ", " + roundedY + 
            //" |  Corner : " + intersect.getX() + ", " + intersect.getY());
            
            int posX = Math.floorDiv(getX(), 5) * 5 - getX() % 5;
            int posY = Math.floorDiv(getY(), 5) * 5 - getY() % 5;
            
            System.out.println("Virus : " + posX + ", " + posY + 
            " |  Corner : " + intersect.getX() + ", " + intersect.getY());
            
            if(Math.abs(getExactX() - intersect.getX()) == 0.5 && getExactX() - intersect.getX() != 0) 
            {
                posX = intersect.getX();
            }
            if(Math.abs(getExactY() - intersect.getY()) == 0.5 && getExactY() - intersect.getY() != 0) 
            {
                posY = intersect.getY();
            }
            
            if(posX == intersect.getX() && posY == intersect.getY())
            {
                if(!getObjectsInRange(gridSize, StraightRoad.class).isEmpty())
                {
                    int x = 0;
                    int y = 0;
                    boolean set = false;
                    
                    List<StraightRoad> neighbourRight = getObjectsAtOffset(gridSize, 0, StraightRoad.class);
                    List<StraightRoad> neighbourLeft = getObjectsAtOffset(-gridSize, 0, StraightRoad.class);
                    List<StraightRoad> neighbourUp = getObjectsAtOffset(0, -gridSize, StraightRoad.class);
                    List<StraightRoad> neighbourDown = getObjectsAtOffset(0, gridSize, StraightRoad.class);
                    
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
                    
                    setLocation(intersect.getX(), intersect.getY());
                    turnTowards(x, y);
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
    
    public void removeDead()
    {
        if(!isAlive())
        {
            getWorld().removeObject(this);
            System.out.println(this.getClass() + " is dead.");
        }
    }
}
