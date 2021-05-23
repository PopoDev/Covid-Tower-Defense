import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

/**
 * Write a description of class Disinfectant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant extends Towers
{
    private int counter;
    
    private String[] upgrades = new String[] {"Damage", "Range", "Cooldown"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.DISINFECTANT;
    
    private ArrayList <int[]> possibleLoc = new ArrayList(); // coordonnées [x, y]
    
    public Disinfectant()
    {
        int[] damages = {1, 2, 3, 4, 5};
        int[] ranges = {150, 160, 170, 180, 190};
        int[] cd = {600, 540, 480, 420, 360}; // Cooldown
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
        
        counter = cooldown;
        checkLocation();
    }
    
    public void act() 
    {
        showInfo();
        
        if(!rangeUpdated)
        {
            checkLocation();
            rangeUpdated = true;
        }

        if(counter >= cooldown)
        {
            placeGel();
            counter = 0;
        }
        counter++;
    }
    
    /**
     * Trouve toutes les coordonnées où il y a des routes dans un rayon donné.
     */
    public void checkLocation()
    {
        // Portée : -radius à +radius avec une marge de 10 px
        int delta = Math.abs(radius - 10);
        
        for(int i = 0; i <= 2*delta; i = i+10) // Pour éviter le lag on incrémente de + 10
        {            
            int deltaX = -delta + i;
            int x = getX() + deltaX;
            int maxY = (int)Math.sqrt(delta*delta - deltaX*deltaX);
            for(int j = 0; j <= 2*maxY; j = j+10)
            {
                int deltaY = -maxY + j;
                int y = getY() + deltaY;
                if(getWorld().getObjectsAt(x, y, Roads.class).size() >= 1)
                {
                    int[] coords = {x, y};
                    possibleLoc.add(coords);
                }
            }
        }
    }
    
    public void placeGel()
    {
        if(possibleLoc.size() > 0)
        {
            HydroalcoholicGel hydroalcoholicGel = new HydroalcoholicGel();
            hydroalcoholicGel.setDamage(damage); // variable damage de la class Towers
            
            int index = Greenfoot.getRandomNumber(possibleLoc.size());
            int posX = possibleLoc.get(index) [0];
            int posY = possibleLoc.get(index) [1];
            getWorld().addObject(hydroalcoholicGel, posX, posY);
            
            GreenfootSound splash = new GreenfootSound("splash2.mp3");   
            splash.setVolume(25); 
            splash.play();
        }
    }
}
