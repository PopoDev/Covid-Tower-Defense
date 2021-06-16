import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mask_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mask_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon masque 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon masque mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("Mask box 94x42.png");
    
    MaskBox_Placer maskBox_Placer = new MaskBox_Placer();
    
    InfoTower infoMask = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info Masques 200x177.png");
    
    int basicPrice = PriceManager.Prices.MASK.getPrice(0, 0);
    
    public Mask_Icon()
    {
        setBasicPrice(basicPrice);
        infoMask.setImage(infoImage);
        infoMask.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfOnTop(Icon, IconOn);
        showInfoIfHovering(infoMask);
        putShadow();
        if(Greenfoot.mousePressed(this) || artificialClicked)
        {
            createWhenClicked(maskBox_Placer, towerImg);
            artificialClicked = false;
        }
    }
}
