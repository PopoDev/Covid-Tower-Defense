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
        STARTMENU, MAINMENU, GAME, END
    }
    
    public static GameState gameState = GameState.STARTMENU;
    public static StartMenu startMenu;
    public static MainMenu mainMenu;
    public static Map1 map1;
    
    public static void update()
    {
        switch(gameState)
        {
            case STARTMENU:
                if(startMenu == null) startMenu = new StartMenu();
                break;
            case MAINMENU:
                if(mainMenu == null) mainMenu = new MainMenu();
                Greenfoot.setWorld(mainMenu);
                break;
            case GAME:
                map1 = new Map1();
                Greenfoot.setWorld(map1);
                resetData();
                break;
            default:
                break;
        }
    }
    
    public static void resetData()
    {
        LivesManager.lives = LivesManager.LIVES_MAX;
        MoneyManager.money = MoneyManager.STARTING_MONEY;
    }
}
