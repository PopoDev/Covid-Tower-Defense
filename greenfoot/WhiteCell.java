import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.List;

/**
 * Write a description of class WhiteCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteCell extends Towers
{
    private int counter;
    
    private String[] upgrades = new String[] {"Damage", "Range", "AtkSpeed"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.WHITECELL;
    
    private GreenfootImage towerImg = new GreenfootImage("Globule blanc 50x50 (bottom).png");
    
    private GreenfootImage noPunch = new GreenfootImage("Globule blanc 46x48.png");
    private GreenfootImage leftPunch = new GreenfootImage("Globule blanc 46x51 (left punch).png");
    private GreenfootImage rightPunch = new GreenfootImage("Globule blanc 46x51 (right punch).png");
    
    public WhiteCell()
    {
        int[] damages = {1, 2, 3, 4, 5};
        int[] ranges = {120, 130, 140, 150, 160};
        int[] atkspd = {5, 10, 15, 20, 25}; // Attack speed = # de coup par 100 acts
        stats.put(upgrades[0], damages);
        stats.put(upgrades[1], ranges);
        stats.put(upgrades[2], atkspd);
        
        prices.put("Basic", towerPrices.getTypePrices(0));
        prices.put(upgrades[0], towerPrices.getTypePrices(1));
        prices.put(upgrades[1], towerPrices.getTypePrices(2));
        prices.put(upgrades[2], towerPrices.getTypePrices(3));
        
        setRotation(90);
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        setStats(stats);
        setPrices(prices);
        setUpgrades(upgrades);
        setTowerImg(towerImg);
    }
    
    public void act() 
    {
        showInfo();
        if(counter >= Math.round(100/atkspd))
        {
            punchVirus();
        }
        counter++;
    }
    
    public void punchVirus()
    {
        List <Virus> viruses = getObjectsInRange(radius, Virus.class);
        if(!viruses.isEmpty())
        {
            int i = Greenfoot.getRandomNumber(viruses.size());
            Virus attackedVirus = viruses.get(i);
            turnTowards(attackedVirus.getX(), attackedVirus.getY());
            if(getImage() != rightPunch)
            {
                setImage(rightPunch);
            } else {
                setImage(leftPunch);
            }
            attack(attackedVirus, damage);
            counter = 0;
        } else {
            if(getImage() != noPunch && counter >= 100) setImage(noPunch);
        }
    }
}
