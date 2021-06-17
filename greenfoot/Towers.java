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
    private SellButton sellButton;
    public int towerPrice;
    
    public int damage;
    public int range; // diamètre
    public int radius; // rayon
    public int cooldown; // time relative to acts
    public int atkspd; // attack speed
    public int delay;
    
    public int moneyPerKill; // Sport
    public int moneyPerRound; // Culture
    
    private int kills = 0;
    
    private Range rangeObj = new Range();
    private boolean showingRange = false;
    private boolean showingUpgrade = false;
    
    public boolean needUpdate = false;
    public boolean rangeUpdated = true;
    
    private GreenfootImage towerImg;
    private TextBox statstext = new TextBox();
    Font statsFont = new Font("Arial", true, false, 14);
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        if(damage > currentHealth) damage = currentHealth;
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        
        if(SoundButton.soundOn) Greenfoot.playSound("pop.mp3");
        
        addKills(damage);
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
                if(!(mouseActor instanceof SpawnMobs || mouseActor instanceof UpgradeButton || mouseActor instanceof SellButton 
                || mouseActor instanceof HUD)) // Pas si on clique sur SpawnMobs, Upgrade, Sell et HUD
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
    
    public void setRange(int range)
    {
        this.range = range;
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
            getWorld().addObject(sellButton,136, 830);
            showingUpgrade = true;
        }
    }
    
    public void unshowUpgrade()
    {
        if(showingUpgrade)
        {
            upgradeHUD.getImage().clear();
            upgradeHUD.setImage(new GreenfootImage("HUD Upgrade + TowersIcon 800x100.png"));
            upgradeHUD.removeScoreText();
            getWorld().removeObject(upgradeHUD);
            for(String type : upgrades.keySet())
            {
                getWorld().removeObject(upgradeIcons.get(type));
                getWorld().removeObject(upgradeButtons.get(type));
            }
            getWorld().removeObject(sellButton);
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
                rangeObj.setImage("Range (5.0) 1000x1000.png");
                rangeObj.getImage().scale(range, range);
                rangeUpdated = false;
                break;
            case "COOLDOWN":
                cooldown = stats.get(type) [index];
                break;
                
            case "DELAY":
                delay = stats.get(type) [index];
                break;
                
            case "ATKSPEED":
                atkspd = stats.get(type) [index];
                break;
            case "SPORT":
                moneyPerKill = stats.get(type) [index];
                ((Map)getWorld()).addMoneyPerKill(moneyPerKill);
                break;
            case "CULTURE":
                moneyPerRound = stats.get(type) [index];
                ((Map)getWorld()).addMoneyPerRound(moneyPerRound);
                break;
            default:
                break;
        }
        // System.out.println("Damage : " + damage + " | Range : " + range + " | Cooldown : " + cooldown);
        
        if(SoundButton.soundOn) Greenfoot.playSound("buy.mp3");
        
        needUpdate = true;
        upgradeIcons.get(type).update();
        upgradeButtons.get(type).update();
        sellButton.updateText();
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
            
            int[] price = prices.get(type);
            System.out.println(Arrays.toString(price));
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
            upgradeButton.setUpgradePrices(prices.get(type));
            
            upgradeButtons.put(type, upgradeButton);
        }
    }
    
    public void addSellButton()
    {
        sellButton = new SellButton();
        sellButton.setLinkedTower(this);
    }
    
    public void setStats(HashMap stats)
    {
        this.stats = stats;
        
        if(stats.get("Damage") != null) damage = this.stats.get("Damage")[0];
        if(stats.get("Range") != null) range = this.stats.get("Range")[0];
        radius = range / 2;
        if(stats.get("Cooldown") != null) cooldown = this.stats.get("Cooldown")[0];
        if(stats.get("Delay") != null) delay = this.stats.get("Delay")[0];
        if(stats.get("AtkSpeed") != null) atkspd = this.stats.get("AtkSpeed")[0];
        
        if(stats.get("Sport") != null) moneyPerKill = this.stats.get("Sport")[0];
        if(stats.get("Culture") != null) moneyPerRound = this.stats.get("Culture")[0];
        
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
        if(levels.size() == 3) statstext.getImage().drawString(levels.get(0) + " | " + levels.get(1) + " | " + levels.get(2), 0, 10);
        if(levels.size() == 2) statstext.getImage().drawString(levels.get(0) + " | " + levels.get(1), 10, 10);
        
        // GreenfootImage statsImg = new GreenfootImage(levels.get(0) + " | " + levels.get(1) + " | " + levels.get(2), 18, 
        //                                             Color.GREEN, Color.BLACK);
        // statstext.setImage(statsImg);
    }
    
    public void setPrices(HashMap prices)
    {
        this.prices = prices;
        towerPrice = this.prices.get("Basic")[0];
    }
    
    public void setTowerImg(GreenfootImage towerImg)
    {
        this.towerImg = towerImg;
    }
    
    public void addKills(int amount)
    {
        this.kills += amount;
        upgradeHUD.updateScore(kills);
    }
    
    public void addTowerPrice(int amount)
    {
        this.towerPrice += amount;
        //System.out.println("Towers price :" + towerPrice);
    }
    
    /**
     * When the player sell the tower, remove everything and add 80% of the tower's value to the balance
     */
    public void sell()
    {
        upgradeHUD.removeScoreText();
        getWorld().removeObject(upgradeHUD);
        for(String type : upgrades.keySet())
        {
            getWorld().removeObject(upgradeIcons.get(type));
            getWorld().removeObject(upgradeButtons.get(type));
        }
        getWorld().removeObject(sellButton);
        getWorld().removeObject(rangeObj);
        getWorld().removeObject(statstext);
        
        ((Map)getWorld()).addMoney((int)(towerPrice * 0.8)); // Redonne 80% de la valeur de la tour.
        System.out.println(this + " vendu pour : " + (int)(towerPrice * 0.8));
        
        getWorld().removeObject(this);
    }
}
