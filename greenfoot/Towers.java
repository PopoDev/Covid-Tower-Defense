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
    private HashMap <String, int[]> stats = new HashMap();
    private LinkedHashMap <String, Integer> upgrades = new LinkedHashMap(); // (Type, Level)
    
    private UpgradeHUD upgradeHUD = new UpgradeHUD();
    private HashMap <String, UpgradeIcon> upgradeIcons = new HashMap();
    private HashMap <String, UpgradeButton> upgradeButtons = new HashMap();
    
    private int damage;
    private int cooldown;
    private int range;
    private Range rangeObj = null;
    
    private boolean showingRange = false;
    private boolean showingUpgrade = false;

    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
    }
    
    public void showInfo()
    {
        if(Greenfoot.mousePressed(null))
        {
            MouseInfo mi = Greenfoot.getMouseInfo();
            Actor mouseActor = mi.getActor();
            
            if(Greenfoot.mousePressed(this))
            {
                System.out.println("Clicked on : " + this);
                showRange();
                showUpgrade();
            } else {
                if(!(mouseActor instanceof Buttons || mouseActor instanceof HUD)) // Pas si on clique sur les buttons et HUD
                {
                    unshowRange(rangeObj);
                    unshowUpgrade();
                }
            }
        }
        
    }
    
    public void showRange()
    {
        if(!showingRange)
        {
             //System.out.println("Clicked on : " + this);
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
             // System.out.println(rangeObj + " was removed");
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
            int i = 0;
            for(String type : upgrades.keySet())
            {
                getWorld().addObject(upgradeIcons.get(type), 275 + 200 * i, 850);
                getWorld().addObject(upgradeButtons.get(type), 288 + 200 * i, 870);
                i++;
            }
            showingUpgrade = true;
        }
    }
    
    public void unshowUpgrade()
    {
        if(showingUpgrade)
        {
            getWorld().removeObject(this.upgradeHUD);
            for(String type : upgrades.keySet())
            {
                getWorld().removeObject(upgradeIcons.get(type));
                getWorld().removeObject(upgradeButtons.get(type));
            }
            showingUpgrade = false;
            System.out.println("Unshowing" + this);
        }
    }
    
    public void upgrade(String type)
    {
        int initialLevel = upgrades.get(type);
        int level = initialLevel + 1;
        upgrades.put(type, level);
        System.out.println(upgrades);
        
        int index = level - 1;
        switch(type.toUpperCase())
        {
            case "DAMAGE":
                damage = stats.get(type) [index];
                break;
            case "RANGE":
                range = stats.get(type) [level - 1];
                break;
            case "COOLDOWN":
                cooldown = stats.get(type) [level - 1];
                break;
            default:
                break;
        }
        System.out.println("Damage : " + damage + " | Range : " + range + " | Cooldown : " + cooldown);
        
        upgradeIcons.get(type).update();
    }
    
    public void setUpgrades(String[] Upgrades)
    {
        for(String upgrade : Upgrades)
        {
            upgrades.put(upgrade, 1);
        }
        System.out.println(upgrades);
    }
    
    public void addUpgradeIcon()
    {
        for(String type : upgrades.keySet())
        {
            UpgradeIcon upgradeIcon = new UpgradeIcon();
            upgradeIcon.setUpgradeType(type);
            
            int level = upgrades.get(type);
            int[] values = stats.get(type);
            System.out.println(Arrays.toString(values));
            upgradeIcon.setUpgradeValues(values);
            
            upgradeIcons.put(type, upgradeIcon);
        }
    }
    
    public void addUpgradeButton()
    {
        for(String type : upgrades.keySet())
        {
            UpgradeButton upgradeButton = new UpgradeButton();
            upgradeButton.setLinkedTower(this);
            upgradeButton.setUpgradeType(type);
            
            upgradeButtons.put(type, upgradeButton);
        }
    }
    
    public void setStats(HashMap stats)
    {
        this.stats = stats;
        
        damage = this.stats.get("Damage")[0];
        range = this.stats.get("Range")[0];
        cooldown = this.stats.get("Cooldown")[0];
    }
}
