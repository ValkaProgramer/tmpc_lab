# Topic: SOLID Principles


## Author: Luchianov Vladimir FAF-212

----

## Objectives:

* Study and understand the SOLID Principles.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Create a sample project that respects SOLID Principles.


## Implementation

* I integrated SOLID principles in a raw project. Single Responsability: I corrected classes in a such way, so they would have only one responsability in the general view of the simulation. Open-Closed: I remade class Beverage so it could be inherited by new classes to be added. Liskov Substitution: I made structure of the project and classes in such a way that children could substitute parents. Interface Segregation and Dependency Inversion were implemented using two interfaces in order to not be obligated to use unnecessary methods and to expect implemented class with some method in other class, not knowing anything about how method was implemented.

```
public class Barista extends Person {
    ...
    public boolean makeDrink(Beverage beverage){

        Date start = new Date();
        boolean isDoneSuccessfully = beverage.makeBeverage(this);

        while(true){
            Date now = new Date();
            if(((now.getTime() - start.getTime()) > beverage.getTime() * 1000 / this.efficiency * 1.5) || !isDoneSuccessfully) break;
        }

        return isDoneSuccessfully; 
    }
    ...
}
```
```
public abstract class Beverage implements Named, Amounted {
    ...
    public boolean makeBeverage(Barista barista){
        return barista.boilWater();
    }
}
```
```
public class AmountPrinter {
    ...
    public void printAmount(Amounted item){
        System.out.println(item.getAmount());
    }
}
```

## Conclusion
In conclusion, the laboratory work on SOLID Software Design Principles has been a crucial milestone in my software development education, equipping me with the skills and knowledge necessary to create high-quality, maintainable software. It has laid a strong foundation for my future career in software development.