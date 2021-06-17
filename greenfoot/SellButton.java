import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouton pour vendre une tour. Rend 80% de la valeur totale (base + améliorations) lors de la vente.
 * 
 * @author PopoDev
 * @version 12.06.2021
 */
public class SellButton extends Buttons
{
    private GreenfootImage sellButton = new GreenfootImage("SellButton 70x30.png");
    private GreenfootImage sellButtonOn = new GreenfootImage("SellButton 72x32 mouseOn.png");
    
    private Towers linkedTower = null;
    private int towerPrice;
    private int sellPrice;
    
    boolean init = false;
    Font sellFont = new Font("Berlin Sans FB Demi Gras", true, false, 20);
    //Font sellFont = new Font("Agency FB", true, false, 20);
    
    public void act()
    {
        if(!init) init();
        if(Greenfoot.mousePressed(this))
        {
            linkedTower.sell();
            if(SoundButton.soundOn) Greenfoot.playSound("sell.mp3");            
        }
        changeIfHovering(sellButton, sellButtonOn);
    }
    
    public void init()
    {
        sellPrice = (int)(linkedTower.towerPrice * 0.8);
        GreenfootImage textImage = new TextImage("" + sellPrice, sellFont, Color.WHITE, null);
        sellButton.drawImage(textImage, (sellButton.getWidth() - textImage.getWidth()) / 2, 13);
        sellButtonOn.drawImage(textImage, (sellButton.getWidth() - textImage.getWidth()) / 2, 13);
        setImage(sellButton);
        init = true;
    }
    
    public void updateText()
    {
        sellPrice = (int)(linkedTower.towerPrice * 0.8);
        GreenfootImage textImage = new TextImage("" + sellPrice, sellFont, Color.WHITE, null);
        sellButton = new GreenfootImage("SellButton 70x30.png");
        sellButton.drawImage(textImage, (sellButton.getWidth() - textImage.getWidth()) / 2, 13);
        sellButtonOn = new GreenfootImage("SellButton 72x32 mouseOn.png");
        sellButtonOn.drawImage(textImage, (sellButton.getWidth() - textImage.getWidth()) / 2, 13);
        setImage(sellButton);
    }
    
    public void setLinkedTower(Towers tower)
    {
        this.linkedTower = tower;
    }
}
