/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafopractico;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author valen
 */
public class GrafoPractico {

    public static void main(String[] args) {
        ArrayList<Vertice> letras = new ArrayList<Vertice>();
        letras.add(new Vertice("A"));
        letras.add(new Vertice("B"));
        letras.add(new Vertice("C"));
        letras.add(new Vertice("D"));
        letras.add(new Vertice("H"));
        letras.add(new Vertice("R"));
        letras.add(new Vertice("T"));
        try {
            GrafoMatriz matrizAdyacencia = new GrafoMatriz(letras.size());
            matrizAdyacencia.mostrarMatriz();
            System.out.println();
            System.out.println("---------------------");
            System.out.println();
            Iterator<Vertice> it = letras.iterator();
            while (it.hasNext()) {
                matrizAdyacencia.nuevoVertice(it.next().nomVertice());
            }
            System.out.println("Matriz de Adyacencia inicializada");
            System.out.println("");
            matrizAdyacencia.mostrarMatriz();
            System.out.println();
            System.out.println("------------------");
            System.out.println();
            matrizAdyacencia.nuevoArco("D", "B");
            matrizAdyacencia.setPeso("D","B",8);
            matrizAdyacencia.nuevoArco("D", "C");
            matrizAdyacencia.setPeso("D","C",3);
            matrizAdyacencia.nuevoArco("B", "H");
            matrizAdyacencia.setPeso("B","H",6);
            matrizAdyacencia.nuevoArco("C", "R");
            matrizAdyacencia.setPeso("C","R",9);
            matrizAdyacencia.nuevoArco("R", "H");
            matrizAdyacencia.setPeso("R","H",1);
            matrizAdyacencia.nuevoArco("H", "A");
            matrizAdyacencia.setPeso("H","A",12);
            matrizAdyacencia.nuevoArco("H", "T");
            matrizAdyacencia.setPeso("H","T",11);
            
            System.out.println("Matriz de Adyacencia con sus pesos");
            System.out.println("");
            matrizAdyacencia.mostrarMatriz();
            System.out.println("-----------------");
            System.out.println();

            RecorreGrafo.recorrerAnchura(matrizAdyacencia, "D");
            
        } catch (Exception ex) {
            Logger.getLogger(GrafoPractico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
