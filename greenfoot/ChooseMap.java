import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChooseMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
            if(Greenfoot.mouseClicked(this))
            {
                ((MainMenu)getWorld()).setMap(name);
                ((MainMenu)getWorld()).chooseDifficulty();
                //chooseMap();
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
    
    public void chooseMap()
    {
        switch(name.toUpperCase())
        {
            case "ROUTE":
                Greenfoot.setWorld(new MapRoute());
                break;
            
            default:
                break;
        }
    }
    
    public void chooseDifficulty()
    {
        getWorld().setBackground(new GreenfootImage("chooseDifficulty 1200x900.png"));
        getWorld().removeObjects(getWorld().getObjects(ChooseMap.class));
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
