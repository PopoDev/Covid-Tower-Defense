import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tier5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tier5 extends Virus
{
    int tier = 5;
    double speed = 3;
    int health = 5;
    
    public Tier5()
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
