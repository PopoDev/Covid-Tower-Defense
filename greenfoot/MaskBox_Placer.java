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
    
    private int rotation;
    private boolean rotated = false;
    
    public MaskBox_Placer()
    {
        setBasicRange(basicRange);
        setBasicPrice(basicPrice);
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        rotation = 0;
        setRotation(rotation);
    }
    
    public void act() 
    {
        rotateIfKeyPressed();
        showPlacingRange();
        followMouse();
        isPlaceable();
        showIfPlaceable();
        if(Greenfoot.mousePressed(this))
        {
            if(placeable)
            {
                maskBox = new MaskBox();
                maskBox.setRotation(rotation);
                setTower(maskBox);
                placeTower();
            } else {
                System.out.println("You can't place towers on the roads, on other towers and outside of the map.");
            }
        }
    }
    
    public void rotateIfKeyPressed()
    {
        String key = Greenfoot.getKey();
        if("r".equals(key))
        {
            if(rotated)
            {
                rotation = 0;
                setRotation(rotation);
                rotated = false;
            } else {
                rotation = -90;
                setRotation(rotation);
                rotated = true;
            }
        }
    }
}
