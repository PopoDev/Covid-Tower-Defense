import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disinfectant_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon désinfectant 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon désinfectant mouseOn 100x100.png");
    private GreenfootImage towerImg = new GreenfootImage("Désinfectant 50x50.png");
    
    private boolean isGrabbed = false;
    
    public void act() 
    {
        changeIfHovering(Icon, IconOn);
        if(Greenfoot.mouseClicked(this))
        {
            Towers disinfectant = new Disinfectant(); // Create new Instance only when clicked
            createWhenClicked(towerImg);
            setTower(disinfectant);
            isGrabbed = true;
        }
        if(isGrabbed)followMouse();
    }
}
