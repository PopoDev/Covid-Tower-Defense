import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends SmoothMover
{
    HashMap <String, int[]> stats = new HashMap();
    
    int range = 100;
    boolean showingRange = false;
    Range rangeObj = null;
    
    
    
    boolean showingUpgrade = false;
    UpgradeHUD upgradeHUD = new UpgradeHUD();
    LinkedHashMap <String, Integer> upgrades = new LinkedHashMap(); // (Type, Level)
    ArrayList <HUD> upgradesIcon = new ArrayList();
    
    @Override
    protected void addedToWorld(World world)
    {
        // range = stats.get("Range")[0];
    }
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
    }
    
    public void showInfo()
    {
        if(Greenfoot.mousePressed(null) && !Greenfoot.mousePressed(upgradeHUD) && !Greenfoot.mousePressed(getWorld().getObjects(UpgradeIcon.class))
           && !Greenfoot.mousePressed(getWorld().getObjects(Buttons.class)))
        {
            if(Greenfoot.mousePressed(this))
            {
                showRange();
                showUpgrade();
            }
            
            if(!Greenfoot.mousePressed(this))
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
                getWorld().addObject(new UpgradeButton(), 288 + 200 * i, 870);
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
            getWorld().removeObjects(getWorld().getObjects(UpgradeButton.class));
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
            
            int level = upgrades.get(type);
            int[] values = stats.get(type);
            System.out.println(Arrays.toString(values));
            int initialValue = values[level - 1];
            int upgradedValue = values[level];
            upgradeIcon.setUpgradeValues(initialValue, upgradedValue);
            
            upgradesIcon.add(upgradeIcon);
        }
    }
    
    public void setStats(HashMap stats)
    {
        this.stats = stats;
    }
}
