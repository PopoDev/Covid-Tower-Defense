import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower1M50Placer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower1M50_Placer extends TowersPlacer
{
    private int basicRange = 100;
    private int basicPrice = PriceManager.Prices.M50.getPrice(0, 0);
    
    private Towers tower1M50;
    
    public Tower1M50_Placer()
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
                tower1M50 = new Tower1M50();
                setTower(tower1M50);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }  
}
