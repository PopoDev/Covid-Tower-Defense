import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChooseDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseDifficulty extends Buttons
{
    private String name;
    GreenfootImage image;
    GreenfootImage imageOn;
    
    public void act()
    {
        changeIfHovering(image, imageOn);
        if(Greenfoot.mouseClicked(this))
        {
            ((MainMenu)getWorld()).setDifficulty(name);
            ((MainMenu)getWorld()).chooseMap();
        }
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void initImage(GreenfootImage image)
    {
        this.image = image;
    }
    
    public void initImageOn(GreenfootImage image)
    {
        this.imageOn = image;
    }
}
