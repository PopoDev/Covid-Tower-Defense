import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La classe Map gère le placement du GUI et stocke les valeurs pour l'argent, la vie et les vagues.
 * 
 * @author PopoDev 
 * @version 08.06.2021
 */
public class Map extends World
{   
    public String difficulty;
    private double multiplicator; // multiplicateur des prix
    private PriceManager priceManager = new PriceManager();
    
    private final int STARTING_MONEY = 100000;
    public int money = STARTING_MONEY;
    private MoneyText moneyText;
    
    private int moneyPerKill = 1; // initial
    private int moneyPerRound = 50;
    
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
        setPaintOrder(TowersPlacer.class, RangeIcon.class, Buttons.class, HUD.class, Utils.class,
        Towers.class, TowersProjectile.class, Mobs.class, Range.class, Backgrounds.class);
    }
    
    /**
     * Initialise la map (difficulté, multiplicateur de prix, GUI)
     */
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
        
        Tower1M50_Icon tower1M50_Icon = new Tower1M50_Icon();
        addObject(tower1M50_Icon, 1075, 150);
        
        Mask_Icon mask_Icon = new Mask_Icon();
        addObject(mask_Icon, 925, 275);
        
        WhiteCell_Icon whiteCell_Icon = new WhiteCell_Icon();
        addObject(whiteCell_Icon, 1075, 275);
        
        Vaccine_Icon vaccine_Icon = new Vaccine_Icon();
        addObject(vaccine_Icon, 925, 400);
        
        Sport_Culture_Icon Sport_Culture_Icon = new Sport_Culture_Icon();
        addObject(Sport_Culture_Icon, 1075, 400);
        
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
    
    /**
     * Enlève des points de vie si des ennemis passent la map
     */
    public void removeLives(int amount)
    {
        if(lives - amount > 0) {
            lives -= amount;
            System.out.println("Lost " + amount + " lives.");
            livesText.updateLivesText();
        } else {
            lives = 0;
            System.out.println("You lost.");
            
            GameStateManager.gameState = GameStateManager.GameState.ENDMENU_LOSE;
            GameStateManager.update();
        }
    }
    
    /**
     * Rajoute de l'argent au solde actuel
     */
    public void addMoney(int amount)
    {
        money += amount;
        moneyText.updateMoneyText();
    }
    
    /**
     * Achète une tour ou amélioration si le solde est suffisant
     */
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
        
    public void addMoneyPerKill(int moneyPerKill)
    {
        this.moneyPerKill += moneyPerKill;
    }
    
    public int getMoneyPerKill()
    {
        return moneyPerKill;
    }
    
    public void addMoneyPerRound(int moneyPerRound)
    {
        this.moneyPerRound += moneyPerRound;
    }
    
    public int getMoneyPerRound()
    {
        return moneyPerRound;
    }
}
