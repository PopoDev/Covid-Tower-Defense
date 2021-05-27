import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mask extends TowersProjectile
{
    private int counter = 0;
    private int delay;
    
    Font font = new Font("Agency FB", true, false, 13);
    
    public void act()
    {
        if(counter % 10 == 0)
        {
            drawDelay();
        }
        
        if(counter >= delay)
        {
            getWorld().removeObject(this);
        }
        counter++;
    }
    
    public void setDelay(int delay)
    {
        this.delay = delay;
    }
    
    public void drawDelay()
    {
        int time = delay - counter;
        
        getImage().clear();
        GreenfootImage image = new GreenfootImage("Masque 50x17.png");
        setImage(image);
        image.setFont(font);
        
        int spaces = 0;
        if(time >= 1000) image.setColor(Color.GREEN);
        if(time < 1000 && delay >= 100)
        {
            image.setColor(Color.ORANGE);
            spaces = 1;
        }
        if(time < 100)
        {
            image.setColor(Color.RED);
            spaces = 2;
        }
        
        String textSpacer = new String(new char[spaces]).replace("\0", " ");
        image.drawString(textSpacer + (time), 14, 13);
    }
}
