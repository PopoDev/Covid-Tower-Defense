import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Map Route
 * 
 * @author PopoDev
 * @version 03.05.2021
 */
public class MapRoute extends Map
{
    private int gridSize = 50;
    private int dimension = 16;
    private final int MAP_WIDTH = 800;
    private final int MAP_HEIGHT = 800;
    
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
    
    public MapRoute()
    {    
        createRoad();
        setMapDimension(MAP_WIDTH, MAP_HEIGHT);
    }
    
    /**
     * Crée le chemin de la map selon la matrice
     */
    public void createRoad()
    {
        for(int i = 0; i < road.length; i++)
        {
            for(int j = 0; j < road[i].length; j++)
            {
                if(road[i][j] == 1)
                {
                    StraightRoad verticalRoad = new StraightRoad();
                    verticalRoad.setDirection("Vertical");
                    addObject(verticalRoad, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 2)
                {
                    StraightRoad horizontalRoad = new StraightRoad();
                    horizontalRoad.setImage(new GreenfootImage("roads/road 50x50 (horizontal).png"));
                    horizontalRoad.setDirection("Horizontal");
                    addObject(horizontalRoad, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 12)
                {
                    CurvedRoad roadUR = new CurvedRoad();
                    roadUR.setDirection("UR");
                    addObject(roadUR, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 14)
                {
                    CurvedRoad roadUL = new CurvedRoad();
                    roadUL.setImage(new GreenfootImage("roads/road 50x50 (UL).png"));
                    roadUL.setDirection("UL");
                    addObject(roadUL, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 32)
                {
                    CurvedRoad roadDR = new CurvedRoad();
                    roadDR.setImage(new GreenfootImage("roads/road 50x50 (DR).png"));
                    roadDR.setDirection("DR");
                    addObject(roadDR, gridSize/2 + j*gridSize, 
                    gridSize/2 + i*gridSize);
                }
                else if(road[i][j] == 34)
                {
                    CurvedRoad roadDL = new CurvedRoad();
                    roadDL.setImage(new GreenfootImage("roads/road 50x50 (DL).png"));
                    roadDL.setDirection("DL");
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
}