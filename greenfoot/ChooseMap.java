import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton permettant de choisir la map.
 * 
 * @author PopoDev
 * @version 14.05.2021
 */
public class ChooseMap extends Buttons
{
    private String name = "Soon";
    GreenfootImage image;
    GreenfootImage imageOn;
    
    public void act()
    {
        if(name != "Soon")
        {
            changeIfHovering(image, imageOn);
            if(Greenfoot.mousePressed(this))
            {
                ((MainMenu)getWorld()).setMap(name);
                ((MainMenu)getWorld()).chooseDifficulty();
            }
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
        setImage(image);
    }
    
    public void initImageOn(GreenfootImage image)
    {
        this.imageOn = image;
    }
}
