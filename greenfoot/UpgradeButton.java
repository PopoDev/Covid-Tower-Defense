import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Buttons
{
    private GreenfootImage upgradeButton = new GreenfootImage("UpgradeButton 140x22.png");
    private GreenfootImage upgradeButtonOn = new GreenfootImage("UpgradeButton 142x24 mouseOn.png");
    // Font upgradeFont = new Font("Gill Sans MT Gras", true, false, 14);
    Font upgradeFont = new Font("Berlin Sans FB Demi Gras", true, false, 19);
    
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
        upgradeButton.setFont(upgradeFont);
        upgradeButton.setColor(Color.WHITE);
        upgradeButton.drawString("" + price, 95, 16);
        upgradeButtonOn.setFont(upgradeFont);
        upgradeButtonOn.setColor(Color.WHITE);
        upgradeButtonOn.drawString("" + price, 97, 17);
        
        setImage(upgradeButton);
    }
    
    public void act() 
    {
        changeIfHovering(upgradeButton, upgradeButtonOn);
        
        if(Greenfoot.mousePressed(this))
        {
            linkedTower.upgrade(type);
            updateImage();
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
    
    public void updateImage()
    {
        upgradeButton.clear();
        upgradeButton = new GreenfootImage("UpgradeButton 140x22.png");
        upgradeButton.setFont(upgradeFont);
        upgradeButton.setColor(Color.WHITE);
        upgradeButton.drawString("" + price, 95, 16);
        
        upgradeButtonOn.clear();
        upgradeButtonOn = new GreenfootImage("UpgradeButton 142x24 mouseOn.png");
        upgradeButtonOn.setFont(upgradeFont);
        upgradeButtonOn.setColor(Color.WHITE);
        upgradeButtonOn.drawString("" + price, 97, 17);
        
        setImage(upgradeButtonOn);
    }
}
