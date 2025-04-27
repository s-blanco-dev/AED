package org.example.UT4.PD2;

public class Main {
    public static void main(String[] args) {

        /*
        * EJERCICIO #2
         */
      TArbolBB arbolBB = new TArbolBB();
       String[] contenido = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT4/PD2/claves/clavesPrueba.txt");

       for (String linea : contenido) {
           Integer valorEntero = Integer.parseInt(linea);
           TElementoAB<Integer> elElemento = new TElementoAB<>(valorEntero, valorEntero);
           arbolBB.insertar(elElemento);
       }

       String[] preorden = arbolBB.preOrden().split("-");
       String[] inorden = arbolBB.inOrden().split("-");
       String[] postorden = arbolBB.postOrden().split("-");

       ManejadorArchivosGenerico.escribirArchivo("src/main/java/org/example/UT4/PD2/preorden.txt", preorden);
       ManejadorArchivosGenerico.escribirArchivo("src/main/java/org/example/UT4/PD2/inorden.txt", inorden);
       ManejadorArchivosGenerico.escribirArchivo("src/main/java/org/example/UT4/PD2/postorden.txt", postorden);

        /*
         * EJERCICIO #3
         */

        TArbolBB arbolete = new TArbolBB();
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT4/PD2/claves/claves1.txt");

        for (String linea : claves) {
            Integer valorEntero = Integer.parseInt(linea);
            TElementoAB<Integer> elElemento = new TElementoAB<>(valorEntero, valorEntero);
            arbolete.insertar(elElemento);
        }

        boolean existe1 = arbolete.buscar((Integer)10635) != null;
        boolean existe2 = arbolete.buscar((Integer)4567) != null;
        boolean existe3 = arbolete.buscar((Integer)12) != null;
        boolean existe4 = arbolete.buscar((Integer)8978) != null;

        System.out.println("Existe 10635: " + existe1);
        System.out.println("Existe 4567: " + existe2);
        System.out.println("Existe 12: " + existe3);
        System.out.println("Existe 8978: " + existe4);

        System.out.println(arbolete.preOrden());
    }
}
