package com.skinhead.people;

import com.skinhead.beverages.Beverage;

import java.util.Date;
import java.util.Random;

public class Barista extends Person{

    private float efficiency;

    public Barista(float efficiency){
        setName();
        this.efficiency = efficiency;
    }

    protected void setName(){
        this.name = new Random().nextInt(7) <= 2 ? "Bob" : "John";
    }

    public boolean makeDrink(Beverage beverage){

        Date start = new Date();
        boolean isDoneSuccessfully = beverage.makeBeverage(this);

        while(true){
            Date now = new Date();
            if(((now.getTime() - start.getTime()) > beverage.getTime() * 1000 / this.efficiency * 1.5) || !isDoneSuccessfully) break;
        }

        return isDoneSuccessfully; 
    }

    public boolean addMilk(){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) System.out.println("Oh no, you spilled the milk");
        return success;
    }

    public boolean boilWater(){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) System.out.println("Oh no, you spilled the water");
        return success;
    }

    public boolean mixCoffee(){
        boolean success = new Random().nextInt(1000) * this.efficiency / 2.5 > 9;
        if (!success) System.out.println("Oh no, you didn't respect proportions");
        return success;
    }

    public boolean grindIce(){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 2;
        if (!success) System.out.println("Oh no, ice melted away");
        return success;
    }

    public boolean squishLemon(){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) System.out.println("Oh no, you picked rotten lemon");
        return success;
    }

    public boolean grindFruits(){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) System.out.println("Oh no, you picked some rotten fruits");
        return success;
    }

    public boolean makeCoffee(){
        return addMilk() && boilWater() && mixCoffee();
    }

    public boolean makeColdCoffee(){
        return addMilk() && mixCoffee();
    }

    private boolean makeLemonade(){
        return grindIce() && squishLemon();
    }

    private boolean makeMilkshake(){
        return grindIce() && addMilk();
    }

    private boolean makeSmoothie(){
        return grindIce() && grindFruits() && addMilk();
    }
}