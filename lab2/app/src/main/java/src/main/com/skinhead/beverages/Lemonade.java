package src.main.com.skinhead.beverages;

import src.main.com.skinhead.people.Barista;

public class Lemonade extends Beverage{
    public Lemonade() {
        this.name = "Lemonade";
        this.price = 30;
        this.amount = 500;
        this.time = 8;
    }
    
    public boolean makeLemonade(Barista barista){
        return barista.squishLemon() && barista.grindIce();
    }
}
