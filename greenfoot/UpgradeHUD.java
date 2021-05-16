import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeHUD extends HUD
{
    private int score;
    
    Font scoreFont = new Font("Agency FB", true, false, 15);
    
    GreenfootImage textBox = new GreenfootImage(200, 40);
    //GreenfootImage scoreBox = new GreenfootImage(200, 40);
    
    public UpgradeHUD()
    {
        score = 0;
        textBox.setColor(Color.WHITE);
        textBox.setFont(scoreFont);
        textBox.drawString("Virus killed : \n" + score, 50, 20);
        getImage().drawImage(textBox, 100, 20);
    }
    
    public void act()
    {
        textBox.clear();
        textBox.drawString("Virus killed : \n" + score, 50, 20);
        getImage().drawImage(textBox, 100, 20);
        score++;
    }
}
