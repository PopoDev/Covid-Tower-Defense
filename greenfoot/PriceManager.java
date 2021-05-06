import java.util.List;
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
        DISINFECTANT(new int[] {350, 600, 1200, 2400});
        
        private int[] prices;
        private int price;
        
        Prices(int[] prices)
        {
            this.prices = prices;
        }
        
        public int getPrice(int index)
        {
            price = (int)(prices[index] * multiplicator);
            return price;
        }
    }
    
    public void setMultiplicator(double multiplicator)
    {
        this.multiplicator = multiplicator;
    }
}


