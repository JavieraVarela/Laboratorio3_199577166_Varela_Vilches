package org.example;

public abstract class Pixels {

    // Atributos
    private int x;
    private int y;
    private int depth;

    // Constructor.

    public Pixels(int x, int y, int depth){
        this.setX(x);
        this.setY(y);
        this.setDepth(depth);
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }

    // Setters
    public void setX(int x) {this.x = x;}

    public void setY(int y) {
        this.y = y;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}