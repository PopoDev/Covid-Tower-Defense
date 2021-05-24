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
    private boolean needUpdate = false;
    
    private ScoreText scoreText;
    
    public UpgradeHUD()
    {
        score = 0;
        scoreText = new ScoreText();
    }
    
    protected void addedToWorld(World world)
    {
        getWorld().addObject(scoreText, 140, 875);
        scoreText.getImage().clear();
        scoreText.getImage().drawString("Virus killed : \n" + score, 10, 10);
    }
    
    public void act()
    {
        if(needUpdate) updateScoreText();
    }
    
    public void updateScore(int kills)
    {
        score = kills;
        needUpdate = true;
    }
    
    public void updateScoreText()
    {
        scoreText.getImage().clear();
        scoreText.getImage().drawString("Virus killed : \n" + score, 10, 10);
        needUpdate = false;
    }
    
    public void removeScoreText()
    {
        getWorld().removeObject(scoreText);
    }
}
