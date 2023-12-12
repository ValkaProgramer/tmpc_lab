package src.main.com.skinhead.beverages;

import src.main.com.skinhead.people.Barista;

public class Smoothie extends Beverage{
    public Smoothie() {
        this.type = "Smoothie";
        this.name = "Smoothie";
        this.price = 50;
        this.amount = 350;
        this.time = 12;
    }
    
    @Override
    public boolean makeBeverage(Barista barista){
        return barista.grindFruits() && barista.grindIce() && barista.addMilk();
    }
}
