import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersPlacer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersPlacer extends SmoothMover
{
    Towers specificTower = null;
    boolean placeable = false;
    int price = 0;
    
    RangeIcon rangeIcon = null;
    int basicRange = 100;
    
    GreenfootImage rangeTrueImg = new GreenfootImage("Range 100x100 (5.0).png");
    GreenfootImage rangeFalseImg = new GreenfootImage("Range false 100x100 (5.0).png");
    
    public void followMouse()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();

        if(mouseInfo != null)
        {
            setLocation(mouseInfo.getX(), mouseInfo.getY());
            rangeIcon.setLocation(mouseInfo.getX(), mouseInfo.getY());
        }
    }
    
    public void placeTower()
    {
        if(placeable)
        {
            // System.out.println("Not on road, HUD or other towers");
            if(((Map)getWorld()).buyIfEnough(price))
            {
                System.out.println(specificTower + " placed at : (" + getX() + ", " + getY() + ").");
                getWorld().addObject(specificTower, getX(), getY());
                //System.out.println(rangeIcon + " was removed.");
                //System.out.println(this + " was removed.");
                getWorld().removeObject(rangeIcon);
                getWorld().removeObject(this);
                rangeIcon = null;
            }
        }
    }
    
    public void setTower(Towers tower)
    {
        this.specificTower = tower;
    }
    
    public void showPlacingRange()
    {
        if(getWorld() != null && rangeIcon == null)
        {
            rangeIcon = new RangeIcon();
            getWorld().addObject(rangeIcon, getX(), getY());
        }
    }
    
    public void setBasicRange(int range)
    {
        this.basicRange = range;
    }
    
    public int getBasicRange()
    {
        return basicRange;
    }
    
    public boolean isPlaceable()
    {
        if(!isTouching(Roads.class) && !isTouching(Towers.class) && !isTouching(HUD.class))
        {
            placeable = true;
        } else {
            placeable = false;
        }
        return placeable;
    }
    
    public void showIfPlaceable()
    {
        if(placeable)
        {
            rangeIcon.setImage(rangeTrueImg);
            rangeIcon.getImage().scale(basicRange, basicRange);
        } else {
            rangeIcon.setImage(rangeFalseImg);
            rangeIcon.getImage().scale(basicRange, basicRange);
        }
    }
    
    public void setBasicPrice(int amount)
    {
        this.price = amount;
    }
        
    public int getPrice()
    {
        return price;
    }
}
