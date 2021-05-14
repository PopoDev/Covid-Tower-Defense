import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
