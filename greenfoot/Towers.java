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
    boolean showingRange = false;
    Range rangeObj = null;
    
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
        if(Greenfoot.mouseClicked(null))
        {
            if(Greenfoot.mouseClicked(this) && !showingRange)
            {
                System.out.println("Clicked on : " + this);
                rangeObj = new Range();
                rangeObj.getImage().scale(range, range);
                if(getWorld() != null)
                {
                    getWorld().addObject(rangeObj, getX(), getY());
                    showingRange = true;
                }   
            } 
            
            if(!Greenfoot.mouseClicked(this) && rangeObj != null)
            {
                unshowRange(rangeObj);
            }
        }
    }
    
    public void unshowRange(Range rangeObj)
    {
        if(showingRange)
        {
             getWorld().removeObject(rangeObj);
             System.out.println(rangeObj + " was removed");
             showingRange = false;
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
