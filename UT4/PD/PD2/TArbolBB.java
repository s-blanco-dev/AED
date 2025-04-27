package org.example.UT4.PD2;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class TArbolBB<T> implements IArbolBB<T> {
    private int contadorInserciones;

    /**
     * Nodo raíz del árbol binario de búsqueda.
     */
    protected TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista.
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    /**
     * Constructor por defecto de la clase TArbolBB. Crea un árbol vacío.
     */
    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    /**
     * Inserta un elemento en el árbol
     * @param unElemento Elemento a insertar
     * @return -> Fue insertado o no
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = (TElementoAB<T>) unElemento;
            contadorInserciones++;  // Incrementamos el contador
            System.out.println("Elemento insertado. Contador de inserciones: " + contadorInserciones);
            return true;
        } else {
            boolean resultado = raiz.insertar((TElementoAB<T>) unElemento);
            if (resultado) {
                contadorInserciones++;  // Incrementamos el contador
                System.out.println("Elemento insertado. Contador de inserciones: " + contadorInserciones);
            }
            return resultado;
        }
    }

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }

    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public String inOrden() {
        if(!esVacio()) {
           return raiz.inOrden();
        }
        return "";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if(!esVacio()) {
            return raiz.preOrden();
        }
        return "";
    }


    @Override
    public String postOrden() {
        if(!esVacio()) {
           return raiz.postOrden();
        }
        return "";
    }

    public int altura() {
        if (raiz == null) {
            return -1;
        }
        return raiz.alturaAux();
    }

    /**
     * Obtiene el nivel de un nodo encontrado mediante su etiqueta
     * @param unaEtiqueta -> la etiqueta del nodo cuyo nivel se desea obtener
     * @return -> nivel del nodo en cuestión
     */
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivelActual = 0;
        TElementoAB<T> actual = this.raiz;

        while (actual != null) {
            int comparacion = unaEtiqueta.compareTo(actual.getEtiqueta());
            if (comparacion == 0) {
                return nivelActual;
            }

            if (comparacion < 0) {
                actual = actual.getHijoIzq();
                nivelActual++;
            }
            else {
                actual = actual.getHijoDer();
                nivelActual++;
            }
        }

        return -1; /* Nodo no encontrado */
    }

    public int obtenerTamanio() {
        if (esVacio()) {
            return 0;
        }
        return this.raiz.obtenerTamanio();
    }
}