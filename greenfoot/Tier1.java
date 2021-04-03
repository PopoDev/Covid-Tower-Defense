import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tier1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tier1 extends Virus
{
    int tier = 1;
    double speed = 1.0;
    int health = 1;
    
    public Tier1()
    {
        setRotation(90);
        setTier(tier);
        setHealth(health);
    }

    public void act() 
    {
        move(speed);
        turnAtCorner();
        removeDead();
    }
}