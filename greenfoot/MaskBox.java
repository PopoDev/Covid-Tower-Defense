import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.List;
/**
 * Write a description of class Mask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaskBox extends Towers
{
    private int counter;
    
    private String[] upgrades = new String[] {"Delay", "Range", "Cooldown"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.MASK;
    
    private GreenfootImage image = new GreenfootImage("Masque Image 50x50.png");
    
    public MaskBox()
    {
        int[] delays = {500, 750, 1000, 1250, 1500};
        int[] ranges = {150, 175, 200, 225, 250};
        int[] cd = {2400, 2200, 2000, 1800, 1600};
        stats.put(upgrades[0], delays);
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
        setTowerImg(image);
        addUpgradeIcon();
        addUpgradeButton();
        
        counter = cooldown;
    }
    
    public void act() 
    {
        showInfo();
        
        if(counter >= cooldown)
        {
            placeMask();
            counter = 0;
        }
        counter++;
    }
    
    public void placeMask()
    {
        List <Roads> roads = getObjectsInRange(radius, Roads.class);
        
        if(!roads.isEmpty())
        {
            int i = Greenfoot.getRandomNumber(roads.size());
            
            Roads road = roads.get(i);
            int x = road.getX();
            int y = road.getY();
        
            Mask mask = new Mask();
            mask.setDelay(delay);
            switch(road.getDirection().toUpperCase())
            {
                case "VERTICAL":
                    mask.setRotation(0);
                    break;
                case "HORIZONTAL":
                    mask.setRotation(-90);
                    break;
                case "UR":
                    mask.setRotation(-45);
                    x += 5;
                    y += -5;
                    break;
                case "UL":
                    mask.setRotation(45);
                    x += -5;
                    y += -5;
                    break;
                case "DR":
                    mask.setRotation(45);
                    x += 5;
                    y += 5;
                    break;
                case "DL":
                    mask.setRotation(-45);
                    x += -5;
                    y += 5;
                    break;
                default:
                    break;
            }
            getWorld().addObject(mask, x, y);
        }
    }
}
