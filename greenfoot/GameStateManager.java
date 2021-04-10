import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameStateManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStateManager extends Actor
{
    public static enum GameState
    {
        STARTMENU, MAINMENU, GAME
    }
    
    public static GameState gameState;
    public static StartMenu startMenu;
    
    public static void update()
    {
        switch(gameState)
        {
            case STARTMENU:
                if(startMenu == null) startMenu = new StartMenu();
                break;
                
            default:
                break;
        }
    }
}
