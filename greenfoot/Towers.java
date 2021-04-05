import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends SmoothMover
{
    int range = 100;
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        System.out.println(currentHealth);
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
    }
    
    public void showRange()
    {
        if(Greenfoot.mouseClicked(this))
        {
            System.out.println("Clicked on : " + this);
            Range rangeObj = new Range();
            rangeObj.getImage().scale(range, range);
            if(getWorld() != null)
            {
                getWorld().addObject(rangeObj, getX(), getY());
            }
        }
    }
    
    public int getRange()
    {
        return range;
    }
    
    public void setRange(int range)
    {
        this.range = range;
    }
}
