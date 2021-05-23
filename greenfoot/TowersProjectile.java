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
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
        
        if(damagedHealth >= 0)
        {
            ((Map)getWorld()).addMoneyPerKill(damagedHealth);
        } else {
            ((Map)getWorld()).addMoneyPerKill(currentHealth);
        }
    }
}
