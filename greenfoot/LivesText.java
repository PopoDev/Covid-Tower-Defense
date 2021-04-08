import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesText extends HUD
{
    GreenfootImage textBox = new GreenfootImage(80, 50);
    
    Font healthFont = new Font("Agency FB", true, false, 30);
    // Font healthFont = new Font("Chewy", false, false, 30);
    // Font healthFont = new Font("Black Ops One Regular", false, false, 30);
    // Font healthFont = new Font("Oetztype", false, false, 30);
    
    private int lives;
    LivesManager livesManager = new LivesManager();
    
    public LivesText()
    {
        textBox.setFont(healthFont);
        textBox.setColor(Color.WHITE);
        textBox.drawString(String.valueOf(livesManager.getLivesMax()), 42, 38);
        setImage(textBox);
        // System.out.println(healthIcon.getFont());
    }
    
    public void act() 
    {
        textBox.clear();
        textBox.drawString(String.valueOf(livesManager.getLives()), 42, 38);
        setImage(textBox);
    }
    
    public int getLives()
    {
        return livesManager.getLives();
    }
    
    public void setLives(int lives)
    {
        livesManager.setLives(lives);
    }
}
