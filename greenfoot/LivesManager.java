import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesManager extends Actor
{
    public final static int LIVES_MAX = 100;
    public static int lives = LIVES_MAX;
    
    public LivesManager()
    {
        lives = LIVES_MAX;
    }
}
