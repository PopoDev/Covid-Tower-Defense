import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeIcon extends HUD
{
    private GreenfootImage upgradeIcon;

    private Font font = new Font("Agency FB", true, false, 18);
    private Color initialColor = Color.WHITE;
    private Color upgradeColor = Color.GREEN;
    
    private String type;
    private int level;
    private int[] values;
    private String initialValue;
    private String upgradedValue;
    private boolean init = false;
    
    public UpgradeIcon()
    {
        level = 1;
        upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 1 180x70.png");
    }
    
    public void act()
    {
        if(!init) init();
    }
    
    public void setUpgradeType(String type)
    {
        this.type = type;
    }
    
    public void setUpgradeValues(int[] values)
    {
        this.values = values;
        initialValue = "" + values[level - 1];
        upgradedValue = "" + values[level];
    }
    
    public void init()
    {
        updateImage();
        updateText();
        init = true;
    }
    
    public void update()
    {
        level++;
        if(level < 5)
        {
            initialValue = "" + values[level - 1];
            upgradedValue = "" + values[level];
        } else {
            initialValue = "" + values[level - 1];
        }
        updateImage();
        updateText();
    }
    
    public void updateText()
    { 
        if(level < 5)
        {
            TextImage initialLevel = new TextImage("   " + type + " " + level + "   ", font, initialColor, null);
            upgradeIcon.drawImage(initialLevel, (getImage().getWidth() - initialLevel.getWidth())/ 2 - 32, 6);
            
            TextImage upgradeLevel = new TextImage("   " + type + " " + (level+1) + "   ", font, upgradeColor, null);
            upgradeIcon.drawImage(upgradeLevel, (getImage().getWidth() - upgradeLevel.getWidth())/ 2 + 56, 6);
            
            TextImage valueText1 = new TextImage("   " + initialValue + "   ", font, initialColor, null);
            upgradeIcon.drawImage(valueText1, (getImage().getWidth() - valueText1.getWidth())/ 2 - 32, 25);
            
            TextImage valueText2 = new TextImage("   " + upgradedValue + "   ", font, upgradeColor, null);
            upgradeIcon.drawImage(valueText2, (getImage().getWidth() - valueText2.getWidth())/ 2 + 56, 25);
            
        } else {
            TextImage initialLevel = new TextImage("   " + type + " " + level + "   ", font, initialColor, null);
            upgradeIcon.drawImage(initialLevel, (getImage().getWidth() - initialLevel.getWidth())/ 2 - 32, 6);
            
            TextImage maxLevel = new TextImage("   MAX   ", font, upgradeColor, null);
            upgradeIcon.drawImage(maxLevel, (getImage().getWidth() - maxLevel.getWidth())/ 2 + 56, 6);
            
            TextImage valueText1 = new TextImage("   " + initialValue + "   ", font, initialColor, null);
            upgradeIcon.drawImage(valueText1, (getImage().getWidth() - valueText1.getWidth())/ 2 - 32, 25);
            
            TextImage valueTextMax = new TextImage("   MAX   ", font, upgradeColor, null);
            upgradeIcon.drawImage(valueTextMax, (getImage().getWidth() - valueTextMax.getWidth())/ 2 + 56, 25);
        }
           
        setImage(upgradeIcon);
    }
    
    public void updateImage()
    {
        upgradeIcon.clear();
        switch(level)
        {
            case 1:
                upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 1 180x70.png");
                break;
            case 2:
                upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 2 180x70.png");
                break;
            case 3:
                upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 3 180x70.png");
                break;
            case 4:
                upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 4 180x70.png");
                break;
            case 5:
                upgradeIcon = new GreenfootImage("UpgradeIcons/Upgrade Icon 5 180x70.png");
                break;
            default:
                break;
        }
        upgradeIcon.setFont(font);
        upgradeIcon.setColor(Color.WHITE);
    }
}
