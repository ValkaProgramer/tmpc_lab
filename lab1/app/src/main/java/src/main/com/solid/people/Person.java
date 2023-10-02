package com.skinhead.people;
import com.skinhead.interfaces.*;
public abstract class Person implements Named{

    protected String name;

    public String getName(){
        return this.name;
    }
    
}
