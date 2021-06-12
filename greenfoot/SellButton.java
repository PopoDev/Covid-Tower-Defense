import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SellButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SellButton extends Buttons
{
    private GreenfootImage sellButton = new GreenfootImage("SellButton 70x30.png");
    private GreenfootImage sellButtonOn = new GreenfootImage("SellButton 72x32 mouseOn.png");
    
    private Towers linkedTower = null;
    private int towerPrice;
    private int sellPrice;
    
    Font sellFont = new Font("Berlin Sans FB Demi Gras", true, false, 16);
    
    @Override
    public void addedToWorld(World world)
    {
        GreenfootImage textImage = new GreenfootImage("" + linkedTower.towerPrice);
        textImage.setFont(sellFont);
        textImage.setColor(Color.WHITE);
        getImage().drawImage(textImage, (getImage().getWidth() - textImage.getWidth()) / 2, 20);
    }
    
    public void act()
    {
        changeIfHovering(sellButton, sellButtonOn);
    }
    
    public void setLinkedTower(Towers tower)
    {
        this.linkedTower = tower;
    }
}
