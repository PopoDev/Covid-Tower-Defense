import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Integer;

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Buttons
{
    private GreenfootImage upgradeButton = new GreenfootImage("UpgradeButton 140x22 (8px).png");
    private GreenfootImage upgradeButtonOn = new GreenfootImage("UpgradeButton 142x24 mouseOn (8px).png");
    // Font upgradeFont = new Font("Gill Sans MT Gras", true, false, 14);
    Font upgradeFont = new Font("Berlin Sans FB Demi Gras", true, false, 16);
    
    private Towers linkedTower = null;
    private String type;
    private int level;
    private String price;
    private int[] prices;
    private boolean updated = false;
    
    public UpgradeButton()
    {
        level = 1;
    }
    
    protected void addedToWorld(World world)
    {
        upgradeButton.setFont(upgradeFont);
        upgradeButton.setColor(Color.WHITE);
        upgradeButton.drawString(price, 95, 15);
        upgradeButtonOn.setFont(upgradeFont);
        upgradeButtonOn.setColor(Color.WHITE);
        upgradeButtonOn.drawString(price, 97, 16);
        
        setImage(upgradeButton);
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this))
        {
            if(level < 5)
            {
                if(((Map)getWorld()).buyIfEnough(Integer.valueOf(price)))
                {
                    linkedTower.upgrade(type);
                    updateImage();
                }
            } else {
                System.out.println("Vous avez atteint le niveau maximal pour : " + type);
            }
        }
        changeIfHovering(upgradeButton, upgradeButtonOn);
    }
    
    public void setLinkedTower(Towers tower)
    {
        this.linkedTower = tower;
    }
    
    public void setUpgradeType(String type)
    {
        this.type = type;
    }
    
    public void setUpgradePrices(int[] prices)
    {
        this.prices = prices;
        this.price = "" + prices[level - 1];
    }
    
    public void updateImage()
    {
        upgradeButton.clear();
        upgradeButton = new GreenfootImage("UpgradeButton 140x22 (8px).png");
        upgradeButton.setFont(upgradeFont);
        upgradeButton.setColor(Color.WHITE);
        upgradeButton.drawString(price, 95, 15);

        upgradeButtonOn.clear();
        upgradeButtonOn = new GreenfootImage("UpgradeButton 142x24 mouseOn (8px).png");
        upgradeButtonOn.setFont(upgradeFont);
        upgradeButtonOn.setColor(Color.WHITE);
        upgradeButtonOn.drawString(price, 97, 16);

        setImage(upgradeButtonOn);
    }
    
    public void update()
    {
        level++;
        if(level < 5)
        {
            price = "" + prices[level - 1];
        } else {
            price = "###";
        }
    }
}
