package src.main.com.skinhead.factories;

import src.main.com.skinhead.beverages.*;

public class Factory {
    public static Beverage getBeverage(int choice){
        return switch (choice) {
            case 1 -> new Cappucino();
            case 2 -> new DoubleLatte();
            case 3 -> new Frappe();
            case 4 -> new IcedLatte();
            case 5 -> new Latte();
            case 6 -> new Lemonade();
            case 7 -> new Milkshake();
            case 8 -> new Smoothie();
            default -> null;
        };
    }
}
