import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{
    // GreenfootImage startBackground = new GreenfootImage("Interface BTD 5.PNG");
    GreenfootImage startBackground = new GreenfootImage("Starting screen 1200x900.png");
    
    public StartMenu()
    {    
        super(1200, 900, 1); 
        setBackground(startBackground);
        placeStartButtons();
    }
    
    public void placeStartButtons()
    {
        addObject(new StartButton(), 600, 550);
        addObject(new CreditsButton(), 600, 650);
    }
}
