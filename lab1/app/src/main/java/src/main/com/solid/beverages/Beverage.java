package com.skinhead.beverages;

import com.skinhead.interfaces.Amounted;
import com.skinhead.interfaces.Named;
import com.skinhead.people.Barista;

public abstract class Beverage implements Named, Amounted {

    protected String name, type;
    protected int price, time;
    protected double amount;

    public String getName(){
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getTime() {
        return this.time;
    }

    public boolean makeBeverage(Barista barista){
        return barista.boilWater();
    }
}