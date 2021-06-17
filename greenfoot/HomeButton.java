import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Buttons
{
    private GreenfootImage button = new GreenfootImage("home button 60x60.png");
    private GreenfootImage buttonOn = new GreenfootImage("home button 64x64 mouseOn.png");
    
    public void act() 
    {
        changeIfHovering(button, buttonOn);
        if(Greenfoot.mousePressed(this))
        {
            GameStateManager.gameState = GameStateManager.GameState.STARTMENU;
            GameStateManager.update(); 
        }
    }  
}
