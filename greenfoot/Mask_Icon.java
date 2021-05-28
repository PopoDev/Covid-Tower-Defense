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
    // INFO
    
    int basicPrice = PriceManager.Prices.MASK.getPrice(0, 0);
    
    public Mask_Icon()
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
            createWhenClicked(maskBox_Placer, towerImg);
        }
    }
}