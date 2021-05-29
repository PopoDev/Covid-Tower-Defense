import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteCell_Placer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteCell_Placer extends TowersPlacer
{
    private int basicRange = 125;
    private int basicPrice = PriceManager.Prices.WHITECELL.getPrice(0, 0);
    
    private Towers whiteCell;
    
    public WhiteCell_Placer()
    {
        setBasicRange(basicRange);
        setBasicPrice(basicPrice);
        setRotation(90);
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
                whiteCell = new WhiteCell();
                setTower(whiteCell);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }  
}
