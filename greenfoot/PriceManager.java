import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class PriceManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PriceManager
{
    private static double multiplicator = 1;
    
    public enum Prices
    {
        DISINFECTANT(new int[][] {{600}, // Default Price (0, 0)
                                  {600, 900, 1200, 1500},   // 1=Damage Upgrade Price
                                  {300, 600, 900, 1200},    // 2=Range
                                  {400, 800, 1200, 1600}}), // 3=Cooldown
        
        M50(new int[][]          {{500},
                                  {800, 1000, 1200, 1400},  // 1=Damage
                                  {400, 600, 800, 1000},    // 2=Range
                                  {400, 800, 1200, 1600}}), // 3=Cooldown
                                  
        MASK(new int[][]         {{400},
                                  {500, 1000, 1500, 2000},  // 1=Time
                                  {250, 500, 750, 1000},    // 2=Range
                                  {400, 800, 1200, 1600}}), // 3=Cooldown
                                  
        WHITECELL(new int[][]    {{300},
                                  {500, 1000, 1500, 2000},  // 1=Damage
                                  {250, 500, 750, 1000},    // 2=Range
                                  {400, 800, 1200, 1600}}), // 3=AtkSpd
                                  
        VACCINE(new int[][]      {{350},
                                  {500, 1000, 1500, 2000},  // 1=Damage
                                  {200, 400, 600, 800},    // 2=Range
                                  {400, 800, 1200, 1600}}); // 3=Cooldown
        
        private int[][] prices;
        private int[] typePrices;
        private int price;
        
        Prices(int[][] prices)
        {
            this.prices = prices;
        }
        
        public int getPrice(int type, int index)
        {
            price = (int)(prices[type][index] * multiplicator);
            return price;
        }
        
        public int[] getTypePrices(int type)
        {
            typePrices = Arrays.copyOf(prices[type], prices[type].length);
            
            for(int i=0 ; i<typePrices.length ; i++)
            {
                typePrices[i] = (int)(typePrices[i] * multiplicator);
            }
            //System.out.println(Arrays.toString(prices[type]));
            return typePrices;
        }
    }
    
    public void setMultiplicator(double multiplicator)
    {
        this.multiplicator = multiplicator;
    }
}


