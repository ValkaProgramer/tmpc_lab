package src.main.com.skinhead.miscellaneous;
import src.main.com.skinhead.beverages.*;

public class Menu{
    private Beverage[] beverages = new Beverage[8];
    public Menu(){
        this.beverages[0] = new Cappucino();
        this.beverages[1] = new Latte();
        this.beverages[2] = new Frappe();
        this.beverages[3] = new DoubleLatte();
        this.beverages[4] = new IcedLatte();
        this.beverages[5] = new Lemonade();
        this.beverages[6] = new Milkshake();
        this.beverages[7] = new Smoothie();
    }

    public Beverage getBeverage(int id){
        return this.beverages[id];
    }

    public void get(){
        for (Beverage beverage : beverages) {
            System.out.println(beverage.getName());
            System.out.println(beverage.getAmount() + "gr");
            System.out.println(beverage.getPrice() + " MDL");
            System.out.println("---------------------------------------");
        }
    }
}