package org.example;

import java.util.*;

public class TDA_PixBit extends Pixels{

    //Atributos
    private int Bit;

    //Constructor
    public TDA_PixBit(int x, int y, int depth, int bit) {
        super(x, y, depth);
        if (IsBit(bit)) {
            this.Bit = bit;
        } else {
            System.out.println("Error: El valor ingresado no es un bit.");
        }
    }

    //Metodos

    //1. Bit.
    //Metodo que verifica si un entero es 0 o 1.
    public boolean IsBit(int bit) {
        return bit == 0 || bit == 1;
    }

    //2. IsPixBit.
    //Metodo que verifica si un objeto es del tipo PixBit.
    public boolean IsPixBit(Object o) {
        return o.getClass().getName().equals("Laboratorio3.PixBit");
    }

    //Getters

    public int getBit() {
        return Bit;
    }

    // Setters

    public void setBit(int bit) {
        Bit = bit;
    }
}