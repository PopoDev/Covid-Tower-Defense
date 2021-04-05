import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Zone_1M50 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zone_1M50 extends Towers
{
    int cooldown = 80;
    int wait = cooldown;
    int damage = 1;
    
    public void act() 
    {
        turn(-2);
        attack1M50();
    }
    
    public void attack1M50()
    {
        if(isTouching(Mobs.class))
        {
            if(wait == cooldown)
            {
                List <Mobs> touching = getIntersectingObjects(Mobs.class);
                for(Mobs mob : touching)
                {
                    attack(mob, damage);
                }
                wait = 0;
            }
            wait ++;
        }
    }  
}
