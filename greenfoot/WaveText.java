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
    
    Map map;
    
    public WaveText()
    {
        textBox.setFont(waveFont);
        textBox.setColor(Color.CYAN);
        setImage(textBox);
    }
    
    public void act() 
    {
        textBox.clear();
        textBox.drawString(map.waveNumber + " / " + map.waveMax, 105, 34);
    }
    
    @Override
    protected void addedToWorld(World world)  
    {
        map = (Map)getWorld();
        textBox.drawString(map.waveNumber + " / " + map.waveMax, 105, 34);
    }
}
