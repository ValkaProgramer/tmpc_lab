package src.main.com.skinhead.people;

import src.main.com.skinhead.interfaces.Named;

public abstract class Person implements Named{

    public String name;

    public String getName(){
        return this.name;
    }
    
}
