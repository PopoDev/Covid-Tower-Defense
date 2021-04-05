import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.TimeUnit;

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
    
    boolean spawned = false;
    
    int counter = 0;
    int delay = 0;
    
    public void act()
    {
        spawning();
        delay++;
    }
    
    public void spawning()
    {
        spawnAtInterval(10, new Tier2(), spawnX, spawnY, 10);
    }
    
    public void spawnAtInterval(int number, Virus tier, int x, int y, int interval) // interval relative to act
    {
        if(counter < number)
        {
            if(delay == interval)
            {
                getWorld().addObject(tier, x, y);
                counter++;
                delay = 0;
            }
        }
    }
}
