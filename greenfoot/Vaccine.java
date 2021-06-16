import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Vaccine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vaccine extends Towers
{
    private int counter;
    
    private String[] upgrades = new String[] {"Damage", "Range", "Cooldown"};
    
    private HashMap <String, int[]> stats = new HashMap();
    private HashMap <String, int[]> prices = new HashMap();
    private PriceManager.Prices towerPrices = PriceManager.Prices.VACCINE;
    
    private GreenfootImage towerImg = new GreenfootImage("vaccin 50x50 (bottom).png");
    
    GreenfootImage vaccineCharged = new GreenfootImage("Vaccin 95x25 plein.png");
    GreenfootImage vaccineFired = new GreenfootImage("Vaccin 95x25 pressé.png");
    boolean charged = true;
    
    public Vaccine()
    {
        int[] damages = {2, 4, 6, 8, 10};
        int[] ranges = {600, 700, 800, 900, 1000};
        int[] cd = {250, 200, 150, 100, 50}; // Cooldown
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
        setTowerImg(towerImg);
               
        addUpgradeIcon();
        addUpgradeButton();
        addSellButton();
        
        showRange();
        showUpgrade();        
        
        counter = cooldown;
    }
    
    public void act() 
    {
        showInfo();
        
        if(counter >= cooldown/2 && !charged)
        {
            setImage(vaccineCharged);
            charged = true;
        }

        if(counter >= cooldown)
        {
            attackVaccine();
            counter = 0;
        }
        counter++;
    }
    
    public void attackVaccine()
    {
        List <Mobs> ennemies = getObjectsInRange(radius, Mobs.class);
        if(!ennemies.isEmpty())
        {
            ArrayList <Integer> ennemiesHealth = new ArrayList();
            for(int i = 0; i<ennemies.size(); i++)
            {
                ennemiesHealth.add(ennemies.get(i).getHealth());
            }
            int biggestHealth = Collections.max(ennemiesHealth); // Target the strongest ennemy
            Mobs targetedEnnemi = null;
            for(int j = 0; j<ennemies.size(); j++)
            {
                if(ennemies.get(j).getHealth() == biggestHealth)
                {
                    targetedEnnemi = ennemies.get(j);
                    break;
                }
            }
            turnTowards(targetedEnnemi.getX(), targetedEnnemi.getY());
            attack(targetedEnnemi, damage);
            
            setImage(vaccineFired);
            charged = false;
        }
    }
}