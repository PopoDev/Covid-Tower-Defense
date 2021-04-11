import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Buttons
{
    GreenfootImage startButton = new GreenfootImage("playButton 400x66.png");
    GreenfootImage startButtonOn = new GreenfootImage("playButton mouseOn 440x73.png");
    
    public void act() 
    {
        changeIfHovering(startButton, startButtonOn);
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Map1());
            GameStateManager.gameState = GameStateManager.GameState.MAINMENU;
        }
    }    
}
