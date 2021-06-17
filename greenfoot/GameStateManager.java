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
        STARTMENU, MAINMENU, ENDMENU_WIN, ENDMENU_LOSE;
    }
    
    public static GameState gameState = GameState.STARTMENU;
    public static StartMenu startMenu;
    public static MainMenu mainMenu;
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
            case ENDMENU_WIN:
                endMenu = new EndMenu();
                endMenu.setWinImage(true);
                Greenfoot.setWorld(endMenu);
                break;
            case ENDMENU_LOSE:
                endMenu = new EndMenu();
                endMenu.setWinImage(false);
                Greenfoot.setWorld(endMenu);
                break;
            default:
                break;
        }
    }
}
