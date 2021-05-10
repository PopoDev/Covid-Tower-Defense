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
    
    boolean showingUpgrade = false;
    UpgradeHUD upgradeHUD = new UpgradeHUD();
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        // System.out.println(currentHealth);
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
    }
    
    public void showInfo()
    {
        if(Greenfoot.mouseClicked(null))
        {
            if(Greenfoot.mouseClicked(this))
            {
                showRange();
                showUpgrade();
            }
            
            if(!Greenfoot.mouseClicked(this))
            {
                unshowRange(rangeObj);
                unshowUpgrade();
            }
        }
        
    }
    
    public void showRange()
    {
        if(!showingRange)
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
     
    public void showUpgrade()
    {
        if(!showingUpgrade)
        {
            getWorld().addObject(upgradeHUD, 400, 850);
            getWorld().addObject(new UpgradeButton(), 300, 850);
            showingUpgrade = true;
        }
    }
    
    public void unshowUpgrade()
    {
        if(showingUpgrade)
        {
            getWorld().removeObject(upgradeHUD);
            showingUpgrade = false;
        }
    }
}
