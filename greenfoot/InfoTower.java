import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Information affichée lorsque la souris est sur une icône de tour.
 * 
 * @author PopoDev
 * @version 07.06.2021
 */
public class InfoTower extends HUD
{
    private int price;
    
    Font priceFont = new Font("Agency FB", true, false, 25);
    Color priceColor = new Color(255, 187, 0); // Jaune-Orange
    
    public void setPrice(int amount)
    {
        this.price = amount;
        drawPrice(this.price);
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public void drawPrice(int price)
    {
        TextImage priceImage = new TextImage("   Prix " + price + "$   ", priceFont, priceColor, null);
        getImage().drawImage(priceImage, (getImage().getWidth() - priceImage.getWidth()) / 2, 40);
    }
}
