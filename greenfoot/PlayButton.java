import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton pour commencer à jouer.
 * 
 * @author PopoDev
 * @version 05.05.2021
 */
public class PlayButton extends Buttons
{
    GreenfootImage playButton = new GreenfootImage("playButton 400x66.png");
    GreenfootImage playButtonOn = new GreenfootImage("playButton mouseOn 440x73.png");
    
    public void act() 
    {
        changeIfHovering(playButton, playButtonOn);
        if(Greenfoot.mousePressed(this))
        {
            GameStateManager.gameState = GameStateManager.GameState.GAME;
            GameStateManager.update();
        }
    }     
}
