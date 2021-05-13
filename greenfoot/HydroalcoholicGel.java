import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class HydroalcoholicGel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HydroalcoholicGel extends Towers
{
    int cooldown = 30;
    int wait = cooldown;
    int damage = 1;
    
    public void act() 
    {
        attackGel();
    }
    
    public void attackGel()
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
