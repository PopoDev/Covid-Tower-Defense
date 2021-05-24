import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersProjectile extends SmoothMover
{
    public Towers linkedTower;
    
    public void attack(Mobs mobs, int damage)
    {
        int currentHealth = mobs.getHealth();
        if(damage > currentHealth) damage = currentHealth;
        int damagedHealth = currentHealth - damage;
        mobs.setHealth(damagedHealth);
        Greenfoot.playSound("pop.mp3");
        
        linkedTower.addKills(damage);
    }
    
    public void setLinkedTower(Towers tower)
    {
        this.linkedTower = tower;
    }
}
