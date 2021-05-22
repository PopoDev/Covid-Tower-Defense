import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends SmoothMover
{
    boolean mouseOn = false;
    boolean setImageOn = false;
    
    boolean setInfo = false;
    HUD infoBox;
    
    Map map;
    
    @Override
    protected void addedToWorld(World world)  
    {
        map = (Map)getWorld();
    }
    
    public boolean isHovering()
    {
        if(Greenfoot.mouseMoved(this) && !mouseOn) mouseOn = true; 
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null) && mouseOn) mouseOn = false;
        if(mouseOn)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public void showInfoIfHovering(HUD infoTower, int x, int y)
    {
        if(isHovering() && !setInfo)
        {
            infoBox = infoTower;
            getWorld().addObject(infoBox, x, y);
            setInfo = true;
        }
        
        if(!isHovering() && setInfo)
        {
            getWorld().removeObject(infoBox);
            setInfo = false;
        }
    }
}
