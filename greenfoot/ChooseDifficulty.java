import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton permettant de choisir la difficulté.
 * 
 * @author PopoDev
 * @version 14.05.2021
 */
public class ChooseDifficulty extends Buttons
{
    private String name; // Difficulté
    GreenfootImage image;
    GreenfootImage imageOn;
    
    public void act()
    {
        changeIfHovering(image, imageOn);
        if(Greenfoot.mousePressed(this))
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
        setImage(image);
    }
    
    public void initImageOn(GreenfootImage image)
    {
        this.imageOn = image;
    }
}
