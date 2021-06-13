import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton pour commencer le jeu.
 * 
 * @author PopoDev
 * @version 05.05.2021
 */
public class StartButton extends Buttons
{
    GreenfootImage startButton = new GreenfootImage("playButton 400x66.png");
    GreenfootImage startButtonOn = new GreenfootImage("playButton mouseOn 440x73.png");
    
    public void act() 
    {
        changeIfHovering(startButton, startButtonOn);
        if(Greenfoot.mousePressed(this))
        {
            GameStateManager.gameState = GameStateManager.GameState.MAINMENU;
            GameStateManager.update();
        }
    }    
}
