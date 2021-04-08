import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IconBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconBox extends TowersIcon
{
    public void act()
    { 
        if(Greenfoot.mouseClicked(this))
        {
            placeTower();
        }
    }
}
