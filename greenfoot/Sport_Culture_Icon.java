import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sport_Culture_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sport_Culture_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon Sport&Culture 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon Sport&Culture mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("Sport&Culture 100x80.png");
    
    Sport_Culture_Placer sport_Culture_Placer = new Sport_Culture_Placer();
    
    InfoTower infoSport_Culture = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info Sport&Culture 200x183.png");
    
    int basicPrice = PriceManager.Prices.SPORT_CULTURE.getPrice(0, 0);
    
    public Sport_Culture_Icon()
    {
        setBasicPrice(basicPrice);
        infoSport_Culture.setImage(infoImage);
        infoSport_Culture.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfHovering(Icon, IconOn);
        showInfoIfHovering(infoSport_Culture);
        putShadow();
        if(Greenfoot.mousePressed(this))
        {
            createWhenClicked(sport_Culture_Placer, towerImg);
            //System.out.println(basicPrice);
        }
    }
}
