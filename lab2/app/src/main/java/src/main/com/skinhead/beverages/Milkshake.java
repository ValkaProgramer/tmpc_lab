package src.main.com.skinhead.beverages;

import src.main.com.skinhead.people.Barista;

public class Milkshake extends Beverage{

    public Milkshake(){
        this.type = "Milkshake";
        this.name = "Milkshake";
        this.price = 40;
        this.amount = 350;
        this.time = 10;
    }
    
    @Override
    public boolean makeBeverage(Barista barista){
        return barista.addMilk() && barista.grindIce();
    }
}