import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Math;

/**
 * Write a description of class Zone_1M50 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zone1M50 extends TowersProjectile
{
    private int damage;
    private int range;
    private int cooldown;
    
    private int basicSize = 40;
    private int size;
    
    int counter = 0;
    int interval;
    int coefficient = 10; // Pour que les arrondis ne soient pas trop significatifs
    
    int pause = 20;
    int wait = 0;
    
    GreenfootImage zone1M50 = new GreenfootImage("1M50 Zone 500x500.png");
    
    public void act() 
    {
        if(size <= range)
        {
            if(counter > interval)
            {
                size++;
                zone1M50 = new GreenfootImage("1M50 Zone 500x500.png");
                zone1M50.scale(size, size);
                setImage(zone1M50);
                counter = 0;
            }
            counter += coefficient;
        } else {
            size = basicSize;
        }
        attack1M50();
    }
    
    public void attack1M50()
    {
        if(isTouching(Mobs.class))
        {
            if(wait == pause) // Sinon attaque à chaque tour d'act
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
    
    public void setStats(int damage, int range, int cooldown)
    {
        this.damage = damage;
        this.range = range;
        this.cooldown = cooldown;
        
        this.size = basicSize;
        this.interval = Math.round((cooldown/range)*coefficient);
    }
}
