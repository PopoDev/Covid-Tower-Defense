import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disinfectant_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon d�sinfectant 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon d�sinfectant mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("D�sinfectant 50x50.png");
    
    DisinfectantPlacer disinfectantPlacer = new DisinfectantPlacer();

    public void act() 
    {
        changeIfHovering(Icon, IconOn);
        if(Greenfoot.mouseClicked(this))
        {
            createWhenClicked(disinfectantPlacer, towerImg);
        }
    }
}
