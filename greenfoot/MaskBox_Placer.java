import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mask_Placer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaskBox_Placer extends TowersPlacer
{
    private int basicRange = 150;
    private int basicPrice = PriceManager.Prices.MASK.getPrice(0, 0);
    
    private Towers maskBox;
    
    public MaskBox_Placer()
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
                maskBox = new MaskBox();
                setTower(maskBox);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }   
}
