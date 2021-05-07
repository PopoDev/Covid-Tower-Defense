import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaveText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveText extends HUD
{
    GreenfootImage textBox = new GreenfootImage(200, 51);
    
    Font waveFont = new Font("Agency FB", true, false, 34);
    
    public WaveText()
    {
        textBox.setFont(waveFont);
        textBox.setColor(Color.CYAN);
        setImage(textBox);
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    @Override
    protected void addedToWorld(World world)  
    {
        textBox.drawString("99 / 99", 105, 34);
    }
}
