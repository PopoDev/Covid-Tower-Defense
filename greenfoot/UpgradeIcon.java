import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeIcon extends HUD
{
    private GreenfootImage upgradeIcon = new GreenfootImage("IconUpgrade 175x70.png");
    
    private Font font = new Font("Agency FB", true, false, 14);
    
    private String type;
    private String adjustedText; // Pour centrer le texte
    private int level;
    
    public UpgradeIcon()
    {
        level = 1;
    }
    
    @Override
    protected void addedToWorld(World world)
    {      
        upgradeIcon.setFont(font);
        upgradeIcon.setColor(Color.WHITE);
        
        int spaces = (8 - type.length()) - 1; // Plus long type "Cooldown" 8 character
        if(spaces >= 0) 
        {
            adjustedText = " ".repeat(spaces) + type;
        
            upgradeIcon.drawString(adjustedText + " " + level, 32, 19);
            upgradeIcon.setColor(Color.GREEN);
            upgradeIcon.drawString(adjustedText + " " + (level + 1), 115, 19); 
        } else {
            upgradeIcon.drawString(type + " " + level, 32, 19);
            upgradeIcon.setColor(Color.GREEN);
            upgradeIcon.drawString(type + " " + (level + 1), 115, 19);
        }
        /*
        GreenfootImage textBox1 = new GreenfootImage(type + " " + level, 13, Color.WHITE, null);
        upgradeIcon.drawImage(textBox1, 34, 8);
        
        GreenfootImage textBox2 = new GreenfootImage(type + " " + (level + 1), 13, Color.GREEN, null);
        upgradeIcon.drawImage(textBox2, 115, 8);
        */
       
        setImage(upgradeIcon);
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void setUpgradeType(String type)
    {
        this.type = type;
    }
    
    /*
    public void setUpgradeType(String type, String digit1, String digit2)
    {
        switch(type.toUpperCase())
        {
            case "DAMAGE" :
                upgradeIcon.drawString(type + " " + digit1, 0, 0);
                break;
            
            default:
                break;
        }
    }
    */
}
