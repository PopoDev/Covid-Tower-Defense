import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyText extends HUD
{
    GreenfootImage textBox = new GreenfootImage(150, 51);
    
    Font moneyFont = new Font("Agency FB", true, false, 30);
    // Font healthFont = new Font("Chewy", false, false, 30);
    // Font healthFont = new Font("Black Ops One Regular", false, false, 30);
    // Font healthFont = new Font("Oetztype", false, false, 30);
    
    boolean init = false;
    
    public MoneyText()
    {
        textBox.setFont(moneyFont);
        textBox.setColor(Color.WHITE);
        setImage(textBox);
    }
    
    public void act() 
    {
        if(!init) init();
    }
        
    public void init()
    {
        map.setMoneyText(this);
        textBox.drawString(String.valueOf(map.money), 30, 38);
        init = true;
    }
    
    public void updateMoneyText()
    {
        textBox.clear();
        textBox.drawString(String.valueOf(map.money), 30, 38);
        // System.out.println("Money updated.");
    }
} 
