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
}
