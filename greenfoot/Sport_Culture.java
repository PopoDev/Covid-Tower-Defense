import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Write a description of class Sport_Culture here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sport_Culture extends Towers
{
    private int counter;
    private int range = 80;
    
    private String[] upgrades = new String[] {"Sport", "Culture"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.SPORT_CULTURE;
    
    private GreenfootImage image = new GreenfootImage("Sport&Culture 50x40.png");
    
    public Sport_Culture()
    {
        int[] moneyPerKill = {1, 2, 3, 4, 5};
        int[] moneyPerRound = {100, 200, 300, 400, 500};
        stats.put(upgrades[0], moneyPerKill);
        stats.put(upgrades[1], moneyPerRound);
        
        prices.put("Basic", towerPrices.getTypePrices(0));
        prices.put(upgrades[0], towerPrices.getTypePrices(1));
        prices.put(upgrades[1], towerPrices.getTypePrices(2));
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        setUpgrades(upgrades);
        setStats(stats);
        setRange(range);
        setPrices(prices);
        setTowerImg(image);
        
        addUpgradeIcon();
        addUpgradeButton();
        addSellButton();
        
        ((Map)getWorld()).addMoneyPerKill(1);
        ((Map)getWorld()).addMoneyPerRound(100);
    }
    
    public void act() 
    {
        showInfo();
    }
}
