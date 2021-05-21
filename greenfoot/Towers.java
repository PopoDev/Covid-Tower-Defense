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
    private HashMap <String, int[]> prices = new HashMap();
    private LinkedHashMap <String, Integer> upgrades = new LinkedHashMap(); // (Type, Level)
    
    private UpgradeHUD upgradeHUD = new UpgradeHUD();
    private HashMap <String, UpgradeIcon> upgradeIcons = new HashMap();
    private HashMap <String, UpgradeButton> upgradeButtons = new HashMap();
    
    public int damage;
    public int range; // diamètre
    public int radius; // rayon
    public int cooldown; // time relative to acts
    
    private Range rangeObj = new Range();;
    private boolean showingRange = false;
    private boolean showingUpgrade = false;
    
    public boolean rangeUpdated = true;
    
    private GreenfootImage towerImg = getImage();
    private StatsText statstext = new StatsText();
    Font statsFont = new Font("Arial", true, false, 14);
    
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
                if(!showingUpgrade)
                {
                    showRange();
                    showUpgrade();
                }
            } else {
                if(!(mouseActor instanceof Buttons || mouseActor instanceof HUD)) // Pas si on clique sur les buttons et HUD
                {
                    if(showingUpgrade)
                    {
                        unshowRange(rangeObj);
                        unshowUpgrade();
                    }
                }
            }
        }
    }
    
    public void showRange()
    {
        if(!showingRange)
        {
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
            upgradeHUD.getImage().drawImage(towerImg, 25, 25);
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
            upgradeHUD.getImage().clear();
            upgradeHUD.setImage(new GreenfootImage("HUD Upgrade + TowersIcon 800x100.png"));
            getWorld().removeObject(upgradeHUD);
            for(String type : upgrades.keySet())
            {
                getWorld().removeObject(upgradeIcons.get(type));
                getWorld().removeObject(upgradeButtons.get(type));
            }
            showingUpgrade = false;
        }
    }
    
    public void upgrade(String type)
    {
        int initialLevel = upgrades.get(type);
        int level = initialLevel + 1;
        upgrades.put(type, level);
        // System.out.println(upgrades);
        
        int index = level - 1;
        switch(type.toUpperCase())
        {
            case "DAMAGE":
                damage = stats.get(type) [index];
                break;
            case "RANGE":
                range = stats.get(type) [index];
                radius = range / 2;
                rangeObj.getImage().scale(range, range);
                rangeUpdated = false;
                break;
            case "COOLDOWN":
                cooldown = stats.get(type) [index];
                break;
            default:
                break;
        }
        System.out.println("Damage : " + damage + " | Range : " + range + " | Cooldown : " + cooldown);
        
        upgradeIcons.get(type).update();
        showStats();
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
            upgradeButton.setUpgradePrice(prices.get("Basic")[0]);
            
            upgradeButtons.put(type, upgradeButton);
        }
    }
    
    public void setStats(HashMap stats)
    {
        this.stats = stats;
        
        damage = this.stats.get("Damage")[0];
        range = this.stats.get("Range")[0];
        cooldown = this.stats.get("Cooldown")[0];
        radius = range / 2;
        
        getWorld().addObject(statstext, getX(), getY() - (getImage().getHeight()/2));
        statstext.getImage().setFont(statsFont);
        statstext.getImage().setColor(Color.CYAN); // CYAN, GREEN or YELLOW
        showStats();
    }
    
    public void showStats()
    {
        statstext.getImage().clear();
        ArrayList <Integer> levels = new ArrayList();
        for(String type : upgrades.keySet())
        {
            levels.add(upgrades.get(type));
        }
        statstext.getImage().drawString(levels.get(0) + " | " + levels.get(1) + " | " + levels.get(2), 0, 10);
        
        // GreenfootImage statsImg = new GreenfootImage(levels.get(0) + " | " + levels.get(1) + " | " + levels.get(2), 18, 
        //                                             Color.GREEN, Color.BLACK);
        // statstext.setImage(statsImg);
    }
    
    public void setPrices(HashMap prices)
    {
        this.prices = prices;
    }
}
