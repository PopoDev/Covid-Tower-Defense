import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersProjectile extends SmoothMover
{
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        int damagedHealth = currentHealth - damage;
        if(damagedHealth <= 0) damagedHealth = 0;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
    }
}
