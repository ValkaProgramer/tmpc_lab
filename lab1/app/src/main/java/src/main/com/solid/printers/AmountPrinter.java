package com.skinhead.printers;

import com.skinhead.interfaces.Amounted;

public class AmountPrinter {
    void AmountPrinter(){}

    public void printAmount(Amounted item){
        System.out.println(item.getAmount());
    }
}