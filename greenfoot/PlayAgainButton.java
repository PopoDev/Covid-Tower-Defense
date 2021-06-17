import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends Buttons
{
    private GreenfootImage button = new GreenfootImage("Play Again 320x80.png");
    private GreenfootImage buttonOn = new GreenfootImage("Play Again 328x88 mouseOn.png");
    
    public void act() 
    {
        changeIfHovering(button, buttonOn);
        
        if(Greenfoot.mousePressed(this))
        {
            GameStateManager.gameState = GameStateManager.GameState.MAINMENU;
            GameStateManager.update();            
        }
    }    
}
