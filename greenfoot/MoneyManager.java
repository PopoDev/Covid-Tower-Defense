import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyManager extends Actor
{
    public static final int STARTING_MONEY = 1000;
    public static int money = STARTING_MONEY;
    
    public static boolean buyIfEnough(int price)
    {
        if(money - price >= 0)
        {
            money -= price;
            return true;
        } else {
            System.out.println("You can't afford this. (Money : " + money + "; Price : " + price + ")");
            return false;
        }
    }
}
