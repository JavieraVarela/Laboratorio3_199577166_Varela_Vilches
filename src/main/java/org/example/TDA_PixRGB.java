package org.example;

public class TDA_PixRGB extends Pixels {

    //Atributos
    private int r;
    private int g;
    private int b;

    //Constructor
    public TDA_PixRGB(int x, int y, int r, int g, int b, int depth) {
        super(x, y, depth);
        if (IsInRange(r) && IsInRange(g) && IsInRange(b)) {
            this.r = r;
            this.g = g;
            this.b = b;
        } else {
            System.out.println("Error: Los valores de los colores deben estar entre 0 y 255.");
        }
    }

    //Metodos

    //1. IsInRange.
    //Metodo que verifica si un entero esta dentro del rango de valores permitidos. (0 < x < 255).
    public boolean IsInRange(int x) {
        return x > 0 && x < 255;
    }

    //2. IsPixRGB.
    //Metodo que verifica si un objeto es del tipo PixRGB.
    public boolean IsPixRGB(Object o) {
        return o.getClass().getName().equals("Laboratorio3.PixRGB");
    }

    //Getters

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    //Setters

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

}