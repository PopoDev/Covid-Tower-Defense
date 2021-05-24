import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disinfectant_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon désinfectant 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon désinfectant mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("Désinfectant 50x50.png");
    
    Disinfectant_Placer disinfectantPlacer = new Disinfectant_Placer();
    InfoDisinfectant infoDisinfectant = new InfoDisinfectant();
    
    int basicPrice = PriceManager.Prices.DISINFECTANT.getPrice(0, 0);
    
    public Disinfectant_Icon()
    {
        setBasicPrice(basicPrice);
    }

    public void act()
    {
        changeIfHovering(Icon, IconOn);
        showInfoIfHovering(infoDisinfectant);
        putShadow();
        if(Greenfoot.mousePressed(this))
        {
            createWhenClicked(disinfectantPlacer, towerImg);
            //System.out.println(basicPrice);
        }
    }
}
