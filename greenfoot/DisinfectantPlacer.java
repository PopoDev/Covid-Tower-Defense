import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisinfectantPlacer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisinfectantPlacer extends TowersPlacer
{
    int basicRange = 150;
    int basicPrice = 100;
    int price = basicPrice;
    
    public DisinfectantPlacer()
    {
        Towers disinfectant = new Disinfectant();
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
        }
    }
}
