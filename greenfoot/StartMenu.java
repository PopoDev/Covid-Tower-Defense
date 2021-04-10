import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{
    GreenfootImage startBackground = new GreenfootImage("Interface BTD 5.PNG");
    StartButton startButton = new StartButton();
    
    public StartMenu()
    {    
        super(1200, 900, 1); 
        setBackground(startBackground);
        placeButtons();
    }
    
    public void placeButtons()
    {
        addObject(startButton, 600, 600);
    }
}
