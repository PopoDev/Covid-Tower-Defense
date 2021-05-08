import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IconDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyIcon extends HUD
{
    GreenfootImage EasyIcon = new GreenfootImage("IconDifficulty Easy 320x70.png");
    GreenfootImage MediumIcon = new GreenfootImage("IconDifficulty Medium 320x70.png");
    GreenfootImage HardIcon = new GreenfootImage("IconDifficulty Hard 320x70.png");
    
    @Override
    protected void addedToWorld(World world)
    {
        switch(((Map)getWorld()).difficulty.toUpperCase())
        {
            case "EASY":
                setImage(EasyIcon);
                break;
            case "MEDIUM":
                setImage(MediumIcon);
                break;
            case "HARD":
                setImage(HardIcon);
                break;
            default:
                break;
        }
    }
}
