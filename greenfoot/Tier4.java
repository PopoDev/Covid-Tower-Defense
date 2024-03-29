import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tier4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tier4 extends Virus
{
    int tier = 4;
    double speed = 2.5;
    int health = 4;
    
    public Tier4()
    {
        setRotation(90);
        setTier(tier);
        setHealth(health);
    }
    
    public void act() 
    {
        if(!isTouching(Mask.class))
        {
            move(speed);
        } else {
            move(Greenfoot.getRandomNumber(4) - 2);
        }
        turnAtCorner();
        if(isAtBorder()) 
        {
            attackLives();
        }
        changeTier();
    }   
}
