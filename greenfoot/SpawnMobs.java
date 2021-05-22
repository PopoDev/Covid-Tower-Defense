import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

/**
 * Write a description of class SpawnMobs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    int waveMax = 2;
    boolean waveRunning = false;
    int timeWave = 0; // [acts]
    boolean speedUp = false;
    
    boolean mapEnded = false;
    EndMenu endMenu = new EndMenu();
    
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
            if(Greenfoot.mousePressed(this))
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
            if(Greenfoot.mousePressed(this)) 
            {
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
                changeIfHovering(imgSpeedUp, imgSpeedUpOn);
                Greenfoot.setSpeed(60);
            } else {
                changeIfHovering(imgSpeed, imgSpeedOn);
                Greenfoot.setSpeed(50);
            }
            
            if(spawnNumber < spawnMax)
            {
                wavesSpawner();
            } else {
                if(mobAlive > 0)
                {
                    if(timeWave % 10 == 0) countAlive();  // Pour éviter le lag
                } else {
                    System.out.println("Bravo vous avez battu la vague " + wave + " ! ");
                    setImageOn = !setImageOn; // Réinitialise l'image next
                    waveRunning = false;
                    if(wave >= waveMax)
                    {
                        mapEnded = true;
                        System.out.println("Map1 complétée !");
                        endMenu.setWinImage(true);
                        Greenfoot.setWorld(endMenu);
                    }
                }
            }
            timeWave++;
        } else {
            changeIfHovering(next, nextOn);
        }
    }
    
    public void wavesManager()
    {
        switch(wave)
        {
            case 1:
                rounds = new int[][]
                { // spawnSerie / tier lvl / number / interval / timeWave [acts]
                    {1, 2, 10, 20, 0},     // Tier 2
                    {2, 4, 5, 40, 0},      // Tier 4
                    {3, 3, 20, 10, 500}    // Tier 3
                };
                break;
                
           case 2:
                rounds = new int[][]
                { // spawnSerie / Tier lvl / number / interval / timeWave [acts]
                    {1, 5, 10, 20, 0},
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
        //System.out.println("Rounds : " + spawnCounters);
    }
    
    public void wavesSpawner()
    {
        for(int[] serie : rounds)
        {
            tierNumber = serie[1];
            Virus tier = changeToTier(tierNumber);
            spawning(serie, tier);
        }
    }
    
    public void spawning(int[] serie, Virus tier)
    {
        soloCounter = spawnCounters.get(serie[0] - 1);
        if(soloCounter > 0)
        {
            if(timeWave >= serie[4]){ spawnAtInterval(serie[0], tier, serie[2], serie[3], spawnX, spawnY); }
        }
    }
    
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
    
    public int countAlive()
    {
        mobAlive = getWorld().getObjects(Mobs.class).size();
        // System.out.println(mobAlive + " mobs are alive.");
        return mobAlive;
    }
    
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
    
    /*
    public void showWaveNumber()
    {
        waveText.clear();
        waveText.setFont(waveFont);
        waveText.setColor(Color.BLACK);
        waveText.drawString(wave + " / " + waveMax, 150, 50);
        getWorld().getBackground().drawImage(waveText, 50, 825);
        getWorld().showText("Wave : " + wave + " / " + waveMax, 300, 850);
    }
    */
   
    /*public void spawnAtInterval(int number, Virus tier, int x, int y, long interval) // interval in milliseconds
    {
        for(int i = 1; i <= number; i++)
        {
            getWorld().addObject(tier, x, y);
            try { 
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
     */
    
    // int actCount = 0;
    // int current = 0;
    // boolean timeSet = false;
    
    
    /*public void settimeWave(int acts)
    {
        if(!timeSet)
        {
            current = actCount;
            if(current + acts > actCount)
            { 
                timeSet = true;
                return; 
            }
        } else {
            timeSet = false;
        }
    }
     */
}
