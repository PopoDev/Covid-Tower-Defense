import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    //GreenfootImage menuBackground = new GreenfootImage("menu background 1200x900.png");
    GreenfootImage menuBackground = new GreenfootImage("chooseMap 1200x900.png");
    
    public MainMenu()
    {    
        super(1200, 900, 1); 
        setBackground(menuBackground);
        placeMenuButtons();
    }
    
    public void placeMenuButtons()
    {
        ChooseMap mapRoute = new ChooseMap();
        mapRoute.setImage(new GreenfootImage("Map route 320x450.png"));
        mapRoute.setName("Route");
        addObject(mapRoute, 250, 500);
        addObject(new ChooseMap(), 600, 500);
        addObject(new ChooseMap(), 950, 500);
        // addObject(new PlayButton(), 600, 700);
    }
}
