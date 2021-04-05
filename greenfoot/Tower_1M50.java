import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower_1M50 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower_1M50 extends Towers
{   
    int range = 100;
    
    public Tower_1M50(World world, int x, int y)
    {
        Zone_1M50 zone_1M50 = new Zone_1M50();
        world.addObject(zone_1M50, x, y);
        
        setRange(range);
    }
    
    public void act() 
    {
        showRange();
    }    
}
