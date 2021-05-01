import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class TowersIcon extends Buttons
{   
    boolean setInfo = false;
    HUD infoBox;
    
    int money;
    int basicPrice;
    
    boolean setShadow = false;
    
    public void createWhenClicked(TowersPlacer towerPlacer, GreenfootImage TowerImg)
    {
        // Create new Instance only when clicked for selecting
        System.out.println("Clicked on : " + this);
        
        if(canAfford())
        {
            getWorld().addObject(towerPlacer, getX(), getY());
        } else {
            System.out.println("You can't afford this. (Money : " + money + "; Price : " + basicPrice + ")");
        }
    }
    
    public void showInfoIfHovering(HUD infoTower)
    {
        if(isHovering() && !setInfo)
        {
            infoBox = infoTower;
            getWorld().addObject(infoBox, 700, getY());
            setInfo = true;
        }
        
        if(!isHovering() && setInfo)
        {
            getWorld().removeObject(infoBox);
            setInfo = false;
        }
    }
    
    public void setBasicPrice(int basicPrice)
    {
        this.basicPrice = basicPrice;
    }
    
    public boolean canAfford()
    {
        money = ((Map)getWorld()).money;
        if(money >= basicPrice)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public void putShadow()
    {
        if(!canAfford() && !setShadow)
        {
            getWorld().addObject(new IconShadow(), getX(), getY());
            setShadow = true;
        }
        
        if(canAfford() && setShadow)
        {
            removeTouching(IconShadow.class);
            setShadow = false;
        }
    }
}