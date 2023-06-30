/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafopractico;


/**
 *
 * @author valen
 */
class Nodo {
    Object elemento;
    Nodo siguiente;

    public Nodo(Object elemento) {
        this.elemento = elemento;
        siguiente = null;
    }
 }
class ColaLista {
   
    protected Nodo frente;
protected Nodo fin;
// constructor: crea cola vacía
public ColaLista()
{
 frente = fin = null;
}
// insertar: pone elemento por el final
public void insertar(Object elemento)
{
 Nodo a;
 a = new Nodo(elemento);
 if (colaVacia())
 {
 frente = a;
 }
 else
 {
 fin.siguiente = a;
 }
 fin = a;
}
// quitar: sale el elemento frente
public Object quitar() throws Exception
{ 
 Object aux;
 if (!colaVacia())
 {
 aux = frente.elemento;
 frente = frente.siguiente;
 }
 else 
 throw new Exception("Eliminar de una cola vacía");
 return aux;
}
// libera todos los nodos de la cola
public void borrarCola()
{
 for (; frente != null;)
 { 
 frente = frente.siguiente;
 }
 System.gc();
} 
// acceso al primero de la cola
public Object frenteCola() throws Exception
{
 if (colaVacia())
 {
 throw new Exception("Error: cola vacía");
 } 
 return (frente.elemento);
}
// verificación del estado de la cola
public boolean colaVacia()
{
 return (frente == null);
} 
}
public class RecorreGrafo {
    public static final int CLAVE = -1;

    public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
        int w, v;
        int[] m;
        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");
        ColaLista cola = new ColaLista();
        m = new int[g.numeroDeVertices()];
        // inicializa los vértices como no marcados
        for (int i = 0; i < g.numeroDeVertices(); i++)
            m[i] = CLAVE;
        m[v] = 0; // vértice origen queda marcado
        cola.insertar(v);
        while (!cola.colaVacia()) {
            int cw = (int) cola.quitar();
            w = cw;
            System.out.println("Vértice " + g.obtenerVertice(w).nomVertice() + " visitado");
            // inserta en la cola los adyacentes de w no marcados
            for (int u = 0; u < g.numeroDeVertices(); u++) {
                if ((g.obtenerMatAd()[w][u] == 1) && (m[u] == CLAVE)) {
                    // se marca vertice u con número de arcos hasta él
                    m[u] = m[w] + 1;
                    cola.insertar(u);
                }
            }
        }
        return m;
    }
}
