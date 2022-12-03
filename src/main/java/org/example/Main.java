package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int Width = 5;
        int Height = 5;


        Pixels p1 = new TDA_PixRGB(0, 0, 1, 1, 1, 1);
        Pixels p2 = new TDA_PixRGB(1, 1, 2, 2, 2, 2);
        Pixels p3 = new TDA_PixRGB(2, 2, 3, 3, 3, 3);
        Pixels p4 = new TDA_PixRGB(3, 3, 4, 4, 4, 4);
        Pixels p5 = new TDA_PixRGB(4, 4, 5, 5, 5, 5);

        List<Pixels> pixeles = new ArrayList<>();
        pixeles.add(p1);
        pixeles.add(p2);
        pixeles.add(p3);
        pixeles.add(p4);
        pixeles.add(p5);
        TDA_Imagen TDA = new TDA_Imagen(Width, Height, pixeles);

        System.out.println(TDA.IsBitmap());
        System.out.println(TDA.IsHexmap());
        System.out.println(TDA.IsPixmap());

        System.out.println(TDA.getPixeles().get(0).getX());
        TDA.FlipH();
        System.out.println(TDA.getPixeles().get(0).getX());

        System.out.println("Peo");

        System.out.println(TDA.getPixeles().get(0).getY());
        TDA.FlipV();
        System.out.println(TDA.getPixeles().get(0).getY());

        System.out.println("Peo");

        System.out.println(TDA.getPixeles().size());
        TDA.Crop(1, 3, 1, 3);
        System.out.println(TDA.getPixeles().size());

        System.out.println("Peo");

        TDA.ImagenToHistogram();

        System.out.println("Peo");

        System.out.println(TDA.IsPixmap());
        TDA.RGBtoHex();
        System.out.println(TDA.IsHexmap());

        System.out.println("Peo");

        TDA.ImagenToHistogram();

        Pixels p6 = new TDA_PixBit(1, 1, 1, 1);
        Pixels p7 = new TDA_PixBit(2, 2, 2, 0);
        Pixels p8 = new TDA_PixBit(3, 3, 3, 1);
        Pixels p9 = new TDA_PixBit(4, 4, 4, 0);
        Pixels p10 = new TDA_PixBit(5, 5, 5, 1);

        List<Pixels> pixeles2 = new ArrayList<>();
        pixeles2.add(p6);
        pixeles2.add(p7);
        pixeles2.add(p8);
        pixeles2.add(p9);
        pixeles2.add(p10);

        TDA_Imagen TDA2 = new TDA_Imagen(Width, Height, pixeles2);
        System.out.println(TDA2.IsBitmap());
        System.out.println(TDA2.IsHexmap());

        System.out.println("Peo");

        TDA2.ImagenToHistogram();
    }
}