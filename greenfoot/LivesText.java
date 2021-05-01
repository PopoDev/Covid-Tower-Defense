import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesText extends HUD
{
    GreenfootImage textBox = new GreenfootImage(90, 51);
    
    Font healthFont = new Font("Agency FB", true, false, 30);
    // Font healthFont = new Font("Chewy", false, false, 30);
    // Font healthFont = new Font("Black Ops One Regular", false, false, 30);
    // Font healthFont = new Font("Oetztype", false, false, 30);
    
    boolean init = false;
    
    public LivesText()
    {
        textBox.setFont(healthFont);
        textBox.setColor(Color.WHITE);
        setImage(textBox);
        // System.out.println(healthIcon.getFont());
    }
    
    public void act() 
    {
        if(!init) init();
        textBox.clear();
        textBox.drawString(String.valueOf(((Map)getWorld()).lives), 42, 38);
        setImage(textBox);
    }
    
    public void init()
    {
        textBox.drawString(String.valueOf(((Map)getWorld()).lives), 42, 38);
        init = true;
    }
}
