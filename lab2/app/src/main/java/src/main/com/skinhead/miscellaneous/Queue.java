package src.main.com.skinhead.miscellaneous;

import src.main.com.skinhead.factories.Factory;
import src.main.com.skinhead.money.Money;
//import src.main.com.skinhead.money.Profit;
import src.main.com.skinhead.people.Customer;
import src.main.com.skinhead.printers.Printer;

import java.util.Date;
import java.util.Random;

class Queue{
    private Cooldown cooldown = new Cooldown();

    private Node front, rear;
    private long spawnEnd, spawnStart;
    private int size;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.spawnStart = new Date().getTime() / 1000;
    }

    public class Node{
        Customer info;
        Node next;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Customer customer, Printer printer){
        if(isEmpty()){
            rear = new Node();
            rear.info = customer;
            rear.next = null;
            front = rear;
        } else {
            rear.next = new Node();
            rear.next.info = customer;
            rear = rear.next;
        }
        size++;
        printer.printOut(customer.getName() + " ordered one " + customer.getBeverage().getName());
    }

    public void dequeue(Money profit, boolean bool, float chance, Printer printer){
        Customer done = front.info;
        if(bool){
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            printer.printOut(done.getBeverage().getName() + " for " + done.getName() + " is ready!");
            profit.addAmount(done.getBeverage().getPrice());
        } else if(new Random().nextBoolean()){
            printer.printOut(done.getName() + " is ready to wait, but your chances on tips are small");
            chance *= 0.25;
            return;
        } else {
            printer.printOut(done.getName() + " was so pissed of (s)he left, no need for another " + done.getBeverage().getName());
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            chance = 0;
            profit.addAmount(done.getBeverage().getPrice() * -0.7);
            return;
        }
    }
    
    public Customer getFront(){
        return !isEmpty() ? front.info : null;
    }

    public void updateQueue(Factory factory, int season, int day, Printer printer){
        spawnEnd = new Date().getTime() / 1000;

        if(cooldown.getInterval() < spawnEnd - spawnStart){
            cooldown.setInterval(day);
            spawnStart = spawnEnd;
            Customer customer = new Customer(factory, season);
            this.enqueue(customer, printer);
            if(new Random().nextBoolean()){
                this.enqueue(customer.clone(), printer);
            }
        }
    }
}