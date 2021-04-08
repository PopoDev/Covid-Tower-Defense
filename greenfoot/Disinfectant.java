import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Math;

/**
 * Write a description of class Disinfectant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disinfectant extends Towers
{
    int range = 150; // diamètre
    int radius = range / 2; // rayon
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
                for(Roads road : roads)
                {
                    if(Math.abs(road.getX() - getX()) > radius || Math.abs(road.getY() - getY()) > radius)
                    {
                        roads.remove(road); // si le centre de la route est plus loin que le rayon
                    }
                }
                
                int i = Greenfoot.getRandomNumber(roads.size());
                
                int x = roads.get(i).getX();
                int y = roads.get(i).getY();
                
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
