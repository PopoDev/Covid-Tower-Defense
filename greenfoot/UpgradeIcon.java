import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeIcon extends HUD
{
    private GreenfootImage upgradeIcon = new GreenfootImage("IconUpgrade 180x70.png");
    
    private Font font = new Font("Agency FB", true, false, 14);
    
    private String type;
    private String textAligner = " ".repeat(20);
    private String adjustedText; // Pour centrer le texte
    private int level;
    private int value1;
    private int value2;
    
    public UpgradeIcon()
    {
        level = 1;
    }
    
    @Override
    protected void addedToWorld(World world)
    {      
        upgradeIcon.clear();
        upgradeIcon = new GreenfootImage("IconUpgrade 180x70.png");
        upgradeIcon.setFont(font);
        upgradeIcon.setColor(Color.WHITE);
        
        int spaces = 8 - type.length(); // Plus long type "Cooldown" 8 character
        adjustedText = " ".repeat(spaces) + type;
        
        upgradeIcon.drawString(adjustedText + " " + level, 32, 19);
        
        upgradeIcon.setColor(Color.GREEN);
        upgradeIcon.drawString(adjustedText + " " + (level + 1), 115, 19); 
        
        GreenfootImage textBox1 = new GreenfootImage(textAligner + "\n" + value1, 18, Color.WHITE, null);
        upgradeIcon.drawImage(textBox1, 20, 6);
        
        GreenfootImage textBox2 = new GreenfootImage(textAligner + "\n" + value2, 18, Color.GREEN, null);
        upgradeIcon.drawImage(textBox2, 105, 6);
       
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
    
    public void setUpgradeValues(int value1, int value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }
}
