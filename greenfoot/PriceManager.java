import java.util.ArrayList;
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
        DISINFECTANT(new int[][] {{350}, // Default Price (0, 0)
                                  {600, 900, 1200, 1500},   // 1=Damage Upgrade Price
                                  {300, 600, 900, 1200},   // 2=Range
                                  {400, 800, 1200, 1600}}), // 3=Cooldown
        
        M50(new int[][]          {{350},
                                  {600, 900, 1200, 1500},   // 1=Damage Upgrade Price
                                  {300, 600, 900, 1200},   // 2=Range
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
            typePrices = prices[type];
            for(int i=0 ; i<typePrices.length ; i++)
            {
                typePrices[i] = (int)(typePrices[i] * multiplicator);
            }
            return typePrices;
        }
    }
    
    public void setMultiplicator(double multiplicator)
    {
        this.multiplicator = multiplicator;
    }
}


