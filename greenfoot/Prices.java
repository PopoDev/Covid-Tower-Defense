import java.util.List;
/**
 * Write a description of class PriceManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        return prices[index];
    }
}


