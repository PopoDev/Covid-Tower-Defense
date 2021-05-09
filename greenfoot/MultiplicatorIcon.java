import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiplicatorIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiplicatorIcon extends HUD
{
    GreenfootImage EasyMultiplicator = new GreenfootImage("IconMultiplicator Easy 70x70.png");
    GreenfootImage MediumMultiplicator = new GreenfootImage("IconMultiplicator Medium 70x70.png");
    GreenfootImage HardMultiplicator = new GreenfootImage("IconMultiplicator Hard 70x70.png");
    
    InfoMultiplicator infoMultiplicator = new InfoMultiplicator();
    
    @Override
    protected void addedToWorld(World world)
    {
        switch(((Map)getWorld()).difficulty.toUpperCase())
        {
            case "EASY":
                setImage(EasyMultiplicator);
                break;
            case "MEDIUM":
                setImage(MediumMultiplicator);
                break;
            case "HARD":
                setImage(HardMultiplicator);
                break;
            default:
                break;
        }
    }
    
    public void act()
    {
        showInfoIfHovering(infoMultiplicator, getX(), getY() - 75);
    }
}
