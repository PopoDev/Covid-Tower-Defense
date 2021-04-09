import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class TowersIcon extends HUD
{   
    public void createWhenClicked(TowersPlacer towerPlacer, GreenfootImage TowerImg)
    {
        // Create new Instance only when clicked for selecting
        System.out.println("Clicked on : " + this);

        getWorld().addObject(towerPlacer, getX(), getY());
    }
}