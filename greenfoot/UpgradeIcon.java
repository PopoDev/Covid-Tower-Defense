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
    private String textAligner = new String(new char[20]).replace("\0", " ");
    private String adjustedText; // Pour centrer le texte
    private int level;
    private int[] values;
    private String initialValue;
    private String upgradedValue;
    private boolean updatedText = false;
    
    public UpgradeIcon()
    {
        level = 1;
    }
    
    public void act()
    {
        if(!updatedText)
        {
            upgradeIcon.clear();
            upgradeIcon = new GreenfootImage("IconUpgrade 180x70.png");
            upgradeIcon.setFont(font);
            upgradeIcon.setColor(Color.WHITE);
            
            int spaces = 8 - type.length(); // Plus long type "Cooldown" 8 character
            String textSpacer = new String(new char[spaces]).replace("\0", " ");
            adjustedText = textSpacer + type;
            
            if(level < 5)
            {
                upgradeIcon.drawString(adjustedText + " " + level, 30, 19);
            
                upgradeIcon.setColor(Color.GREEN);
                upgradeIcon.drawString(adjustedText + " " + (level + 1), 115, 19);
                
                GreenfootImage textBox1 = new GreenfootImage(textAligner + "\n" + initialValue, 18, Color.WHITE, null);
                upgradeIcon.drawImage(textBox1, 10, 6);
            
                GreenfootImage textBox2 = new GreenfootImage(textAligner + "\n" + upgradedValue, 18, Color.GREEN, null);
                upgradeIcon.drawImage(textBox2, 90, 6);
            } else {
                upgradeIcon.drawString(adjustedText + " " + level, 30, 19);
            
                upgradeIcon.setColor(Color.GREEN);
                upgradeIcon.drawString("MAX", 136, 19);
                upgradeIcon.drawString("MAX", 136, 38);
                
                GreenfootImage textBox1 = new GreenfootImage(textAligner + "\n" + initialValue, 18, Color.WHITE, null);
                upgradeIcon.drawImage(textBox1, 10, 6);
            }
            
            
            setImage(upgradeIcon);
            
            updatedText = true;
        }
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
        updatedText = false;
    }
}
