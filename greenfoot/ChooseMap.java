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
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            chooseMap();
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
    
}
