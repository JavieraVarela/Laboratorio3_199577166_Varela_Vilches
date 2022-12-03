package org.example;

import java.util.*;

public class TDA_Pixhex extends Pixels{

    //Atributos
    private String hex;

    //Constructor
    public TDA_Pixhex(int x, int y, String hex, int depth) {
        super(x, y, depth);
        if (IsPixHex(hex)) {
            this.hex = hex;
        } else {
            System.out.println("Error: El valor ingresado no es un hexadecimal.");
        }
    }

    //Metodos

    //1. IsPixHex.
    //Metodo que verifica si un String es de un largo de 6 caracteres o menos.
    public boolean IsPixHex(String hex) {
        return hex.length() <= 6;
    }

    //Getters

    public String getHex() {
        return hex;
    }

    //Setters
    public void setHex(String hex) {
        this.hex = hex;
    }
}