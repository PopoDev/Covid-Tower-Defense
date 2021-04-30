import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    //GreenfootImage chooseMapBackground = new GreenfootImage("menu background 1200x900.png");
    GreenfootImage chooseMapBackground = new GreenfootImage("chooseMap 1200x900.png");
    GreenfootImage chooseDifficultyBackground= new GreenfootImage("chooseDifficulty 1200x900.png");
    
    private String map = "Soon";
    private String difficulty = null;
    
    public MainMenu()
    {    
        super(1200, 900, 1); 
        setBackground(chooseMapBackground);
        placeChooseMap();
    }
    
    public void placeChooseMap()
    {
        ChooseMap mapRoute = new ChooseMap();
        mapRoute.initImage(new GreenfootImage("Map route 320x450.png"));
        mapRoute.initImageOn(new GreenfootImage("Map route mouseOn 334x464.png"));
        mapRoute.setName("Route");
        addObject(mapRoute, 250, 500);
        
        addObject(new ChooseMap(), 600, 500);
        addObject(new ChooseMap(), 950, 500);
    }
    
    public void chooseMap()
    {
        switch(map.toUpperCase())
        {
            case "ROUTE":
                MapRoute mapRoute = new MapRoute();
                Greenfoot.setWorld(mapRoute);
                break;
            
            default:
                break;
        }
        // System.out.println("Map : " + map + " | " + "Difficutly : " + difficulty);
    }
    
    public void placeChooseDifficulty()
    {
        ChooseDifficulty easy = new ChooseDifficulty();
        easy.initImage(new GreenfootImage("chooseEasy 320x450.png"));
        easy.initImageOn(new GreenfootImage("chooseEasy mouseOn 334x464.png"));
        easy.setName("Easy");
        addObject(easy, 250, 500);
        
        ChooseDifficulty medium = new ChooseDifficulty();
        medium.initImage(new GreenfootImage("chooseMedium 320x450.png"));
        medium.initImageOn(new GreenfootImage("chooseMedium mouseOn 334x464.png"));
        medium.setName("Medium");
        addObject(medium, 600, 500);
        
        ChooseDifficulty hard = new ChooseDifficulty();
        hard.initImage(new GreenfootImage("chooseHard 320x450.png"));
        hard.initImageOn(new GreenfootImage("chooseHard mouseOn 334x464.png"));
        hard.setName("Hard");
        addObject(hard, 950, 500);

        // addObject(new PlayButton(), 600, 700);
    }
    
    public void chooseDifficulty()
    {
        setBackground(new GreenfootImage("chooseDifficulty 1200x900.png"));
        removeObjects(getObjects(ChooseMap.class));
        placeChooseDifficulty();
    }
    
    public void setMap(String map)
    {
        this.map = map;
    }
    
    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }
}
