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
    
    int wave = 1;
    int timeWave = 0; // [acts]
    
    int spawnMax = 0;
    
    ArrayList <Integer> spawnCounters = new ArrayList();
    
    public void act()
    {
        wavesManager();
        timeWave++;
    }
    
    public void wavesManager()
    {
        switch(wave)
        {
            case 1:
                int[][] rounds = 
                { // spawnSerie / number / interval / timeWave [acts]
                    {1, 10, 20, 0},     // Tier 2
                    {2, 5, 40, 0},      // Tier 4
                    {3, 20, 10, 500}    // Tier 3
                };
                spawning(rounds[0], new Tier2());
                spawning(rounds[1], new Tier4());
                spawning(rounds[2], new Tier3());
                
                for(int i = 0; i < rounds.length; i++) spawnMax = rounds[i][1];
                
            default:
                break;
        }
    }
    
    public void spawning(int[] Serie, Virus tier)
    {
        if(timeWave >= Serie[3]){ spawnAtInterval(Serie[0], Serie[1], Serie[2], tier, spawnX, spawnY); }
    }
    
    public void spawnAtInterval(int spawnSerie, int number, int interval, Virus tier, int x, int y) // interval relative to act
    {   
        if(spawnCounters.size() < spawnSerie)
        {
            spawnCounters.add(number);
        }
        
        if(timeWave % interval == 0)
        {
            int soloCounter = spawnCounters.get(spawnSerie - 1);
            if(soloCounter > 0)
            {
                getWorld().addObject(tier, x, y);
                soloCounter--;
                spawnCounters.set((spawnSerie - 1), soloCounter);
            }
            System.out.println(spawnCounters); // risque de lag
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
