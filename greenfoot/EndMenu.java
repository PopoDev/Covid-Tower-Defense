import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La classe EndMenu gère l'écran de fin.
 * 
 * @author PopoDev
 * @version 12.04.2021
 */
public class EndMenu extends World
{
    GreenfootImage victoryImg = new GreenfootImage("Victoire 1200x900 V2.png");
    GreenfootImage defeatImg = new GreenfootImage("Defeat 1200x900 V2.png");
    
    GreenfootImage image = null;
    boolean imgSet = false;
    
    public EndMenu()
    {    
        super(1200, 900, 1);
        
        PlayAgainButton playAgainButton = new PlayAgainButton();
        addObject(playAgainButton, 600, 500);
    }
    
    public void act()
    {
        if(!imgSet) setBackground(image);
        imgSet = true;
    }
    
    /**
     * Affiche une image de fin en cas de victoire ou de défaite.
     */
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
