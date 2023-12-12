package src.main.com.skinhead.miscellaneous;

import src.main.com.skinhead.builders.MoneyBuilder;
import src.main.com.skinhead.directors.Director;
import src.main.com.skinhead.factories.Factory;
import src.main.com.skinhead.money.Money;
import src.main.com.skinhead.people.Person;
//import src.main.com.skinhead.money.Profit;
//import src.main.com.skinhead.money.Tips;
import src.main.com.skinhead.people.Barista;
import src.main.com.skinhead.printers.AmountPrinter;
import src.main.com.skinhead.printers.Printer;

import java.util.Date;
import java.util.Random;

public class Simulation{
    public void runSimulation(int day, int season, int level, int start_hours){

        Date counter = new Date();

        float chance = 16;

        Director director = new Director();
        MoneyBuilder moneyBuilder = new MoneyBuilder();
        director.constructProfit(moneyBuilder);
        Money profit = moneyBuilder.getResult();
        director.constructProfit(moneyBuilder);
        Money your_money = moneyBuilder.getResult();
        director.constructProfit(moneyBuilder);
        Money barista_money = moneyBuilder.getResult();
        director.constructTips(moneyBuilder);
        Money tips = moneyBuilder.getResult();
        Queue queue = new Queue();
        Factory factory = new Factory();
        Menu menu = new Menu();
        Barista barista = new Barista(level);
        Printer printer = new Printer();

        Random rand = new Random();
        boolean bool, is_written_once = false;
        
        AmountPrinter amounter = new AmountPrinter();

        menu.get();
        // System.out.print("\033[H\033[2J");

        amounter.printAmount(profit);
        amounter.printAmount(tips);

        while(start_hours <= 24){

            queue.updateQueue(factory, season, day, printer);

            if (!queue.isEmpty()) {
                is_written_once = false;
            }

            if(queue.isEmpty() && !is_written_once){
                printer.printOut("--------------------------------------------------------\n" + 
                "Waiting for customers...\n" + "--------------------------------------------------------");
                is_written_once = true;
            }

            if(!queue.isEmpty()){
                bool = barista.makeDrink(queue.getFront().getBeverage());
                queue.dequeue(profit, bool, chance, printer);
                printer.printOut("Current profit is " + profit.getAmount() + " " + profit.getCurrency());
                if(chance >= new Random().nextInt(100)) tips.addAmount(rand.nextInt(9));
                printer.printOut("Current tips are " + tips.getAmount() + " " + tips.getCurrency());
                chance = 16;
            }

            if((new Date().getTime() - counter.getTime()) > 60000){
                printer.printOut("It's " + start_hours++ + ":00 :\n"  +  
                "Profit was splitted: 20% to you, 50% to Barista, 30% to materials");
                your_money.addAmount(0.2 * profit.getAmount());
                printer.printOut("Your money for today are : " + your_money.getAmount());
                barista_money.addAmount(profit.getAmount() * 0.5);
                printer.printOut("You paid Barista " + barista_money.getAmount() / (start_hours++ - 7) + " average");
                profit.setAmount(0);
                counter = new Date();
            }
        }


    }
}