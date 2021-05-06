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
    
    private int basicPrice = PriceManager.Prices.DISINFECTANT.getPrice(0);
    // private double multiplicator = ((Map)getWorld()).multiplicator;
    // private int price = (int)(basicPrice * multiplicator);
    
    private Towers disinfectant;
    
    public DisinfectantPlacer()
    {
        disinfectant = new Disinfectant();
        setTower(disinfectant);
        setBasicRange(basicRange);
        setBasicPrice(basicPrice);
    }
    
    public void act() 
    {
        showPlacingRange();
        followMouse();
        isPlaceable();
        showIfPlaceable();
        if(Greenfoot.mouseClicked(this))
        {
            placeTower();
            disinfectant = new Disinfectant();
            setTower(disinfectant);
        }
    }
}
