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
    
    public static int removeLives(int amount)
    {
        if(lives - amount > 0) {
            lives -= amount;
            System.out.println("Lost " + amount + " lives.");
        } else {
            lives = 0;
            System.out.println("You lost.");
        }
        return lives;
    }
}
