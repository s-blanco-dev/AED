package org.example.PD6;

public class Principal {
    public static void imprimirTablero(int largo, int ancho)
    {
       for (int i = 0; i < largo; i++) {
           for (int j = 0; j < ancho; j++) {
               System.out.print("#");
           }
           System.out.print("\n");
       }
    }

    public static void main(String[] args) {
        imprimirTablero(7, 7);
    }
}
