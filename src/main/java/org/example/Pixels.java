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


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}