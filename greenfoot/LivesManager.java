import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesManager extends Actor
{
    private final int LIVES_MAX;
    private static int lives;
    
    public LivesManager()
    {
        this.LIVES_MAX = 100;
        this.lives = LIVES_MAX;
    }
    
    public static int getLives()
    {
        return lives;
    }
    
    public final int getLivesMax()
    {
        return LIVES_MAX;
    }
    
    public static void setLives(int live)
    {
        lives = live;
    }
}
