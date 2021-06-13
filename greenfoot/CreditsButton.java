import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton redirigeant vers les credits / sources.
 * 
 * @author PopoDev
 * @version 05.05.2021
 */
public class CreditsButton extends Buttons
{
    GreenfootImage creditsButton = new GreenfootImage("creditsButton 400x66.png");
    GreenfootImage creditsButtonOn = new GreenfootImage("creditsButton mouseOn 440x73.png");
    public void act() 
    {
        changeIfHovering(creditsButton, creditsButtonOn);
    }    
}
