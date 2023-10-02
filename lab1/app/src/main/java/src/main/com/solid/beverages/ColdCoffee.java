package com.skinhead.beverages;

import com.skinhead.people.Barista;

public class ColdCoffee extends Beverage {
    @Override
    public boolean makeBeverage(Barista barista){
        return barista.addMilk() && barista.mixCoffee() && barista.grindIce();
    }
}