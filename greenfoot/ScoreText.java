import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreText extends HUD
{
    GreenfootImage textBox = new GreenfootImage(100, 50);
    Font scoreFont = new Font("Agency FB", true, false, 16);
    
    public ScoreText()
    {
        textBox.setFont(scoreFont);
        textBox.setColor(Color.WHITE);
        setImage(textBox);
    }
}
