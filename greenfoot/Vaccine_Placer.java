import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vaccine_Placer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vaccine_Placer extends TowersPlacer
{
    private int basicRange = 600;
    private int basicPrice = PriceManager.Prices.VACCINE.getPrice(0, 0);
    
    private Towers vaccine;
    
    public Vaccine_Placer()
    {
        setBasicRange(basicRange);
        setBasicPrice(basicPrice);
    }
    
    public void act() 
    {
        showPlacingRange();
        followMouse();
        isPlaceable();
        showIfPlaceable();
        if(Greenfoot.mousePressed(this))
        {
            if(placeable)
            {
                vaccine = new Vaccine();
                setTower(vaccine);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    } 
}
