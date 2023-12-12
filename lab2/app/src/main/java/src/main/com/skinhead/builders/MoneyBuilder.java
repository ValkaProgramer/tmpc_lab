package src.main.com.skinhead.builders;

import src.main.com.skinhead.interfaces.Builder;
import src.main.com.skinhead.money.Money;

public class MoneyBuilder implements Builder {
    private double amount;
    private String currency;

    public MoneyBuilder setAmount(double amount){
        this.amount = amount;
        return this;
    }

    @Override
    public MoneyBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Money getResult(){
        return new Money(amount, currency);
    }
}
