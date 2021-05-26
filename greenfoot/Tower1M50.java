import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Write a description of class Tower_1M50 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower1M50 extends Towers
{   
    private String[] upgrades = new String[] {"Damage", "Range", "Cooldown"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.M50;
    
    int basicSize = 10;
    Zone1M50 zone1M50;
    
    public Tower1M50()
    {
        int[] damages = {1, 2, 3, 4, 5};
        int[] ranges = {100, 110, 120, 130, 140};
        int[] cd = {180, 140, 100, 60, 20}; // Temps pour que la zone atteigne sa portée maximale.
        stats.put(upgrades[0], damages);
        stats.put(upgrades[1], ranges);
        stats.put(upgrades[2], cd);
        
        prices.put("Basic", towerPrices.getTypePrices(0));
        prices.put(upgrades[0], towerPrices.getTypePrices(1));
        prices.put(upgrades[1], towerPrices.getTypePrices(2));
        prices.put(upgrades[2], towerPrices.getTypePrices(3));
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        setUpgrades(upgrades);
        setStats(stats);
        setPrices(prices);
        addUpgradeIcon();
        addUpgradeButton();
        
        zone1M50 = new Zone1M50();
        zone1M50.getImage().scale(basicSize, basicSize);
        zone1M50.setLinkedTower(this);
        zone1M50.setStats(damage, range, cooldown);
        getWorld().addObject(zone1M50, getX(), getY());
    }
    
    public void act() 
    {
        showInfo();
        
        if(needUpdate)
        {
            update();
        }
    }
    
    public void update()
    {
        zone1M50.setStats(damage, range, cooldown);
        needUpdate = false;
    }
}
