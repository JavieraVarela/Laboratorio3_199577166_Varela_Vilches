package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TDA_Imagen {

    //Atributos

    private int Width;
    private int Height;
    private List<Pixels> pixeles = new ArrayList<Pixels>();

    //Constructor

    public TDA_Imagen(int width, int height, List<Pixels> pixeles) {
        Width = width;
        Height = height;
        this.pixeles = pixeles;
    }

    //Getters
    public int getWidth() {
        return this.Width;
    }

    public int getHeight() {
        return this.Height;
    }

    public List<Pixels> getPixeles() {
        return this.pixeles;
    }

    //Setters
    public void setWidth(int newwidth) {
        this.Width = newwidth;
    }

    public void setHeight(int newheight) {
        this.Height = newheight;
    }

    public void setPixeles(List<Pixels> newpixeles) {
        this.pixeles = newpixeles;
    }

    //Metodos

    // 1. IsBitmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo Pixbit.
    public boolean IsBitmap() {
        for (Pixels p : pixeles) {
            if (!p.getClass().getName().equals("org.example.TDA_PixBit")) {
                return false;
            }
        }
        return true;
    }
    //________________________________________________________________________________________________________________

    // 2. IsPixmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo PixRGB.
    public boolean IsPixmap() {
        for (Pixels p : pixeles) {
            if (!p.getClass().getName().equals("org.example.TDA_PixRGB")) {
                return false;
            }
        }
        return true;
    }


    //________________________________________________________________________________________________________________

    // 3. IsHexmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo PixHex.
    public boolean IsHexmap() {
        for (Pixels p : pixeles) {
            if (!p.getClass().getName().equals("org.example.TDA_PixHex")) {
                return false;
            }
        }
        return true;
    }

    //________________________________________________________________________________________________________________

    // 4. FlipH
    // Metodo que invierte la imagen horizontalmente.
    // Cada pixel esta compuesto por coordenadas X e Y, además de la anchura de la imagen. Para lograr voltear la imagen
    // horizontalmente, se debe seguir la siguiente formula:
    // Flip = (Anchura - 1) - X

    public void FlipH() {
        int z = getWidth() - 1;
        for (Pixels p : pixeles) {
            int newcoordx = z - p.getX();
            p.setX(newcoordx);
        }
    }
    //________________________________________________________________________________________________________________

    // 5. FlipV
    // Metodo que invierte la imagen verticalmente.
    // Cada pixel esta compuesto por coordenadas X e Y, además de la altura de la imagen. Para lograr voltear la imagen
    // verticalmente, se debe seguir la siguiente formula:
    // Flip = (Altura - 1) - Y

    public void FlipV() {
        int z = getHeight() - 1;
        for (Pixels p : pixeles) {
            int newcoordy = z - p.getY();
            p.setY(newcoordy);
        }
    }

    //________________________________________________________________________________________________________________

    // 6. Crop
    // Metodo que recorta la imagen.
    // La imagen esta compuesta por una lista de pixeles. Para recortar la imagen se debe tener en cuenta un rango
    // de pixeles que se desea conservar. Para lograr esto, se debe crear una nueva lista de pixeles que contenga
    // aquellos pixeles que se encuentran dentro del rango otorgado por el usuario.
    // El rango se obtiene de la siguiente manera:
    // RangoX = X1 < X < X2
    // RangoY = Y1 < Y < Y2
    // X1, X2, Y1, Y2 son los valores que ingresa el usuario.

    public void Crop(int x1, int x2, int y1, int y2) {
        List<Pixels> newpixeles = new ArrayList<Pixels>();
        for (Pixels p : pixeles) {
            if (p.getX() >= x1 && p.getX() <= x2 && p.getY() >= y1 && p.getY() <= y2) {
                newpixeles.add(p);
            }
        }
        setPixeles(newpixeles);
    }

    //________________________________________________________________________________________________________________

    // 7. ImagenRGB a ImagenHex
    // Metodo que convierte una imagen RGB a una imagen Hexadecimal.
    // Un PixRGB esta compuesto por 3 valores enteros que representan el color de un pixel. Para convertir un PixRGB
    // a un PixHex, se debe dividir el valor de cada color entre 16 y obtener el residuo de la division. Si la división
    // no es exacta, el residuo se debe muliplicar por 16.
    // Ejemplo:
    // RGB = (255, 243, 112)  ->  Hex = (FF, FF, FF)
    // 255 / 16 = 15.9375 -> Se conserva el 15.
    // 15 = F
    // 0.9375 * 16 = 15
    // 15 = F
    // Hex = [FF]

    public void RGBtoHex() {
        if (IsBitmap()) {
            List<Pixels> newpixeles = new ArrayList<>();
            for (Pixels p : pixeles) {
                if (IsPixmap()) {
                    int r = ((TDA_PixRGB) p).getR();
                    int g = ((TDA_PixRGB) p).getG();
                    int b = ((TDA_PixRGB) p).getB();
                    String newr = Integer.toHexString(r);
                    String newg = Integer.toHexString(g);
                    String newb = Integer.toHexString(b);
                    if (newr.length() == 1) {
                        newr = "0" + newr;
                    }
                    if (newg.length() == 1) {
                        newg = "0" + newg;
                    }
                    if (newb.length() == 1) {
                        newb = "0" + newb;
                    }
                    Pixels newpixel = new TDA_Pixhex(p.getX(), p.getY(), newr + newg + newb, p.getDepth());
                    newpixeles.add(newpixel);
                }
            }
            setPixeles(newpixeles);
        }
    }

    //________________________________________________________________________________________________________________
    /* 8. ImagetoHistogram
     Metodo que crea un histograma de la imagen.
     Un histograma es una representación gráfica de la distribución de frecuencia de una variable. En este caso, se
     reconoce cuantas veces aparece un color en una imagen.
     Se debe crear un metodo que permita obtener cuantas veces un elemento se repite en los pixeles de la imagen.
     - Pixbit: Se debe contar cuantas veces aparece el color 0 y cuantas veces aparece el color 1.
     - PixRGB: Se debe contar cuantas veces aparece repetido cada color (Rojo, Verde, Azul) de manera individual.
     - PixHex: Se debe contar cuantas veces se repite un string.
     */

    public void ImagenToHistogram() {
        if (IsBitmap()) {
            int cero = 0;
            int uno = 0;
            for (Pixels p : pixeles) {
                if (((TDA_PixBit) p).getBit() == 0) {
                    cero++;
                } else {
                    uno++;
                }
            }
            System.out.println("El color 0 aparece " + cero + " veces.");
            System.out.println("El color 1 aparece " + uno + " veces.");
        } else if (IsPixmap()) {
            ArrayList<Integer> rojo = new ArrayList<Integer>(255);
            ArrayList<Integer> verde = new ArrayList<Integer>(255);
            ArrayList<Integer> azul = new ArrayList<Integer>(255);
            for (int i = 0; i < 255; i++) {
                rojo.add(0);
                verde.add(0);
                azul.add(0);
            }
            for (Pixels p : pixeles) {
                int r = ((TDA_PixRGB) p).getR();
                int g = ((TDA_PixRGB) p).getG();
                int b = ((TDA_PixRGB) p).getB();
                rojo.set(r - 1, rojo.get(r - 1) + 1);
                verde.set(g - 1, verde.get(g - 1) + 1);
                azul.set(b - 1, azul.get(b - 1) + 1);
            }
            for (int i = 0; i < 255; i++) {
                int value = i + 1;
                if (rojo.get(i) != 0) {
                    System.out.println("El color rojo " + value + " aparece " + rojo.get(i) + " veces.");
                }
                if (verde.get(i) != 0) {
                    System.out.println("El color verde " + value + " aparece " + verde.get(i) + " veces.");
                }
                if (azul.get(i) != 0) {
                    System.out.println("El color azul " + value + " aparece " + azul.get(i) + " veces.");
                }
            }
        } else if (IsHexmap()) {
            ArrayList<String> hex = new ArrayList<String>();
            ArrayList<Integer> hexcount = new ArrayList<Integer>();
            for (Pixels p : pixeles) {
                String h = ((TDA_Pixhex) p).getHex();
                if (hex.contains(h)) {
                    int index = hex.indexOf(h);
                    hexcount.set(index, hexcount.get(index) + 1);
                } else {
                    hex.add(h);
                    hexcount.add(1);
                }
            }
            for (int i = 0; i < hex.size(); i++) {
                System.out.println("El color " + hex.get(i) + " aparece " + hexcount.get(i) + " veces.");
            }
        }
    }

    //________________________________________________________________________________________________________________
    /* 9. Rotate90
     Metodo que rota la imagen 90 grados.
     Para rotar la imagen en 90 grados, se debe seguir la regla del plano carteciano donde (x,y) -> (-y,x), donde las
     coordenadas giran 90 grados a la derecha.
     (width - 1 ) - x
     */

    public void Rotate90() {
        if (IsBitmap()) {
            List<Pixels> newpixeles = new ArrayList<>();
            for (Pixels p : pixeles) {
                int newx = p.getY();
                int newy = (getHeight()-1) - p.getX();
                Pixels newpixel = new TDA_PixBit(newx, newy, p.getDepth(),((TDA_PixBit) p).getBit());
                newpixeles.add(newpixel);
            }
            setPixeles(newpixeles);
        } else if (IsPixmap()) {
            List<Pixels> newpixeles = new ArrayList<>();
            for (Pixels p : pixeles) {
                int newx = p.getY();
                int newy = (getHeight()-1) - p.getX();
                Pixels newpixel = new TDA_PixRGB(newx, newy, ((TDA_PixRGB) p).getR(), ((TDA_PixRGB) p).getG(), ((TDA_PixRGB) p).getB(), p.getDepth());
                newpixeles.add(newpixel);
            }
            setPixeles(newpixeles);
        } else if (IsHexmap()) {
            List<Pixels> newpixeles = new ArrayList<>();
            for (Pixels p : pixeles) {
                int newx = p.getY();
                int newy = (getHeight()-1) - p.getX();
                Pixels newpixel = new TDA_Pixhex(newx, newy, ((TDA_Pixhex) p).getHex(), p.getDepth());
                newpixeles.add(newpixel);
            }
            setPixeles(newpixeles);
        }
    }

    //________________________________________________________________________________________________________________
    /* 10. Compress
    Metodo que permite comprimir una imagen.
    Para lograr comprimir una imagen se debe contar cuantas veces se repite un color dentro de un pixel y devolver el
    que menos veces se repita.
    */

    public void Compress() {
        if (IsBitmap()) {
            List<Pixels> newpixeles = new ArraysList<Pixels>();
            int cero = 0;
            int uno = 0;
            for (Pixels p : pixeles) {
                if (((TDA_PixBit) p).getBit() == 0) {
                    cero++;
                } else {
                    uno++;
                }
            }
            for (Pixels p : pixeles) {
                if (cero < uno) {
                    if (((TDA_PixBit) p).getBit() == 0) {
                        Pixels newpixel = new TDA_PixBit(p.getX(), p.getY(), p.getDepth(),0);
                        newpixeles.add(newpixel);
                    }
                }
                if (cero > uno) {
                    if (((TDA_PixBit) p).getBit() == 1) {
                        Pixels newpixel = new TDA_PixBit(p.getX(), p.getY(), p.getDepth(),1);
                        newpixeles.add(newpixel);
                    }
                }
            }
            setPixeles(newpixeles);
        }
        if (IsPixmap()) {
            List<Pixels> newpixeles = new ArrayList<Pixels>();
            ArrayList<Integer> rojo = new ArrayList<Integer>(255);
            ArrayList<Integer> verde = new ArrayList<Integer>(255);
            ArrayList<Integer> azul = new ArrayList<Integer>(255);
            for (int i = 0; i < 255; i++) {
                rojo.add(0);
                verde.add(0);
                azul.add(0);
            }
            for (Pixels p : pixeles) {
                int r = ((TDA_PixRGB) p).getR();
                int g = ((TDA_PixRGB) p).getG();
                int b = ((TDA_PixRGB) p).getB();
                rojo.set(r - 1, rojo.get(r - 1) + 1);
                verde.set(g - 1, verde.get(g - 1) + 1);
                azul.set(b - 1, azul.get(b - 1) + 1);
            }
            int minr = 0;
            int ming = 0;
            int minb = 0;
            for (int i = 0; i < 255; i++) {
                if (rojo.get(i) < rojo.get(minr)) {
                    minr = i;
                }
                if (verde.get(i) < verde.get(ming)) {
                    ming = i;
                }
                if (azul.get(i) < azul.get(minb)) {
                    minb = i;
                }
            }
            for (Pixels p : pixeles) {
                if (((TDA_PixRGB) p).getR() == minr + 1 && ((TDA_PixRGB) p).getG() == ming + 1 && ((TDA_PixRGB) p).getB() == minb + 1) {
                    Pixels newpixel = new TDA_PixRGB(p.getX(), p.getY(), minr + 1, ming + 1, minb + 1, p.getDepth());
                    newpixeles.add(newpixel);
                }
            }
            setPixeles(newpixeles);
        }
        if (IsHexmap()) {
            List<Pixels> newpixeles = new ArrayList<Pixels>();
            ArrayList<String> hex = new ArrayList<String>();
            ArrayList<Integer> hexcount = new ArrayList<Integer>();
            for (Pixels p : pixeles) {
                String h = ((TDA_Pixhex) p).getHex();
                if (hex.contains(h)) {
                    int index = hex.indexOf(h);
                    hexcount.set(index, hexcount.get(index) + 1);
                } else {
                    hex.add(h);
                    hexcount.add(1);
                }
            }
            int min = 0;
            for (int i = 0; i < hex.size(); i++) {
                if (hexcount.get(i) < hexcount.get(min)) {
                    min = i;
                }
            }
            for (Pixels p : pixeles) {
                if (((TDA_Pixhex) p).getHex().equals(hex.get(min))) {
                    Pixels newpixel = new TDA_Pixhex(p.getX(), p.getY(), hex.get(min), p.getDepth());
                    newpixeles.add(newpixel);
                }
            }
            setPixeles(newpixeles);
        }
    }


    //________________________________________________________________________________________________________________
    /* 11. IsCompress
    Metodo que permite saber si una imagen esta comprimida o no.
    Para lograr saber si una imagen esta comprimida o no, se debe comparar que todos los pixeles tengan el mismo color.
     */

    public boolean IsCompress() {
        if (IsBitmap()) {
            int bit = ((TDA_PixBit) pixeles.get(0)).getBit();
            for (Pixels p : pixeles) {
                if (((TDA_PixBit) p).getBit() != bit) {
                    return false;
                }
            }
            return true;
        }
        if (IsPixmap()) {
            int r = ((TDA_PixRGB) pixeles.get(0)).getR();
            int g = ((TDA_PixRGB) pixeles.get(0)).getG();
            int b = ((TDA_PixRGB) pixeles.get(0)).getB();
            for (Pixels p : pixeles) {
                if (((TDA_PixRGB) p).getR() != r || ((TDA_PixRGB) p).getG() != g || ((TDA_PixRGB) p).getB() != b) {
                    return false;
                }
            }
            return true;
        }
        if (IsHexmap()) {
            String hex = ((TDA_Pixhex) pixeles.get(0)).getHex();
            for (Pixels p : pixeles) {
                if (!((TDA_Pixhex) p).getHex().equals(hex)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //________________________________________________________________________________________________________________
    /* 12. ChangePixel
    Metodo que recibe un pixel y lo cambia por otro pixel dentro de la imaagen.
     */

    public void ChangePixel(Pixels oldpixel, Pixels newpixel) {
        if (IsBitmap()) {
            if (oldpixel.getDepth() == 1 && newpixel.getDepth() == 1) {
                if (pixeles.contains(oldpixel)) {
                    int index = pixeles.indexOf(oldpixel);
                    pixeles.set(index, newpixel);
                }
            }
        }
        if (IsPixmap()) {
            if (oldpixel.getDepth() == 3 && newpixel.getDepth() == 3) {
                if (pixeles.contains(oldpixel)) {
                    int index = pixeles.indexOf(oldpixel);
                    pixeles.set(index, newpixel);
                }
            }
        }
        if (IsHexmap()) {
            if (oldpixel.getDepth() == 6 && newpixel.getDepth() == 6) {
                if (pixeles.contains(oldpixel)) {
                    int index = pixeles.indexOf(oldpixel);
                    pixeles.set(index, newpixel);
                }
            }
        }
    }

    //________________________________________________________________________________________________________________
    /* 13. InvertColorBit
    Metodo que invierte el bit dentro de PixBit.
     */

    public void InvertColorBit() {
        if (IsBitmap()) {
            for (Pixels p : pixeles) {
                int bit = ((TDA_PixBit) p).getBit();
                if (bit == 0) {
                    bit = 1;
                } else {
                    bit = 0;
                }
                Pixels newpixel = new TDA_PixBit(p.getX(), p.getY(), p.getDepth(), bit);
                ChangePixel(p, newpixel);
            }
        }
    }

    //________________________________________________________________________________________________________________
    /* 14. InvertColorRGB
    Metodo que invierte el valor R, G y B dentro de un PixRGB.
    Para lograr esto al valor numerico 255 se debe restar el valor R, G y B correspondiente.
    NewR = 255 - r
    NewG = 255 - g
    NewB = 255 - b
     */
    public void InvertColorRGB(){
        if (IsPixmap()){
            List<Pixels> newpixeles = new ArrayList<Pixels>();
            for (Pixels p: pixeles){
                int r = ((TDA_PixRGB)p).getR();
                int g = ((TDA_PixRGB)p).getG();
                int b = ((TDA_PixRGB)p).getB();
                int newR = (255 - r);
                int newG = (255 - g);
                int newB = (255 - b);
                Pixels newpixel = new TDA_PixRGB(p.getX(), p.getY(), newR, newG, newB, p.getDepth());
                newpixeles.add(newpixel);
            }
            setPixeles(newpixeles);
        }
    }
}