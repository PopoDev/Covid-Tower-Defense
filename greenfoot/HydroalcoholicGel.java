import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class HydroalcoholicGel here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class HydroalcoholicGel extends TowersProjectile
{
    private int cooldown = 30; // Temps entre les attaques
    private int wait = cooldown;
    private int damage;
    
    private int delay = 1000; // Temps du gel sur la map
    private int counter = 0;
    
    GreenfootImage lvl1 = new GreenfootImage("Gel Hydroalcolique 1 (50x50).png");
    GreenfootImage lvl2 = new GreenfootImage("Gel Hydroalcolique 2 (50x50).png");
    GreenfootImage lvl3 = new GreenfootImage("Gel Hydroalcolique 3 (50x50).png");
    GreenfootImage lvl4 = new GreenfootImage("Gel Hydroalcolique 4 (50x50).png");
    GreenfootImage lvl5 = new GreenfootImage("Gel Hydroalcolique 5 (50x50).png");
    
    @Override
    protected void addedToWorld(World world)
    {
        switch(damage)
        {
            case 1:
                setImage(lvl1);
                break;
            case 2:
                setImage(lvl2);
                break;
            case 3:
                setImage(lvl3);
                break;
            case 4:
                setImage(lvl4);
                break;
            case 5:
                setImage(lvl5);
                break;
            default:
                break;
        }
    }
    
    public void act() 
    {
        attackGel();
        if(counter >= delay)
        {
            getWorld().removeObject(this);
        }
        removeIfTowerSold();
        counter++;
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
    
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
