import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disinfectant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant extends Towers
{
    int range = 150;
    
    public Disinfectant()
    {
        setRange(range);
    }
    
    public void act() 
    {
        showRange();
    }    
}
