import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Mobs
{
    private int tier = 0;
    
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
            int amount = getTier() - getHealth();
            addMoneyPerKill(amount);
            
            getWorld().removeObject(this);
        }
    }
    
    public void replaceTier(int x, int y)
    {
        int rotation = getRotation();
        switch(getHealth())
        {
            case 1:
                Tier1 tier1 = new Tier1();
                getWorld().addObject(tier1, x, y);
                tier1.setRotation(rotation);
                break;
            case 2:
                Tier2 tier2 = new Tier2();
                getWorld().addObject(tier2, x, y);
                tier2.setRotation(rotation);
                break;
            case 3:
                Tier3 tier3 = new Tier3();
                getWorld().addObject(tier3, x, y);
                tier3.setRotation(rotation);
                break;
            case 4:
                Tier4 tier4 = new Tier4();
                getWorld().addObject(tier4, x, y);
                tier4.setRotation(rotation);
                break;
            case 5:
                Tier5 tier5 = new Tier5();
                getWorld().addObject(tier5, x, y);
                tier5.setRotation(rotation);
                break;
            default:
                // System.out.println(getClass() + " got killed");
                break;
        }
    }
    
    public void attackLives()
    {
        int livesLoosed = tier;
        ((Map)getWorld()).removeLives(livesLoosed);
        getWorld().removeObject(this);
    }
    
    public void addMoneyPerKill(int amount)
    {
        int value = amount * ((Map)getWorld()).getMoneyPerKill();
        ((Map)getWorld()).addMoney(value);
    }
}