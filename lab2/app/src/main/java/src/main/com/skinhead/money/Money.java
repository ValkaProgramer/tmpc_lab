package src.main.com.skinhead.money;

import src.main.com.skinhead.interfaces.Amounted;

public class Money implements Amounted {
    protected String currency;
    protected double amount;

    public Money(double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public String getCurrency() {
        return currency;
    }

    public void setAmount(double quantity){
        this.amount = quantity;
    }

    public void addAmount(double quantity){
        this.amount += quantity;
    }

    public double getAmount() {
        return amount;
    }
}