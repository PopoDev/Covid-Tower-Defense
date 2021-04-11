import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
