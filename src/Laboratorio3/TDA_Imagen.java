package Laboratorio3;

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

    public TDA_Imagen() {
    }


    //Getters
    public int getWidth(TDA_Imagen imagen) {
        return imagen.Width;
    }

    public int getHeight(TDA_Imagen imagen) {
        return imagen.Height;
    }

    public List<Pixels> getPixeles(TDA_Imagen imagen) {
        return imagen.pixeles;
    }

    //Setters
    public void setWidth(TDA_Imagen imagen, int newwidth) {
        imagen.Width = newwidth;
    }

    public void setHeight(TDA_Imagen imagen, int newheight) {
        imagen.Height = newheight;
    }

    public void setPixeles(TDA_Imagen imagen, List<Pixels> newpixeles) {
        imagen.pixeles = newpixeles;
    }

    //Metodos

    // 1. IsBitmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo Pixbit.
    public boolean IsBitmap() {
        for (Pixels p : pixeles) {
            if (p.getClass().getName().equals("Laboratorio3.TDA_Pixbit")) {
                return true;
            }
        }
        return false;
    }
    //________________________________________________________________________________________________________________

    // 2. IsPixmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo PixRGB.
    public boolean IsPixmap() {
        for (Pixels p : pixeles) {
            if (p.getClass().getName().equals("Laboratorio3.TDA_PixRGB")) {
                return true;
            }
        }
        return false;
    }


    //________________________________________________________________________________________________________________

    // 3. IsHexmap.
    // Metodo que verifica si la imagen esta compuesta por pixeles del tipo PixHex.
    public boolean IsHexmap() {
        for (Pixels p : pixeles) {
            if (p.getClass().getName().equals("Laboratorio3.TDA_Pixhex")) {
                return true;
            }
        }
        return false;
    }

    //________________________________________________________________________________________________________________

    // 4. FlipH
    // Metodo que invierte la imagen horizontalmente.
    // Cada pixel esta compuesto por coordenadas X e Y, además de la anchura de la imagen. Para lograr voltear la imagen
    // horizontalmente, se debe seguir la siguiente formula:
    // Flip = (Anchura - 1) - X

    public int z = getWidth(this) - 1;
    public int newcoordx = z - p.getX(p);

    public void FlipH() {
        for (Pixels p : pixeles) {
            p.setX(p, newcoordx);
        }
    }
    //________________________________________________________________________________________________________________

    // 5. FlipV
    // Metodo que invierte la imagen verticalmente.
    // Cada pixel esta compuesto por coordenadas X e Y, además de la altura de la imagen. Para lograr voltear la imagen
    // verticalmente, se debe seguir la siguiente formula:
    // Flip = (Altura - 1) - Y

    public int z = getHeight(this) - 1;
    public int newcoordy = z - p.getY(p);

    public void FlipV() {
        for (Pixels p : pixeles) {
            p.setY(p, newcoordy);
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
            if (p.getX(p) > x1 && p.getX(p) < x2 && p.getY(p) > y1 && p.getY(p) < y2) {
                newpixeles.add(p);
            }
        }
        setPixeles(this, newpixeles);
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
        List<Pixels> newpixeles = new ArrayList<Pixels>();
        for (Pixels p : pixeles) {
            if (IsPixmap(this)) {
                int r = p.getR(p);
                int g = p.getG(p);
                int b = p.getB(p);
                int newr = integer.toHexString(r);
                int newg = integer.toHexString(g);
                int newb = integer.toHexString(b);
                Pixels newpixel = new TDA_Pixhex(newr, newg, newb);
                newpixeles.add(newpixel);
            }
        }
        setPixeles(this, newpixeles);
    }

    //________________________________________________________________________________________________________________
    /* 8. ImagetoHistogram
     Metodo que crea un histograma de la imagen.
     Un histograma es una representación gráfica de la distribución de frecuencia de una variable. En este caso,
     la variable es el color de los pixeles de la imagen. Para crear un histograma, se debe 

}