import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower1M50_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower1M50_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon 1M50 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon 1M50 mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("1M50 45x45.png");
    
    Tower1M50_Placer tower1M50_Placer = new Tower1M50_Placer();
    // INFO
    
    int basicPrice = PriceManager.Prices.M50.getPrice(0, 0);
    
    public Tower1M50_Icon()
    {
        setBasicPrice(basicPrice);
    }

    public void act()
    {
        changeIfHovering(Icon, IconOn);
        //showInfoIfHovering();
        putShadow();
        if(Greenfoot.mousePressed(this))
        {
            createWhenClicked(tower1M50_Placer, towerImg);
            //System.out.println(basicPrice);
        }
    }
}
