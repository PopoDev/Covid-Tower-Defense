import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends Actor
{
    public void act() 
    {
        // Add your action code here.
    }
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        System.out.println(currentHealth);
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound(_soundFile_)
    }
}
