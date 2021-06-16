import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteCell_Icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteCell_Icon extends TowersIcon
{
    GreenfootImage Icon = new GreenfootImage("TowersIcon Globule blanc 100x100.png");
    GreenfootImage IconOn = new GreenfootImage("TowersIcon Globule blanc mouseOn 100x100.png");
    
    GreenfootImage towerImg = new GreenfootImage("Globule blanc 46x48.png");
    
    WhiteCell_Placer whiteCell_Placer = new WhiteCell_Placer();
    
    InfoTower infoWhiteCell = new InfoTower();
    GreenfootImage infoImage = new GreenfootImage("InfoTower/Info Globule Blanc 200x170.png");
    
    int basicPrice = PriceManager.Prices.WHITECELL.getPrice(0, 0);
    
    public WhiteCell_Icon()
    {
        setBasicPrice(basicPrice);
        infoWhiteCell.setImage(infoImage);
        infoWhiteCell.setPrice(basicPrice);
    }

    public void act()
    {
        changeIfOnTop(Icon, IconOn);
        showInfoIfHovering(infoWhiteCell);
        putShadow();
        if(Greenfoot.mousePressed(this) || artificialClicked)
        {
            createWhenClicked(whiteCell_Placer, towerImg);
            artificialClicked = false;
        }
    }    
}
