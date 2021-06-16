import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vaccine_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vaccine_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon vaccin 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon vaccin mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("Vaccin 95x25 plein.png");
    
    Vaccine_Placer vaccinePlacer = new Vaccine_Placer();
    
    InfoTower infoVaccine = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info Vaccin 200x177.png");
    
    int basicPrice = PriceManager.Prices.VACCINE.getPrice(0, 0);
    
    public Vaccine_Icon()
    {
        setBasicPrice(basicPrice);
        infoVaccine.setImage(infoImage);
        infoVaccine.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfHovering(Icon, IconOn);
        showInfoIfHovering(infoVaccine);
        putShadow();
        if(Greenfoot.mousePressed(this) || artificialClicked)
        {
            createWhenClicked(vaccinePlacer, towerImg);
            artificialClicked = false;
        }
    }  
}
