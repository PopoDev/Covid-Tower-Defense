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
    
    public void changeIfHovering(GreenfootImage initialImg, GreenfootImage hoveringImg)
    {
        if(Greenfoot.mouseMoved(this) && !mouseOn) mouseOn = true; 
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null)) mouseOn = false;
        if(mouseOn && !setImageOn || mouseOn && !Greenfoot.mouseMoved(null))
        {
            setImage(hoveringImg);
            setImageOn = true;
            // System.out.println(hoveringImg);
        }
        if(!mouseOn && setImageOn || !mouseOn && !Greenfoot.mouseMoved(null))
        {
            setImage(initialImg);
            setImageOn = false;
            // System.out.println(initialImg);
        }
    }  
}
