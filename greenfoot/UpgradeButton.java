import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Buttons
{
    GreenfootImage upgradeButton = new GreenfootImage("Upgrade Button 110x22.png");
    GreenfootImage upgradeButtonOn = new GreenfootImage("Upgrade Button 112x24 mouseOn.png");
    
    public void act() 
    {
        changeIfHovering(upgradeButton, upgradeButtonOn);
    }    
}
