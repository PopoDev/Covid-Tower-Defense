import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndMenu extends World
{
    GreenfootImage victoryImg = new GreenfootImage("victoire 1200x900.png");
    GreenfootImage defeatImg = new GreenfootImage("défaite 1200x900.png");
    
    GreenfootImage image = null;
    boolean imgSet = false;
    
    public EndMenu()
    {    
        super(1200, 900, 1);
    }
    
    public void act()
    {
        if(!imgSet) setBackground(image);
        imgSet = true;
    }
    
    public void setWinImage(boolean win)
    {
        if(win) 
        {
            image = victoryImg;
        } else {
            image = defeatImg;
        }
    }
}
