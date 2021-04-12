import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    GreenfootImage menuBackground = new GreenfootImage("menu background 1200x900.png");
    
    public MainMenu()
    {    
        super(1200, 900, 1); 
        setBackground(menuBackground);
        placeButtons();
    }
    
    public void placeButtons()
    {
        addObject(new StartButton(), 600, 550);
    }
}
