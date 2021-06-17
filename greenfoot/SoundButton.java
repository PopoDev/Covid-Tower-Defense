import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoundButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundButton extends Buttons
{
    private GreenfootImage turnOnbutton = new GreenfootImage("soundOn button 60x60.png");
    private GreenfootImage turnOnbuttonOn = new GreenfootImage("soundOn button 64x64 mouseOn.png");
    
    private GreenfootImage turnOffbutton = new GreenfootImage("soundOff button 60x60.png");
    private GreenfootImage turnOffbuttonOn = new GreenfootImage("soundOff button 64x64 mouseOn.png");
    
    public static boolean soundOn = true;
    
    public SoundButton()
    {
        soundOn = true;
        setImage(turnOffbutton);
    }
    
    public void act() 
    {
        if(soundOn)
        {
            changeIfHovering(turnOffbutton, turnOffbuttonOn);
        } else {
            changeIfHovering(turnOnbutton, turnOnbuttonOn);
        }
        
        if(Greenfoot.mousePressed(this))
        {
            soundOn = !soundOn;
            if(soundOn)
            {
                setImage(turnOffbuttonOn);
            } else {
                setImage(turnOnbuttonOn);
            }
            
        }
    }    
}
