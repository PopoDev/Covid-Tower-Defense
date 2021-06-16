import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe donnant l'effet d'un bouton
 * 
 * @author PopoDev
 * @version 20.04.2021
 */
public class Buttons extends SmoothMover
{
    boolean mouseOn = false;
    boolean setImageOn = false;
    boolean artificialClicked = false;
    
    /**
     * Détecte si la souris est sur un objet.
     */
    public boolean isHovering()
    {
        if(Greenfoot.mouseMoved(this) && !mouseOn) mouseOn = true; 
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null) && mouseOn) mouseOn = false;
        if(mouseOn)
        {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Change d'image si la souris survole l'object pour donner un effet de sélection.
     */
    public void changeIfHovering(GreenfootImage initialImg, GreenfootImage hoveringImg)
    {
        if(isHovering() && !setImageOn)
        {
            setImage(hoveringImg);
            setImageOn = true;
        } 
        if(!isHovering() && setImageOn)
        {
            setImage(initialImg);
            setImageOn = false;
        }
    }
    
    public void artificialClick()
    {
        artificialClicked = true;
    }
    
    public boolean isOnTop()
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            MouseInfo mi = Greenfoot.getMouseInfo();
            int width = getImage().getWidth();
            int height = getImage().getHeight();
            if(mi.getX() >= getX() - width/2 && mi.getX() <= getX() + width/2 && // X axis
               mi.getY() >= getY() - height/2 && mi.getY() <= getY() + height/2) // Y axis
            {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    
    public void changeIfOnTop(GreenfootImage initialImg, GreenfootImage hoveringImg)
    {
        if(isOnTop() && !setImageOn)
        {
            setImage(hoveringImg);
            setImageOn = true;
        } 
        if(!isOnTop() && setImageOn)
        {
            setImage(initialImg);
            setImageOn = false;
        }
        
    }
}
