import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class TowersIcon extends Buttons
{   
    boolean setInfo = false;
    HUD infoBox;
    
    public void createWhenClicked(TowersPlacer towerPlacer, GreenfootImage TowerImg)
    {
        // Create new Instance only when clicked for selecting
        System.out.println("Clicked on : " + this);

        getWorld().addObject(towerPlacer, getX(), getY());
    }
    
    public void showInfoIfHovering(HUD infoTower)
    {
        if(isHovering() && !setInfo)
        {
            infoBox = infoTower;
            getWorld().addObject(infoBox, 700, getY());
            setInfo = true;
        }
        
        if(!isHovering() && setInfo)
        {
            getWorld().removeObject(infoBox);
            setInfo = false;
        }
    }  
}