package src.main.com.skinhead.people;

import src.main.com.skinhead.beverages.Beverage;
import src.main.com.skinhead.factories.Factory;
import src.main.com.skinhead.miscellaneous.Menu;

import java.util.Random;

public class Customer extends Person {
    
    private Beverage beverage;

    public Customer(Factory factory, int season){
        setName();
        setBeverage(factory, season);
    }

    public Customer(Customer target){
        if(target != null){
            setName();
            this.beverage = target.beverage;
        }
    }

    public Customer clone(){
        return new Customer(this);
    }
    protected void setName(){
        String[] list = {"Jayce", "Alice", "Victor", "Kevin", "Mary", "Selena", "Samuel", "Ryan", "Jake", "Scarlet", "Jotaro",
                "Marvelin", "Diona", "Tartaglia", "Dante", "Desmond", "Miles", "Mileena", "Samwell", "Tommy",
                "Gamora"};
        this.name = list[new Random().nextInt(20)];
    }

    private void setBeverage(Factory factory, int season){
        this.beverage = factory.getBeverage(new Random().nextInt(season == 1 ? 4 : 8) + 1);
    }

    public Beverage getBeverage(){
        return this.beverage;
    }

}
