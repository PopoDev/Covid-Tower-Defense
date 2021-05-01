import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameStateManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStateManager
{
    public static enum GameState
    {
        STARTMENU, MAINMENU, GAME, END;
    }
    
    public static GameState gameState = GameState.STARTMENU;
    public static StartMenu startMenu;
    public static MainMenu mainMenu;
    public static MapRoute mapRoute;
    public static EndMenu endMenu;
    
    public static void update()
    {
        switch(gameState)
        {
            case STARTMENU:
                if(startMenu == null) startMenu = new StartMenu();
                break;
            case MAINMENU:
                mainMenu = new MainMenu();
                Greenfoot.setWorld(mainMenu);
                break;
            case GAME:
                // map1 = new Map1();
                // Greenfoot.setWorld(map1);
                break;
            case END:
                
                break;
            default:
                break;
        }
    }
}
