import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tier2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tier2 extends Virus
{
    int tier = 2;
    double speed = 1.5;
    int health = 2;
    
    public Tier2()
    {
        setRotation(90);
        setTier(tier);
        setHealth(health);
    }
    
    public void act() 
    {
        move(speed);
        turnAtCorner();
        if(isAtBorder()) 
        {
            attackLives();
        }
        changeTier();
    }
}
