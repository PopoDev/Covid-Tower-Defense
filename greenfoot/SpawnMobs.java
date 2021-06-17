import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

/**
 * La classe SpawnMobs gère les vagues d'ennemis.
 * 
 * @author PopoDev
 * @version 10.06.2021
 * Source : image from http://clipart-library.com/clipart/rijr5A4jT.htm
 */
public class SpawnMobs extends Buttons
{
    int gridSize = 50;
    
    int spawnX = gridSize/2 + gridSize;
    int spawnY = 0;
    
    GreenfootImage next = new GreenfootImage("MobSpawner 150x125.png");
    GreenfootImage nextOn = new GreenfootImage("MobSpawner mouseOn 150x125.png");
    GreenfootImage imgSpeed = new GreenfootImage("Speed up 150x125.png");
    GreenfootImage imgSpeedOn = new GreenfootImage("Speed up mouseOn 150x125.png");
    GreenfootImage imgSpeedUp = new GreenfootImage("Speed up true 150x125.png");
    GreenfootImage imgSpeedUpOn = new GreenfootImage("Speed up true mouseOn 150x125.png");
    
    int wave = 0;
    int waveMax = 10;
    boolean waveRunning = false;
    int timeWave = 0; // [acts]
    boolean speedUp = false;
    int speed = 50;
    
    boolean mapEnded = false;
    //EndMenu endMenu = new EndMenu();
    
    int[][] rounds = {{}};
    int spawnMax = 0;
    int spawnNumber = 0;
    int tierNumber = 1;
    Virus tierObj = new Tier1(); // default
    
    int mobAlive = 1;
    
    ArrayList <Integer> spawnCounters = new ArrayList();
    int soloCounter = 0;
    
    Map map;
    
    @Override
    protected void addedToWorld(World world)
    {
        map = (Map)getWorld();
        map.waveMax = waveMax;
    }
    
    public void act()
    {
        if(!mapEnded)
        {
            if(Greenfoot.mousePressed(this) || artificialClicked)
            {
                if(!waveRunning)
                {
                    nextWave(); 
                    System.out.println("Wave " + wave + " starts.");
                    map.waveText.updateWaveText();
                    wavesManager();
                    waveRunning = true;
                }
            }
        }
        
        if(waveRunning)
        {
            if(Greenfoot.mousePressed(this) || artificialClicked)
            {
                artificialClicked = false;
                if(timeWave > 0) speedUp = !speedUp;
                if(speedUp)
                {
                    setImage(imgSpeedUpOn);
                } else {
                    setImage(imgSpeedOn);
                }
            }

            if(speedUp)
            {
                changeIfOnTop(imgSpeedUp, imgSpeedUpOn);
                if(speed != 60)
                {
                    speed = 60;
                    Greenfoot.setSpeed(speed);
                }
            } else {
                changeIfOnTop(imgSpeed, imgSpeedOn);
                if(speed != 50)
                {
                    speed = 50;
                    Greenfoot.setSpeed(speed);
                }
            }
            
            if(spawnNumber < spawnMax)
            {
                wavesSpawner();
            } else {
                if(mobAlive > 0)
                {
                    if(timeWave % 10 == 0) countAlive();  // Pour éviter le lag
                } else {
                    System.out.println("Bravo vous avez battu la vague " + wave + " !" + " Récompense par vague : " + map.getMoneyPerRound() + "$") ;
                    map.addMoney(map.getMoneyPerRound());
                    setImageOn = !setImageOn; // Réinitialise l'image next
                    waveRunning = false;
                    if(wave >= waveMax)
                    {
                        mapEnded = true;
                        System.out.println("Map1 complétée !");
                        //endMenu.setWinImage(true);
                        //Greenfoot.setWorld(endMenu);
                        GameStateManager.gameState = GameStateManager.GameState.ENDMENU_WIN;
                        GameStateManager.update();
                    }
                }
            }
            timeWave++;
        } else {
            changeIfOnTop(next, nextOn);
        }
    }
    
    /**
     * Contrôle les paramètres pour les vagues (niveau des ennemis, nombre, intervalle d'apparition, temps avant apparition)
     */
    public void wavesManager()
    {
        switch(wave)
        {
            case 1:
                rounds = new int[][]
                { // spawnSerie / tier lvl / number / interval / timeWave [acts]
                    {1, 1, 50, 30, 0},
                    {2, 2, 25, 40, 600}
                };
                break;
                
            case 2:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 2, 50, 20, 0},
                };
                break;
                
            case 3:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 3, 20, 50, 0},
                    {2, 1, 40, 30, 100}
                };
                break;
                
            case 4:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 3, 50, 20, 0},
                };
                break;
                
            case 5:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 4, 25, 50, 0},
                };
                break;
                
            case 6:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 2, 50, 30, 0},
                    {2, 4, 25, 50, 200}
                };
                break;
                
            case 7:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 3, 40, 30, 0},
                    {2, 5, 16, 60, 400}
                };
                break;
                
            case 8:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 4, 50, 30, 0},
                };
                break;
                
            case 9:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 3, 50, 30, 0},
                    {2, 1, 50, 30, 0},
                };
                break;
                
            case 10:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 5, 50, 30, 0},
                };
                break;
            default:
                break;
        }
        
        for(int i = 0; i < rounds.length; i++)
        {
            spawnMax += rounds[i][2];
            spawnCounters.add(rounds[i][2]);
        }
        //System.out.println("Wave " + wave + " max : " + spawnMax);
        System.out.println("Mobs numbers : " + spawnCounters);
    }
    
    /**
     * Regroupe les ennemis par série selon le wavesManager.
     */
    public void wavesSpawner()
    {
        for(int[] serie : rounds)
        {
            tierNumber = serie[1];
            Virus tier = changeToTier(tierNumber);
            spawning(serie, tier);
        }
    }
    
    /**
     * Fait apparaître des ennemis au début de la map.
     */
    public void spawning(int[] serie, Virus tier)
    {
        soloCounter = spawnCounters.get(serie[0] - 1);
        if(soloCounter > 0)
        {
            if(timeWave >= serie[4]){ spawnAtInterval(serie[0], tier, serie[2], serie[3], spawnX, spawnY); }
        }
    }
    
    /**
     * Spawn des ennemis à intervalle régulier.
     */
    public void spawnAtInterval(int spawnSerie, Virus tier, int number, int interval, int x, int y) // interval relative to act
    {   
        if(timeWave % interval == 0)
        {
            getWorld().addObject(tier, x, y);
            soloCounter--;
            spawnCounters.set((spawnSerie - 1), soloCounter);
            spawnNumber++;
            
            //System.out.println(spawnCounters); // risque de lag
        }
    }
    
    /**
     * Permet d'associer un entier à un object de type Virus.
     */
    public Virus changeToTier(int tierNumber)
    {
        switch(tierNumber)
        {
            case 1:
                tierObj = new Tier1();
                break;
            case 2:
                tierObj = new Tier2();
                break;
            case 3:
                tierObj = new Tier3();
                break;
            case 4:
                tierObj = new Tier4();
                break;
            case 5:
                tierObj = new Tier5();
                break;
            default:
                break;
        }
        return tierObj;
    }
    
    /**
     * Retourne le nombre d'ennemis en vie.
     */
    public int countAlive()
    {
        mobAlive = getWorld().getObjects(Mobs.class).size();
        // System.out.println(mobAlive + " mobs are alive.");
        return mobAlive;
    }
    
    /**
     * Réinitialise tous les paramètres et lance la nouvelle vague.
     */
    public void nextWave()
    {
        // Reset
        timeWave = 0;
        speedUp = false;
        
        spawnMax = 0;
        spawnNumber = 0;
        
        spawnCounters = new ArrayList();
        soloCounter = 0;
        
        mobAlive = 1;
        
        wave++;
        map.waveNumber = wave;
    }
}
