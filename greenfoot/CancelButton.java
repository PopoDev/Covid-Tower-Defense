import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CancelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CancelButton extends Buttons
{
    private GreenfootImage cancelButton = new GreenfootImage("CancelBuy 386x86.png");
    private GreenfootImage cancelButtonOn = new GreenfootImage("CancelBuy 386x86 mouseOn.png");

    public void act()
    {
        changeIfOnTop(cancelButton, cancelButtonOn);
    }
}