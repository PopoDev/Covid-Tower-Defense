import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Mobs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobs extends Actor
{
int gridSize = 50;
    
    public void turnAtCorner()
    {
        int angle = getRotation();
        if(isTouching(CurvedRoad.class))
        {
            int angleRoad = getOneIntersectingObject(CurvedRoad.class).getRotation();
            
            if(getX() == getOneIntersectingObject(CurvedRoad.class).getX() &&
            getY() == getOneIntersectingObject(CurvedRoad.class).getY())
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
                    
                    turnTowards(x, y);
                }
            }
        }
    }  
}
