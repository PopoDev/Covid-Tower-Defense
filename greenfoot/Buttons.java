import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends SmoothMover
{
    boolean mouseOn = false;
    boolean setImageOn = false;
    
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
    
    public void changeIfHovering(GreenfootImage initialImg, GreenfootImage hoveringImg)
    {
        if(isHovering() && !setImageOn)
        {
            setImage(hoveringImg);
            setImageOn = true;
        } 
        if(!isHovering() && setImageOn)
        {
            setImage(initialImg);
            setImageOn = false;
        }
    }
}
