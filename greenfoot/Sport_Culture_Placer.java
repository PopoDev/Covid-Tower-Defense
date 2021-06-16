import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sport_Culture_Placer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sport_Culture_Placer extends TowersPlacer
{
    private int basicRange = 80;
    private int basicPrice = PriceManager.Prices.SPORT_CULTURE.getPrice(0, 0);
    
    private Towers Sport_Culture;
    
    public Sport_Culture_Placer()
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
        cancelBuy();
        if(Greenfoot.mousePressed(this))
        {
            if(placeable)
            {
                Sport_Culture = new Sport_Culture();
                setTower(Sport_Culture);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }   
}
