import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * Image source : Designed by starline / Freepik and edited by PopoDev
 */
public class TowersIcon extends HUD
{   
    public static IconBox specificIcon;
    public static Towers specificTower;
    
    public void createWhenClicked(GreenfootImage TowerImg)
    {
        System.out.println("Clicked on : " + this);
        specificIcon = new IconBox(); // Create new Instance only when clicked
        specificIcon.setImage(TowerImg);
        getWorld().addObject(specificIcon, getX(), getY());
        // getWorld().addObject(this, Greenfoot.getRandomNumber(700) + 50, Greenfoot.getRandomNumber(700) + 50);
    }
    
    public void followMouse()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null && specificIcon != null) specificIcon.setLocation(mouseInfo.getX(), mouseInfo.getY());
    }
    
    public void placeTower()
    {
        if(!isTouching(Roads.class) && !isTouching(HUD.class))
        {
            System.out.println("Not on road nor HUD");
            if(specificTower != null && specificIcon != null)
            {
                System.out.println(specificTower + " placed at : (" + specificIcon.getX() + ", " + specificIcon.getY() + ").");
                specificIcon.getWorld().addObject(specificTower, specificIcon.getX(), specificIcon.getY());
                System.out.println(specificIcon + " was removed.");
                getWorld().removeObject(specificIcon);
            }
        } else {
            System.out.println("You can't place towers on the roads and outside of the map.");
        }
    }
    
    public void setTower(Towers tower)
    {
        this.specificTower = tower;
    }
}