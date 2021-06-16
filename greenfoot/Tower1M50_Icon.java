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
    
    InfoTower info1M50 = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info 1M50 200x167.png");
    
    int basicPrice = PriceManager.Prices.M50.getPrice(0, 0);
    
    public Tower1M50_Icon()
    {
        setBasicPrice(basicPrice);
        info1M50.setImage(infoImage);
        info1M50.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfOnTop(Icon, IconOn);
        showInfoIfHovering(info1M50);
        putShadow();
        if(Greenfoot.mousePressed(this) || artificialClicked)
        {
            createWhenClicked(tower1M50_Placer, towerImg);
            artificialClicked = false;
        }
    }
}
