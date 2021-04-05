import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Disinfectant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant extends Towers
{
    int range = 150;
    int radius = range / 2;
    int cooldown = 300; // time relative to acts
    int counter = cooldown;
    
    public Disinfectant()
    {
        setRange(range);
    }
    
    public void act() 
    {
        showRange();
        if(counter == cooldown)
        {
            placeGel();
            counter = 0;
        }
        counter++;
    }
    
    public void placeGel()
    {
        if(getWorld() != null)
        {
            List <Roads> roads = getObjectsInRange(radius, Roads.class);
            
            if(!roads.isEmpty())
            {
                int i = Greenfoot.getRandomNumber(roads.size());
                
                int x = roads.get(i).getX();
                int y = roads.get(i).getY();
                
                while(x > getX() + range || y > getY() + range) // si le centre de la route est plus loin que la range
                {
                    roads.remove(i);
                    i = Greenfoot.getRandomNumber(roads.size());
                    
                    x = roads.get(i).getX();
                    y = roads.get(i).getY();
                }
                
                int posX = x + (Greenfoot.getRandomNumber(20) - 10); // écart de 10 pixels avec le centre de la route
                int posY = y + (Greenfoot.getRandomNumber(20) - 10);

                getWorld().addObject(new HydroalcoholicGel(), posX, posY);
                
                GreenfootSound splash = new GreenfootSound("splash2.mp3");
                splash.setVolume(25);
                splash.play();
            }
        }
    }
}
