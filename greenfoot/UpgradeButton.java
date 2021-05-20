import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Buttons
{
    private GreenfootImage upgradeButton = new GreenfootImage("Upgrade Button 110x22.png");
    private GreenfootImage upgradeButtonOn = new GreenfootImage("Upgrade Button 112x24 mouseOn.png");
    
    private Towers linkedTower = null;
    private String type;
    private int level;
    private int price;
    private int[] prices;
    private int initialPrice;
    private int upgradedPrice;
    private boolean updated = false;
    
    public UpgradeButton()
    {
        level = 1;
    }
    
    protected void addedToWorld(World world)
    {
        getImage().drawString("liufdashifuakshfdsja" + price, 10, 15);
    }
    
    public void act() 
    {
        changeIfHovering(upgradeButton, upgradeButtonOn);
        
        if(Greenfoot.mousePressed(this))
        {
            linkedTower.upgrade(type);
        }
    }
    
    public void setLinkedTower(Towers tower)
    {
        this.linkedTower = tower;
    }
    
    public void setUpgradeType(String type)
    {
        this.type = type;
    }
    
    public void setUpgradePrice(int price)
    {
        this.price = price;
    }
}
