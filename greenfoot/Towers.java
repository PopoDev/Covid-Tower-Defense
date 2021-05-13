import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
    
    LinkedHashMap <String, Integer> upgrades = new LinkedHashMap(); // (Type, Level)
    ArrayList <HUD> upgradesIcon = new ArrayList();
    
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
            for(int i = 0; i < upgradesIcon.size(); i++)
            {
                getWorld().addObject(upgradesIcon.get(i), 275 + 200 * i, 850);
            }
            showingUpgrade = true;
        }
    }
    
    public void unshowUpgrade()
    {
        if(showingUpgrade)
        {
            getWorld().removeObject(upgradeHUD);
            getWorld().removeObjects(getWorld().getObjects(UpgradeIcon.class));
            showingUpgrade = false;
        }
    }
    
    public void setUpgrades(String[] Upgrades)
    {
        for(String upgrade : Upgrades)
        {
            upgrades.put(upgrade, 1);
        }
        System.out.println(upgrades);
    }
    
    public void addUpgrades()
    {
        for(String type : upgrades.keySet())
        {
            UpgradeIcon upgradeIcon = new UpgradeIcon();
            upgradeIcon.setUpgradeType(type);
            upgradesIcon.add(upgradeIcon);
        }
    }
}
