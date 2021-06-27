import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Écran d'accueil
 * 
 * @author PopoDev
 * @version 10.05.2021
 */
public class StartMenu extends World
{
    GreenfootImage startBackground = new GreenfootImage("Starting background final 1200x900.png");
    
    public StartMenu()
    {    
        super(1200, 900, 1); 
        setBackground(startBackground);
        placeStartButtons();
    }
    
    public void placeStartButtons()
    {
        addObject(new StartButton(), 600, 550);
    }
}
