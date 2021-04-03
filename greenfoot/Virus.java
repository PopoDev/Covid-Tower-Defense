
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Mobs
{
    int tier = 0;
    
    public int getTier()
    {
        return this.tier;
    }
    
    public void setTier(int tier)
    {
        this.tier = tier;
    }
    
    public void changeTier()
    {
        if(getHealth() != getTier())
        {
            int x = getX();
            int y = getY();
            replaceTier(x, y);
            
            getWorld().removeObject(this);
        }
    }
    
    public void replaceTier(int x, int y)
    {
        switch(getHealth())
        {
            case 1:
                getWorld().addObject(new Tier1(), x, y);
                break;
            case 2:
                getWorld().addObject(new Tier2(), x, y);
                break;
            //case 3:
                //getWorld().addObject(new Tier3(), x, y);
                //break;
            default:
                break;
        }
    }
}