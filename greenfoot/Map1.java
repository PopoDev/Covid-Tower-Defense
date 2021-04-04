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
        {0, 1, 32, 14, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 12, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0}
    };
    
    public Map1()
    {    
        super(1200, 800, 1);
        createRoad();
        spawnMob();
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
    
    public void spawnMob()
    {
        int spawnX = gridSize/2 + gridSize;
        int spawnY = gridSize/2;
        
        Tier1 tier1 = new Tier1();
        addObject(tier1, spawnX, spawnY);
        
        Tier2 tier2 = new Tier2();
        addObject(tier2, spawnX, spawnY);
        
        Tier3 tier3 = new Tier3();
        addObject(tier3, spawnX, spawnY);
        
        Tier4 tier4 = new Tier4();
        addObject(tier4, spawnX, spawnY);
        
        Tier5 tier5 = new Tier5();
        addObject(tier5, spawnX, spawnY);
    }
}