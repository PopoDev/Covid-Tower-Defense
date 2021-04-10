import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Map 1
 * 
 * @author PopoDev
 * @version 1.0.0
 */
public class Map1 extends World
{
    int gridSize = 50;
    int dimension = 16;
    public final static int MAP_WIDTH = 800;
    public final static int MAP_HEIGHT = 800;
    
    int[][] road =  // 12 = up-right (UR), 14 = up-left (UL), 32 = down-right (DR), 34 = down-left(UL)
    {
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
        {0, 1, 0, 0, 0, 32, 2, 2, 34, 0, 0, 32, 2, 2, 34 ,0},
        {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 ,0},
        {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 ,0},
        {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 ,0},
        {0, 1, 0, 32, 2, 14, 0, 0, 12, 2, 2, 14, 0, 0, 1 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 32, 2, 14 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 12, 2, 14, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0}
    };
    
    public Map1()
    {    
        super(1200, 900, 1);
        createRoad();
        // placeTowers();
        placeGUI();
        
        setPaintOrder(TowersPlacer.class, RangeIcon.class, Buttons.class, HUD.class, Towers.class, Mobs.class, Range.class, Backgrounds.class);
    }
    
    public void createRoad()
    {
        for(int i = 0; i < road.length; i++)
        {
            for(int j = 0; j < road[i].length; j++)
            {
                if(road[i][j] == 1)
                {
                    StraightRoad verticalRoad = new StraightRoad();
                    addObject(verticalRoad, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 2)
                {
                    StraightRoad horizontalRoad = new StraightRoad();
                    horizontalRoad.setImage(new GreenfootImage("roads/road 50x50 (horizontal).png"));
                    addObject(horizontalRoad, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 12)
                {
                    CurvedRoad roadUR = new CurvedRoad();
                    addObject(roadUR, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 14)
                {
                    CurvedRoad roadUL = new CurvedRoad();
                    roadUL.setImage(new GreenfootImage("roads/road 50x50 (UL).png"));
                    addObject(roadUL, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 32)
                {
                    CurvedRoad roadDR = new CurvedRoad();
                    roadDR.setImage(new GreenfootImage("roads/road 50x50 (DR).png"));
                    addObject(roadDR, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 34)
                {
                    CurvedRoad roadDL = new CurvedRoad();
                    roadDL.setImage(new GreenfootImage("roads/road 50x50 (DL).png"));
                    addObject(roadDL, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                } else {
                    Grass grass = new Grass();
                    addObject(grass, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
            }
        }
    }
    
    public void placeGUI()
    {
        TowersHUD towersHUD = new TowersHUD();
        addObject(towersHUD, 1000, 400);
        
        HealthIcon healthIcon = new HealthIcon();
        addObject(healthIcon, 900, 50);
        
        LivesText livesText = new LivesText();
        addObject(livesText, 900, 50);
        
        MoneyIcon moneyIcon = new MoneyIcon();
        addObject(moneyIcon, 1100, 50);
        
        MoneyText moneyText = new MoneyText();
        addObject(moneyText, 1125, 50);
        
        Disinfectant_Icon disinfectant_Icon = new Disinfectant_Icon();
        addObject(disinfectant_Icon, 925, 150);
        
        SpawnMobs nextButton = new SpawnMobs();
        addObject(nextButton, 800 + 200, 800 - 75);
    }
    
    public void placeTowers()
    {
        Tower_1M50 tower_1M50 = new Tower_1M50(this, 325, 125);
        addObject(tower_1M50, 325, 125);
        
        Disinfectant disinfectant = new Disinfectant();
        addObject(disinfectant, 225, 325);
    }
    
    /* 
    public static int getMapWitdh()
    {
        return MAP_X;
    }
    
    public static int getMapHeight()
    {
        return MAP_Y;
    }
     */
}