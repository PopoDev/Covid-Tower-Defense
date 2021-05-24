import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map extends World
{   
    public String difficulty;
    private double multiplicator; // multiplicateur des prix
    private PriceManager priceManager = new PriceManager();
    
    private final int STARTING_MONEY = 100000;
    public int money = STARTING_MONEY;
    private MoneyText moneyText;
    
    private int LIVES_MAX;
    public int lives;
    private LivesText livesText;
    
    public int waveNumber = 0;
    public int waveMax;
    public WaveText waveText;
    
    public int mapWidth; // pour détection border dans la class Mobs
    public int mapHeight;
    
    public Map()
    {    
        super(1200, 900, 1);
        setPaintOrder(TowersPlacer.class, RangeIcon.class, Buttons.class, Utils.class, HUD.class,
        TowersProjectile.class, Towers.class, Mobs.class, Range.class, Backgrounds.class);
    }
    
    public void initMap(String difficulty)
    {
        setDifficulty(difficulty);
        priceManager.setMultiplicator(multiplicator);
        placeGUI();
    }
    
    public void placeGUI()
    {
        TowersHUD towersHUD = new TowersHUD();
        addObject(towersHUD, 1000, 400);
        
        BottomHUD bottomHUD = new BottomHUD();
        addObject(bottomHUD, 600, 850);
        
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
        
        WaveIcon waveIcon = new WaveIcon();
        addObject(waveIcon, 180, 850);
        
        WaveText waveText = new WaveText();
        addObject(waveText, 200, 850);
        
        DifficultyIcon difficultyIcon = new DifficultyIcon();
        addObject(difficultyIcon, 525, 850);
        
        MultiplicatorIcon multiplicatorIcon = new MultiplicatorIcon();
        addObject(multiplicatorIcon, 750, 850);
    }
    
    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
        System.out.println("Map : " + this + " | " + "Difficutly : " + difficulty);
        
        initDifficulty();
    }
    
    public void initDifficulty()
    {
        switch(difficulty.toUpperCase())
        {
            case "EASY":
                LIVES_MAX = 200;
                multiplicator = 0.9;
                break;
            case "MEDIUM":
                LIVES_MAX = 150;
                multiplicator = 1;
                break;
            case "HARD":
                LIVES_MAX = 100;
                multiplicator = 1.1;
                break;
            default:
                break;
        }
        this.lives = LIVES_MAX;
        System.out.println("Lives : " + lives + " | Multiplicator : x" + multiplicator);
    }
    
    public void removeLives(int amount)
    {
        if(lives - amount > 0) {
            lives -= amount;
            System.out.println("Lost " + amount + " lives.");
            livesText.updateLivesText();
        } else {
            lives = 0;
            System.out.println("You lost.");
            
            EndMenu endMenu = new EndMenu();
            endMenu.setWinImage(false);
            Greenfoot.setWorld(endMenu);
        }
    }
    
    /**
     * Add money for each virus killed
     */
    public void addMoneyPerKill(int amount)
    {
        money += amount;
        moneyText.updateMoneyText();
    }
    
    public boolean buyIfEnough(int price)
    {
        if(money - price >= 0)
        {
            money -= price;
            moneyText.updateMoneyText();
            return true;
        } else {
            System.out.println("You can't afford this. (Money : " + money + "; Price : " + price + ")");
            return false;
        }
    }
    
    public void setMapDimension(int width, int height)
    {
        this.mapWidth = width;
        this.mapHeight = height;
    }
    
    public void setMoneyText(MoneyText moneyText)
    {
        this.moneyText = moneyText;
    }
    
    public void setLivesText(LivesText livesText)
    {
        this.livesText = livesText;
    }
    
    public void setWaveText(WaveText waveText)
    {
        this.waveText = waveText;
    }
}
