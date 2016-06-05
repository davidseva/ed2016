/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David Seva Amorós
 */
public class Lists {
    
    
    
    
    /**
     * Método para rellenar el ArrayList y el LinkedList.
     * Genera 1000 números enteros al azar entre 1 y 5
     * @param li
    
     */    
     
    public static void RellenarLista(List<Integer> li)
    {
        Random r = new Random();
        for(int i=0; i<1000; i++)
        {
            li.add(i, r.nextInt(5)+1);            
        }       
        
    }
    
    /**
     * Método que pasará todos los test para medir tiempos
     * @param al
     * @param ll
     */
    public static void RunTimes(List<Integer> al, List<Integer> ll)
    {
        try {
            // Para escribir en fichero 
            FileWriter fw = new FileWriter("Lists.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            // Rellenamos las listas
            RellenarLista(al);
            RellenarLista(ll);
            // Variables que indican los tamaños de las listas
            int TamAl = al.size();
            int TamLl = ll.size();           
            long TInicio, T1, t1al, t1alSuma=0, t1alMedia; // Variables para determinar el tiempo de ejecución            
            // Test 1. Insertar un elemento al final de la lista
            int elemAnyadir = 7;
            // Realizamos la medida de tiempo 50 veces y sacamos la media
            for(int j=0;j<50;j++)
            {            
            TInicio = System.nanoTime(); // Retorna la hora en nanosegundos
            al.add(elemAnyadir); // Lo añadimos
            T1 = System.nanoTime(); // Tomamos la hora en que finalizó el algoritmo            
            t1al = T1 - TInicio; // Calculamos los nanosegundos de diferencia
            t1alSuma += t1al; // Sumamos las diferencias
            al.remove(TamAl-1); // Lo borramos
            }
            t1alMedia = t1alSuma / 50; // Calculamos la media de las 1000 medidas
            long T1bis, t1ll, t1llSuma=0, t1llMedia;
            for(int k=0;k<20;k++)
            {
            T1 = System.nanoTime();
            ll.add(elemAnyadir); // Lo añadimos
            T1bis = System.nanoTime();
            t1ll = T1bis - T1;
            t1llSuma += t1ll;            
            ll.remove(TamAl-1); // Lo borramos
            }
            t1llMedia = t1llSuma / 50;
            // Test 2. Insertar un elemento al principio de la lista
            long T2, T2bis, t2al=0, t2ll, t2alSuma=0, t2alMedia, t2llSuma=0, t2llMedia;
            for (int l=0;l<50;l++)
            {
            T1bis = System.nanoTime();
            al.add(0, 12); // Inserción
            T2 = System.nanoTime();
            t2al = T2 - T1bis;
            t2alSuma += t2al;
            al.remove(0); // borramos
            }
            t2alMedia = t2al / 50;
            for(int m=0;m<20;m++)
            {
            T2 = System.nanoTime();
            ll.add(0, 12); // insercion
            T2bis = System.nanoTime();
            t2ll = T2bis - T2;
            t2llSuma += t2ll;
            ll.remove(0); // borrado
            }
            t2llMedia = t2llSuma / 50;           
            
            // Test 3. Insertar un elemento a mitad de la lista
            long T3, T3bis, t3al, t3ll, t3alSuma=0, t3alMedia, t3llSuma=0, t3llMedia;
            for(int m=0;m<50;m++)
            {
            T2bis = System.nanoTime();
            al.add((TamAl/2)-1, 11); // inserción
            T3 = System.nanoTime();
            t3al = T3 - T2bis;
            t3alSuma += t3al;
            al.remove((TamLl/2)-1); // borrado 
            }
            t3alMedia = t3alSuma / 50;
            for(int n=0;n<50;n++)
            {
            T3 = System.nanoTime();
            ll.add((TamAl/2)-1, 11); // inserción
            T3bis = System.nanoTime();
            t3ll = T3bis - T3;
            t3llSuma += t3ll;
            ll.remove((TamLl/2)-1); // borrado 
            }
            t3llMedia = t3llSuma / 50;
            
            // Test 4. Borrar el elemento al final de la lista
            long T4, T4bis, t4al, t4ll, t4alSuma=0, t4alMedia, t4llSuma=0, t4llMedia;
             for(int n=0;n<50;n++)
            {
            T3bis = System.nanoTime();
            al.remove(TamAl-1); // borrado
            T4 = System.nanoTime();
            t4al = T4 - T3bis;
            t4alSuma += t4al;
            al.add(elemAnyadir);  // inserción de otro elemento
            }
            t4alMedia = t4alSuma / 50;
            for(int o=0;o<50;o++)
            {
            T4 = System.nanoTime();
            ll.remove(TamLl-1); // borrada
            T4bis = System.nanoTime();
            t4ll = T4bis - T4;
            t4llSuma += t4ll;
            ll.add(elemAnyadir);  // inserción de otro elemento
            }
            t4llMedia = t4llSuma / 50;
            
            // Test 5. Borrar el elemento al principio de la lista
            long T5, T5bis, t5al, t5ll, t5alSuma=0, t5alMedia, t5llSuma=0, t5llMedia;
             for(int o=0;o<50;o++)
             {
            T4bis = System.nanoTime();
            al.remove(0); // borrado
            T5 = System.nanoTime();
            t5al = T5 - T4bis;
            t5alSuma += t5al;
            al.add(0, 12); // Inserción
             }
            t5alMedia = t5alSuma / 50;
             for(int p=0;p<50;p++)
             {
            T5 = System.nanoTime();
            ll.remove(0); // borrado
            T5bis = System.nanoTime();
            t5ll = T5bis - T5;
            t5llSuma += t5ll;
            al.add(0, 12); // Inserción
             }
            t5llMedia = t5llSuma / 50;            
           
            // Test 6. Borrar el elemento en el medio de la lista
            long T6, T6bis, t6al, t6ll, t6alSuma=0, t6alMedia, t6llSuma=0, t6llMedia;
            for(int q=0;q<50;q++)
            {
            T5bis = System.nanoTime();
            al.remove((TamLl/2)-1); // borramos
            T6 = System.nanoTime();
            t6al = T6 - T5bis;
            t6alSuma += t6al;
            al.add(0, 12); // Inserción
            }
            t6alMedia = t6alSuma / 50;
            for(int r=0;r<50;r++)
            {
            T6 = System.nanoTime();
            ll.remove((TamLl/2)-1); // borramos
            T6bis = System.nanoTime();
            t6ll = T6bis - T6;
            t6llSuma += t6ll;
            ll.add(0, 12); // Inserción
            }
            t6llMedia = t6llSuma / 50;
            
            // Test 7. Borrar el elemento (por su valor)que hay al final de la lista           
            long T7, T7bis, t7al, t7ll, t7alSuma=0, t7alMedia, t7llSuma=0, t7llMedia;
            // Añadimos previamente el elemento al final de la lista
            for(int r=0;r<50;r++)
            {
            al.add(18);            
            long T7inicial = System.nanoTime();
            // Borramos el elemento por su valor, sólo se encuentra en la última posiciòn
            al.remove(18);
            T7 = System.nanoTime();
            t7al = T7 - T7inicial;
            t7alSuma += t7al;
            }
            t7alMedia = t7alSuma / 50;
            for(int r=0;r<50;r++)
            {
            ll.add(18);
            T7 = System.nanoTime();
            ll.remove(18);
            T7bis = System.nanoTime();
            t7ll = T7bis - T7; 
            t7llSuma += t7ll;
            }
            t7llMedia = t7llSuma / 50;
            // Test 8. Borrar el elemento (por su valor)que hay al principio de la lista
            long T8, T8bis, t8al, t8ll, t8alSuma=0, t8alMedia, t8llSuma=0, t8llMedia;
            for(int s=0;s<50;s++)
            {
            al.add(0, 24); // Primero  añadimos el elemento al principio de las listas            
            long T8inicial = System.nanoTime();
            al.remove(24); // elimina el elemento especificado desde el principio de la lista, lógicamente el primero
            T8 = System.nanoTime(); 
            t8al = T8 - T8inicial;
            t8alSuma += t8al;
            }
            t8alMedia = t8alSuma / 50;
            
            for(int t=0;t<50;t++)
            {
                ll.add(0, 24); 
                T8 = System.nanoTime();
            ll.remove(24);
            T8bis = System.nanoTime();
            t8ll = T8bis - T8;
            t8llSuma += t8ll;
            }
            t8llMedia = t8llSuma / 50;
            // Test 9. Borrar el elemento (por su valor)que hay en medio de la lista
            long T9, T9bis, t9al, t9ll, t9alSuma=0, t9alMedia, t9llSuma=0, t9llMedia;
            
            
            for(int u=0;u<50;u++)
            {
                // Añadimos el elemento en una posición concreta, ni al principio, ni al final
                al.add(440, 29);
            
            long T9inicial = System.nanoTime();
            al.remove(29);
            T9 = System.nanoTime();
            t9al = T9 - T9inicial;
            t9alSuma += t9al;
            }
            t9alMedia = t9alSuma / 50;
            for(int v=0;v<50;v++)
            {
            ll.add(440, 29);
            T9 = System.nanoTime();
            ll.remove(29);
            T9bis = System.nanoTime();
            t9ll = T9bis - T9;
            t9llSuma += t9ll;
            }
            t9llMedia = t9llSuma / 50;
            // Test 10. Vaciar completamente la lista
            long T10, T10bis, t10al, t10ll, t10alSuma=0, t10alMedia, t10llSuma=0, t10llMedia;
            for(int v=0;v<50;v++)
            {
            T9bis = System.nanoTime();
            al.clear();
            T10 = System.nanoTime();
            t10al = T10 - T9bis;
            t10alSuma += t10al;
            // La volvemos a llenar
            RellenarLista(al);
            }
            t10alMedia = t10alSuma / 50;
            for(int w=0;w<50;w++)
            {
            T10 = System.nanoTime();
            ll.clear();
            T10bis = System.nanoTime();
            t10ll = T10bis - T10;
            t10llSuma += t10ll;
            RellenarLista(ll);
            }
             t10llMedia = t10llSuma / 50;            
            
            // Test 11. Buscar si existe un elemento en la lista utilizando las funciones que tenga la propia lista
            long T11, T11bis, t11al, t11ll, t11alSuma=0, t11alMedia, t11llSuma=0, t11llMedia;
             for(int y=0;y<50;y++)
            {
            T10bis = System.nanoTime();
            boolean AL11 = al.contains(2); // mira si contiene el 2                
            T11 = System.nanoTime();
            t11al = T11 - T10bis;
            t11alSuma += t11al;
            }
             t11alMedia = t11alSuma / 50;
             for(int z=0;z<50;z++)
             {
            T11 = System.nanoTime();
             boolean LL11 = ll.contains(2);                
            T11bis = System.nanoTime();
            t11ll = T11bis - T11;
            t11llSuma += t11ll;
             }
            t11llMedia = t11llSuma / 50;
            
            
            //Test 12. Buscar si existe un elemento en la lista. Este algoritmo se tiene que implementar
            long T12, T12bis, t12al, t12ll, t12alSuma=0, t12alMedia, t12llSuma=0, t12llMedia;
            for(int a=0;a<50;a++)
            {
            T11bis = System.nanoTime();
            for(int j=0; j<TamAl; j++)  
            {
                if(al.get(j) == 2)
                {                    
                    break;
                }                
            }
            T12 = System.nanoTime();
            t12al = T12 - T11bis;
            t12alSuma += t12al;
            }
            t12alMedia = t12alSuma / 50;
            
            for(int a=0;a<50;a++)
            {
            T12 = System.nanoTime();
            for(int k=0; k<TamLl; k++)
            {
                if(ll.get(k) == 2)
                {
                    break;
                }
                
            }            
            T12bis = System.nanoTime();
            t12ll = T12bis - T12;
            t12llSuma += t12ll;
            }
            t12llMedia = t12llSuma / 50;
            
            // Test 13. Buscar un elemento de forma binaria en la lista. Este algoritmo se tiene que implementar
            long T13, T13bis, t13al, t13ll, t13alSuma=0, t13alMedia, t13llSuma=0, t13llMedia;
            for(int a=0;a<50;a++)
            {
            T12bis = System.nanoTime();
            int numero = BusquedaBinaria(al, 0, TamAl-1, 2);         
            T13 = System.nanoTime();
            t13al = T13 - T12bis;
            t13alSuma += t13al;
            }
            t13alMedia = t13alSuma / 50;
            for(int a=0;a<50;a++)
            {
            T13 = System.nanoTime();
            int numero1 = BusquedaBinaria(ll, 0, TamAl-1, 2);            
            T13bis = System.nanoTime();
            t13ll = T13bis - T13;
            t13llSuma += t13ll;
            }
            t13llMedia = t13llSuma / 50;
            pw.println("PARTE 1");
            pw.println("          Test                          ArrayList       LinkedList");
            pw.println("------------------------------------    ---------       ----------");
            pw.println("1.Insertar al final de la lista" + "         " + t1alMedia +  "            " + t1llMedia);
            pw.println("2.Insertar al principio de la lista" + "     " + t2alMedia +  "            " + t2llMedia);
            pw.println("3.Insertar a mitad de la lista" + "          " + t3alMedia +  "            " + t3llMedia);
            pw.println("4.Borrar al final de la lista" + "           " + t4alMedia +  "            " + t4llMedia);
            pw.println("5.Borrar al principio de la lista" + "       " + t5alMedia +  "            " + t5llMedia);
            pw.println("6.Borrar en medio de la lista" + "           " + t6alMedia +  "            " + t6llMedia);
            pw.println("7.Borrar al final por su valor" + "          " + t7alMedia +  "            " + t7llMedia);
            pw.println("8.Borrar al principio por su valor" + "      " + t8alMedia +  "            " + t8llMedia);
            pw.println("9.Borrar en medio por su valor" + "          " + t9alMedia +  "            " + t9llMedia);
            pw.println("10.Vaciado completo de la lista" + "         " + t10alMedia +  "            " + t10llMedia);
            pw.println("11.Búsqueda usando funciones propias" + "    " + t11alMedia +  "            " + t11llMedia);
            pw.println("12.Búsqueda implementando funciones" + "      " + t12alMedia +  "            " + t12llMedia);
            pw.println("13.Búsqueda de forma binaria" + "             " + t13alMedia +  "            " + t13llMedia);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // método de búsqueda binaria de forma recursiva
    public static int BusquedaBinaria(List<Integer> li, int izq, int der, int dato)
    {
        // se encuentra la mitad del vector o intervalo
        int m = (int) ((izq + der) / 2);
        // se verifica si el número no está en el arreglo
        if((izq == der && li.get(m)!= dato || li.get(der) < dato || li.get(izq) > dato))
            return -1;
        
        if(li.get(m) == dato)
            return m;
        else
        {
            // verifica si el dato buscado esta a la izquierda
            if(li.get(m) > dato)
                return BusquedaBinaria(li, izq, m-1, dato);
            else
                return BusquedaBinaria(li, m+1, der, dato);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> lista = new ArrayList<>();
        List<Integer> listaEnlazada = new LinkedList<>();
        
        RunTimes(lista, listaEnlazada);
    }
    
}
