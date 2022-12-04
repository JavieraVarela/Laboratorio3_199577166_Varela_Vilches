package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* Creación de pixel RGB */

        //TDA - 1
        int Width1 = 2;
        int Height1 = 2;
        Pixels p1 = new TDA_PixRGB(0, 0, 1, 1, 1, 1);
        Pixels p2 = new TDA_PixRGB(0, 1, 1, 1, 1, 2);
        Pixels p3 = new TDA_PixRGB(1, 0, 3, 3, 3, 3);
        Pixels p4 = new TDA_PixRGB(1, 1, 4, 4, 4, 4);

        List<Pixels> pixeles = new ArrayList<>();
        pixeles.add(p1);
        pixeles.add(p2);
        pixeles.add(p3);
        pixeles.add(p4);
        TDA_Imagen TDA = new TDA_Imagen(Width1, Height1, pixeles);

        //TDA - 4
        // Este TDA se utilizara de ejemplo, despues de realizarse el crop.
        TDA_Imagen TDA4 = new TDA_Imagen(Width1, Height1, pixeles);

        //TDA - 7
        // Este TDA se utilizara de ejemplo, despues de realizarse el RGBtoHex
        TDA_Imagen TDA7 = new TDA_Imagen(Width1, Height1, pixeles);

        /* Creación de pixel Bit */

        //TDA - 2
        int Width2 = 2;
        int Height2 = 4;

        Pixels p6 = new TDA_PixBit(0, 0, 1, 1);
        Pixels p7 = new TDA_PixBit(0, 1, 2, 0);
        Pixels p8 = new TDA_PixBit(0, 2, 2, 1);
        Pixels p9 = new TDA_PixBit(0, 3, 4, 0);
        Pixels p10 = new TDA_PixBit(1, 0, 4, 1);
        Pixels p11 = new TDA_PixBit(1, 1, 4, 0);
        Pixels p12 = new TDA_PixBit(1, 2, 4, 1);
        Pixels p13 = new TDA_PixBit(1, 3, 4, 0);

        List<Pixels> pixeles2 = new ArrayList<>();
        pixeles2.add(p6);
        pixeles2.add(p7);
        pixeles2.add(p8);
        pixeles2.add(p9);
        pixeles2.add(p10);
        pixeles2.add(p11);
        pixeles2.add(p12);
        pixeles2.add(p13);
        TDA_Imagen TDA2 = new TDA_Imagen(Width2, Height2, pixeles2);

        //TDA - 5
        // Este TDA se utilizara de ejemplo, despues de realizarse el crop.
        TDA_Imagen TDA5 = new TDA_Imagen(Width2, Height2, pixeles2);

        //TDA - 8
        // Este TDA se utilizara de ejemplo, despues de realizarse el RGBtoHex
        TDA_Imagen TDA8 = new TDA_Imagen(Width2, Height2, pixeles2);

        /* Creación de pixel Hexadecimal */

        //TDA - 3
        int Width3 = 2;
        int Height3 = 3;

        Pixels p14 = new TDA_Pixhex(0, 0, "AAFFBB", 0);
        Pixels p15 = new TDA_Pixhex(0, 1, "AAFFBB", 0);
        Pixels p16 = new TDA_Pixhex(0, 2, "AAFFBB", 1);
        Pixels p17 = new TDA_Pixhex(1, 0, "020514", 1);
        Pixels p18 = new TDA_Pixhex(1, 1, "020514", 2);
        Pixels p19 = new TDA_Pixhex(1, 2, "100A01", 2);

        List<Pixels> pixeles3 = new ArrayList<>();
        pixeles3.add(p14);
        pixeles3.add(p15);
        pixeles3.add(p16);
        pixeles3.add(p17);
        pixeles3.add(p18);
        pixeles3.add(p19);
        TDA_Imagen TDA3 = new TDA_Imagen(Width3, Height3, pixeles3);

        //TDA - 6
        // Este TDA se utilizara de ejemplo, despues de realizarse el crop.
        TDA_Imagen TDA6 = new TDA_Imagen(Width3, Height3, pixeles3);

        //TDA - 9
        // Este TDA se utilizara de ejemplo, despues de realizarse el RGBtoHex
        TDA_Imagen TDA9 = new TDA_Imagen(Width3, Height3, pixeles3);


        /* Uso de IsBitmap */
        System.out.println("Uso de IsBitmap");
        System.out.println("IsBitmap: " + TDA.IsBitmap());
        System.out.println("IsBitmap: " + TDA2.IsBitmap());
        System.out.println("IsBitmap: " + TDA3.IsBitmap());
        System.out.println("_____________________________________________________________");


        /* Uso de IsHexmap */
        System.out.println("Uso de IsHexmap");
        System.out.println("IsHexmap: " + TDA.IsHexmap());
        System.out.println("IsHexmap: " + TDA2.IsHexmap());
        System.out.println("IsHexmap: " + TDA3.IsHexmap());
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de IsPixmap */
        System.out.println("Uso de IsPixmap");
        System.out.println("IsPixmap: " + TDA.IsPixmap());
        System.out.println("IsPixmap: " + TDA2.IsPixmap());
        System.out.println("IsPixmap: " + TDA3.IsPixmap());
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de FlipH */
        System.out.println("Uso de FlipH");
        System.out.println("Primer pixel de la imagen 1: RGB");
        System.out.println(TDA.getWidth()+" "+TDA.getHeight()+"["+ TDA.getPixeles().get(0).getX()+ " "+ TDA.getPixeles().get(0).getY()+"]");
        TDA.FlipH();
        System.out.println(" ");
        System.out.println("Resultado del flipH :");
        System.out.println(TDA.getWidth()+" "+TDA.getHeight()+"["+ TDA.getPixeles().get(0).getX()+ " "+ TDA.getPixeles().get(0).getY()+"]");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Primer pixel de la imagen 2: Bit");
        System.out.println(TDA2.getWidth()+" "+TDA2.getHeight()+"["+ TDA2.getPixeles().get(0).getX()+ " "+ TDA2.getPixeles().get(0).getY()+"]");
        TDA2.FlipH();
        System.out.println(" ");
        System.out.println("Resultado del flipH :");
        System.out.println(TDA2.getWidth()+" "+TDA2.getHeight()+"["+ TDA2.getPixeles().get(0).getX()+ " "+ TDA2.getPixeles().get(0).getY()+"]");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Primer pixel de la imagen 3: Hexadecimal");
        System.out.println(TDA3.getWidth()+" "+TDA3.getHeight()+"["+ TDA3.getPixeles().get(0).getX()+ " "+ TDA3.getPixeles().get(0).getY()+"]");
        TDA3.FlipH();
        System.out.println(" ");
        System.out.println("Resultado del flipH :");
        System.out.println(TDA3.getWidth()+" "+TDA3.getHeight()+"["+ TDA3.getPixeles().get(0).getX()+ " "+ TDA3.getPixeles().get(0).getY()+"]");
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de FlipV */
        System.out.println("Uso de FlipV");
        System.out.println("Primer pixel de la imagen 1: RGB");
        System.out.println(TDA.getWidth()+" "+TDA.getHeight()+"["+ TDA.getPixeles().get(0).getX()+ " "+ TDA.getPixeles().get(0).getY()+"]");
        TDA.FlipV();
        System.out.println(" ");
        System.out.println("Resultado del flip: ");
        System.out.println(TDA.getWidth()+" "+TDA.getHeight()+"["+ TDA.getPixeles().get(0).getX()+ " "+ TDA.getPixeles().get(0).getY()+"]");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Primer pixel de la imagen 2: Bit");
        System.out.println(TDA2.getWidth()+" "+TDA2.getHeight()+"["+ TDA2.getPixeles().get(0).getX()+ " "+ TDA2.getPixeles().get(0).getY()+"]");
        TDA2.FlipV();
        System.out.println(" ");
        System.out.println("Resultado del flip: ");
        System.out.println(TDA2.getWidth()+" "+TDA2.getHeight()+"["+ TDA2.getPixeles().get(0).getX()+ " "+ TDA2.getPixeles().get(0).getY()+"]");
        System.out.println(" ");


        System.out.println("Primer pixel de la imagen 3: Hexadecimal");
        System.out.println(TDA3.getWidth()+" "+TDA3.getHeight()+"["+ TDA3.getPixeles().get(0).getX()+ " "+ TDA3.getPixeles().get(0).getY()+"]");
        TDA3.FlipV();
        System.out.println(" ");
        System.out.println("Resultado del flip: ");
        System.out.println(TDA3.getWidth()+" "+TDA3.getHeight()+"["+ TDA3.getPixeles().get(0).getX()+ " "+ TDA3.getPixeles().get(0).getY()+"]");
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de Crop */

        System.out.println("Uso de Crop");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        System.out.println("Dimension de la imagen: "+TDA.getPixeles().size());
        TDA.print();
        TDA.Crop(1, 3, 1, 3);
        System.out.println(" ");
        System.out.println("Resultado del crop: ");
        System.out.println("Dimension de la imagen: "+TDA.getPixeles().size());
        TDA.print();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 2: Bit");
        System.out.println("Dimension de la imagen: "+TDA2.getPixeles().size());
        TDA2.print();
        TDA2.Crop(1, 3, 1, 3);
        System.out.println(" ");
        System.out.println("Resultado del crop: ");
        System.out.println("Dimension de la imagen: "+TDA2.getPixeles().size());
        TDA2.print();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 3: Hexadecimal");
        System.out.println("Dimension de la imagen: "+TDA3.getPixeles().size());
        TDA3.print();
        TDA3.Crop(1, 3, 1, 3);
        System.out.println(" ");
        System.out.println("Resultado del crop: ");
        System.out.println("Dimension de la imagen: "+TDA3.getPixeles().size());
        TDA3.print();
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de RGBtoHex*/

        System.out.println("Uso de RGBtoHex");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        TDA4.print();
        System.out.println(" ");
        System.out.println("Resultado del RGBtoHex: ");
        TDA4.RGBtoHex();
        TDA4.print();
        System.out.println("IsHexmap: " + TDA4.IsHexmap());
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 2: Bit");
        TDA5.print();
        System.out.println(" ");
        System.out.println("Resultado del RGBtoHex: ");
        TDA5.RGBtoHex();
        TDA5.print();
        System.out.println("IsHexmap: " + TDA5.IsHexmap());
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 3: Hexadecimal");
        TDA6.print();
        System.out.println(" ");
        System.out.println("Resultado del RGBtoHex: ");
        TDA6.RGBtoHex();
        TDA6.print();
        System.out.println("IsHexmap: " + TDA6.IsHexmap());
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de ImagenToHistogram*/
        System.out.println("Uso de ImagenToHistogram");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        TDA4.print();
        System.out.println(" ");
        System.out.println("Resultado del ImagenToHistogram: ");
        TDA4.ImagenToHistogram();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 2: Bit");
        TDA5.print();
        System.out.println(" ");
        System.out.println("Resultado del ImagenToHistogram: ");
        TDA5.ImagenToHistogram();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 3: Hexadecimal");
        TDA6.print();
        System.out.println(" ");
        System.out.println("Resultado del ImagenToHistogram: ");
        TDA6.ImagenToHistogram();
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de Rotate90 */
        System.out.println("Uso de Rotate90");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        TDA4.print();
        System.out.println(" ");
        System.out.println("Resultado del Rotate90: ");
        TDA4.Rotate90();
        TDA4.print();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 2: Bit");
        TDA5.print();
        System.out.println(" ");
        System.out.println("Resultado del Rotate90: ");
        TDA5.Rotate90();
        TDA5.print();
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Imagen 3: Hexadecimal");
        TDA6.print();
        System.out.println(" ");
        System.out.println("Resultado del Rotate90: ");
        TDA6.Rotate90();
        TDA6.print();
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de Compress y IsCompress */
        System.out.println("Uso de Compress y IsCompress");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        TDA4.print();
        System.out.println(" ");
        System.out.println("Resultado del Compress: ");
        TDA4.Compress();
        TDA4.print();
        System.out.println(" ");
        System.out.println("IsCompress: " + TDA4.IsCompress());
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* InvertColorBit */
        System.out.println("Uso de InvertColorBit");
        System.out.println(" ");
        System.out.println("Imagen 2: Bit");
        TDA5.print();
        System.out.println(" ");
        System.out.println("Resultado del InvertColorBit: ");
        TDA5.InvertColorBit();
        TDA5.print();
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");

        /* Uso de InvertColorRGB */
        System.out.println("Uso de InvertColorRGB");
        System.out.println(" ");
        System.out.println("Imagen 1: RGB");
        TDA7.print();
        System.out.println(" ");
        System.out.println("Resultado del InvertColorRGB: ");
        TDA7.InvertColorRGB();
        TDA7.print();
        System.out.println(" ");
        System.out.println("_____________________________________________________________");
        System.out.println(" ");





        /*
        System.out.println("_____________________________________________________________");
        TDA2.Compress();
        System.out.println("_____________________________________________________________");
        */
        //System.out.println(TDA2.IsCompress());


        /*
        TDA2.Rotate90();


        TDA2.Compress();
        TDA2.IsCompress();
        */
    }
}