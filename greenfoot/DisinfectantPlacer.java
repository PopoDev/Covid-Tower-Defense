import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisinfectantPlacer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisinfectantPlacer extends TowersPlacer
{
    private int basicRange = 150;
    
    private int basicPrice = PriceManager.Prices.DISINFECTANT.getPrice(0, 0);
    // private double multiplicator = ((Map)getWorld()).multiplicator;
    // private int price = (int)(basicPrice * multiplicator);
    
    private Towers disinfectant;
    
    public DisinfectantPlacer()
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
                disinfectant = new Disinfectant();
                setTower(disinfectant);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }
}
