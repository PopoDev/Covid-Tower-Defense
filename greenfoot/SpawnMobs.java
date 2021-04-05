import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

/**
 * Write a description of class SpawnMobs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * Source : image from http://clipart-library.com/clipart/rijr5A4jT.htm
 */
public class SpawnMobs extends Actor
{
    int gridSize = 50;
    
    int spawnX = gridSize/2 + gridSize;
    int spawnY = gridSize/2;
    
    int timeWave = 0; // [acts]
    
    ArrayList <Integer> spawnCounters = new ArrayList();
    
    public void act()
    {
        spawning();
        timeWave++;
    }
    
    public void spawning()
    {
        spawnAtInterval(10, 1, new Tier2(), spawnX, spawnY, 20);
        spawnAtInterval(5, 2, new Tier4(), spawnX, spawnY, 40);
        
        if(timeWave > 500){ spawnAtInterval(20, 3, new Tier3(), spawnX, spawnY, 10); }
    }
    
    public void spawnAtInterval(int number, int spawnNumber, Virus tier, int x, int y, int interval) // interval relative to act
    {   
        if(spawnCounters.size() < spawnNumber)
        {
            spawnCounters.add(0);
        }
        
        int soloCounter = spawnCounters.get(spawnNumber - 1);
        if(timeWave % interval == 0)
        {
            if(soloCounter < number)
            {
                getWorld().addObject(tier, x, y);
                soloCounter++;
                spawnCounters.set((spawnNumber - 1), soloCounter);
            }
            // System.out.println(spawnCounters); risque de lag
        }
    }
    
    /*public void spawnAtInterval(int number, Virus tier, int x, int y, long interval) // interval in milliseconds
    {
        for(int i = 1; i <= number; i++)
        {
            getWorld().addObject(tier, x, y);
            try { 
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
     */
    
    // int actCount = 0;
    // int current = 0;
    // boolean timeSet = false;
    
    
    /*public void settimeWave(int acts)
    {
        if(!timeSet)
        {
            current = actCount;
            if(current + acts > actCount)
            { 
                timeSet = true;
                return; 
            }
        } else {
            timeSet = false;
        }
    }
     */
}
