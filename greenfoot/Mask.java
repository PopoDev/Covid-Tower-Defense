import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mask extends TowersProjectile
{
    private int counter = 0;
    private int delay;
    
    public void act()
    {
        if(counter >= delay)
        {
            getWorld().removeObject(this);
        }
        counter++;
    }
    
    public void setDelay(int delay)
    {
        this.delay = delay;
    }
}
