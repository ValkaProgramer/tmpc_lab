package src.main.com.skinhead.directors;

import src.main.com.skinhead.builders.MoneyBuilder;

public class Director {
    public void constructTips(MoneyBuilder moneyBuilder){
        moneyBuilder.setAmount(10);
        moneyBuilder.setCurrency("candies");
    }

    public void constructProfit(MoneyBuilder moneyBuilder){
        moneyBuilder.setAmount(0).setCurrency("MDL");
    }
}
