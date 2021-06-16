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
    
    InfoTower infoDisinfectant = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info Désinfectant 200x177.png");
    
    int basicPrice = PriceManager.Prices.DISINFECTANT.getPrice(0, 0);
    
    public Disinfectant_Icon()
    {
        setBasicPrice(basicPrice);
        infoDisinfectant.setImage(infoImage);
        infoDisinfectant.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfOnTop(Icon, IconOn);
        showInfoIfHovering(infoDisinfectant);
        putShadow();
        if(Greenfoot.mousePressed(this) || artificialClicked)
        {
            createWhenClicked(disinfectantPlacer, towerImg);
            artificialClicked = false;
        }
    }
}
