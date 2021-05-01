import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tier3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tier3 extends Virus
{
    int tier = 3;
    double speed = 2.0;
    int health = 3;
    
    public Tier3()
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
