/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author CNM
 */
public class Sort {

    // Realiza intercambio    
    public static void Intercambiar(List<Integer> li, int indiceOrigen, int indiceDestino)
    {
        int temp = li.get(indiceDestino);
        li.set(indiceDestino, li.get(indiceOrigen));
        li.set(indiceOrigen, temp);
    }
    
    // Bubble sort
    public static void BubbleSort(List<Integer> li)
    {
        int aux;
        Random r = new Random();
        //Variable que nos permite saber si ha habido movimiento durante la ronda
		//Si en una ronda no hay movimiento, el programa sale, ya que ya está la lista ordenada
		boolean movimiento = true;
		//Contador que nos indica cuantas rondas comparando parejas llevamos en el bucle
		int contRondas = 0;
		//Mientras que haya movimiento, comprobaremos las posiciones
		while(movimiento){
			/* Iniciamos el boleano como falso, y si cambia durante el bucle, es que ha habido un movimiento */
			movimiento = false;
			/*comenzamos el bucle en 1, y comparamos con el anterior para no salirnos de los lÃ­mites
			de la array */
			for(int i=1;i<li.size()-contRondas;i++){
				/* Si el número de la derecha es menor que el de la izquierda, los intercambia */
				if(li.get(i)<li.get(i-1)){
					/*Como ha habido movimiento, lo indicamos en el boleano que tenemos
					 * así cuando acabe el bucle, comenzará de nuevo
					 */
					movimiento=true;
					/* intercambiamos las posiciones */
					/* guardamos uno de los valores temporalmente en otra variable para evitar su pérdida */
					aux = li.get(i);
					//Intercambiamos los valores en sendas posiciones
					li.set(i,li.get(i-1));
					li.set(i-1, aux);
                                        
				}
			}
		}
		
        
        
    }
    // Selection sort
    public static void SelectionSort(List<Integer> li)
    {
        int i, j;
        int smallInt = 0, smallIntIndex = 0;
        for(i = 0; i < li.size(); i++)
        {
            smallInt = li.get(i);
            smallIntIndex = i;
            
            for (j = i+1; j < li.size(); j++)
            {
                if(li.get(j) < smallInt)
                { // actualizamos el más pequeño
                    smallInt = li.get(j);
                    smallIntIndex = j;
                }
            }
            // Intercambiamos el elmento más pequeño con el primer elemento
            Intercambiar(li, i, smallIntIndex);
        }
        
    }
    // Insertion sort
    public static void InsertionSort(List<Integer> li)
    {
        
        for (int i=1;  i<li.size(); i++)
        {
            int key = li.get(i); 
            for(int j=i-1; j>=0; j--)
            {
                if(key<li.get(j))
                { // asignamos cada elementos a su posición correcta mientras la clave sea menor que los elementos
                    li.set(j+1, li.get(j));
                    // Caso especial cuandotodos los elementos son menores que la clave
                    if(j==0)
                        li.set(0,key);
                }
                else
                {   // Asignamos el valor clave después del elemento del índice actual
                    li.set(j+1,key);
                    break; // Salimos del bucle 
                }
            }
        }
                
    }
    // Quick sort, hemos de dividir la lista en 2
    
    
    public static void QuickSort(List<Integer> list) {
    Sort(list, 0, list.size() - 1);
    }

public static void Sort(List<Integer> list, int from, int to) {
    if (from < to) {
        int pivot = from;
        int left = from + 1;
        int right = to;
        int pivotValue = list.get(pivot);
        while (left <= right) {
            // left <= to -> limit protection
            while (left <= to && pivotValue >= list.get(left)) {
                left++;
            }
            // right > from -> limit protection
            while (right > from && pivotValue < list.get(right)) {
                right--;
            }
            if (left < right) {
                Collections.swap(list, left, right);
            }
        }
        Collections.swap(list, pivot, left - 1);
        Sort(list, from, right - 1);
        Sort(list, right + 1, to);   
    }
}

    // Merge sort, divide la lista desordenada en N sublistas de 1 elemento,
    // luego las fusionamos repetidamente para producir nuevas sublistas hasta que
    // quede una lista, que estará ordenada
    public static List<Integer>  MergeSort(List<Integer> li)
    {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
    int center;
 
    if (li.size() == 1) {    
        return li;
    } else {
        center = li.size()/2;
        // copy the left half of whole into the left.
        for (int i=0; i<center; i++) {
                left.add(li.get(i));
        }
 
        //copy the right half of whole into the new arraylist.
        for (int i=center; i<li.size(); i++) {
                right.add(li.get(i));
        }
 
        // Sort the left and right halves of the arraylist.
        left  = MergeSort(left);
        right = MergeSort(right);
 
        // Merge the results back together.
        Merge(left, right, li);
    }
    return li;
                
    }
    
    // Método Merge para fusionar las N sublista a una lista ordenada
    public static void Merge(List<Integer> left, List<Integer> right, List<Integer> whole) {
    int leftIndex = 0;
    int rightIndex = 0;
    int wholeIndex = 0;
    //  Mientras no se use ni el ArrayList right ni el left, toma el más pequeño de left.get(leftIndex)
    // o right.get(rightIndex) y añade a whole.get(wholeIndex)    
    while (leftIndex < left.size() && rightIndex < right.size()) {
        if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
            whole.set(wholeIndex, left.get(leftIndex));
            leftIndex++;
        } else {
            whole.set(wholeIndex, right.get(rightIndex));
            rightIndex++;
        }
        wholeIndex++;
    }
 
    List<Integer> rest;
    int restIndex;
    if (leftIndex >= left.size()) {
        // Usa el ArrayList left       
        rest = right;
        restIndex = rightIndex;
    } else {
        // Usa el ArrayList right        
        rest = left;
        restIndex = leftIndex;
    }
    // Copia el resto del ArrayList que no se usó (left o right)   
    for (int i=restIndex; i<rest.size(); i++) {
        whole.set(wholeIndex, rest.get(i));
        wholeIndex++;
    }
}
    
    // Búsqueda binaria, el vector debe estar ordenado previamente. Devuelve la posición
    // del número a encontrar en la lista
    public static int BusquedaBinaria(List<Integer> li, int numero)
    {
        
         int posicion;
         // Mediante búsqueda binaria, devuelve la posición del número en la lista
         posicion = Collections.binarySearch(li, numero);   
         return posicion;
         
    }
    

    /**
     * Búsqueda secuencial. Recorre la lista desde el principio, cuando encuentra el dato,
     * sale del bucle, sino lo encuentra, devuelve -1
     * @param li
     * @param dato
     * @return
     */
        public static int BusquedaSecuencial(List<Integer> li, int dato)
    {
        int posicion = -1;
        for(int i = 0; i<li.size(); i++)
        {
            if(li.get(i) == dato)
            {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    // Muestra el contenido de la lista
    public static void MostrarLista(List<Integer> li)
    {
        for (int i=0; i<li.size(); i++)
        {
            System.out.println(i+1+": "+li.get(i));
        }
    }
    
       
    // Rellenamos la lista con 1000 entradas de número del 1 al 5 aleatoriamente
    public static void RellenarListas(List<Integer> li)
    {
        Random r = new Random();
        for(int i=0; i<1000; i++)
        {
            li.add(i, r.nextInt(5)+1);
            
        }       
        
    }
    // Método que realiza una serie de test para comprobar que los algoritmos son correctos,
    // saca un mensaje por consola diciendo si es o no correcto
    public static void RunTests(ArrayList<Integer> li) throws IOException
    {
        
        li = new ArrayList<>();
        // Rellenamos la lista
        RellenarListas(li);
        // Lista ordenada con el método Sort
       li.sort(null);
       // Hacemos una copia de la lista
       List<Integer> copia = new ArrayList<>();
       copia =(ArrayList) li.clone();
       // Ordenamos por burbuja
       BubbleSort(li);
       if(ComprobarListas(li, copia))
           System.out.println("Bubble Sort correcto");
       else
           System.out.println("Bubble Sort incorrecto");
       // Volvemos a dejar el array como estaba al inicio
       li = (ArrayList<Integer>) copia;       
       // Ordenamos por selección
       SelectionSort(li);
       if(ComprobarListas(li, copia))
           System.out.println("Selection Sort correcto");
       else
           System.out.println("Selection Sort incorrecto");
       // Volvemos a dejar el array como estaba al inicio
       li = (ArrayList<Integer>) copia;    
       InsertionSort(li);
       if(ComprobarListas(li, copia))
           System.out.println("Insertion Sort correcto");
       else
           System.out.println("Insertion Sort incorrecto");
       // Volvemos a dejar el array como estaba al inicio
       li = (ArrayList<Integer>) copia;      
       QuickSort(li);
       if(ComprobarListas(li, copia))
           System.out.println("Quick Sort correcto");
       else
           System.out.println("Quick Sort incorrecto");
       // Volvemos a dejar el array como estaba al inicio
       li = (ArrayList<Integer>) copia;
       List<Integer> ali = new ArrayList<>();
       ali = MergeSort(li);
       if(ComprobarListas(ali, copia))
           System.out.println("Merge Sort correcto");
       else
           System.out.println("Merge Sort incorrecto");
       // Buscamos el número 2, la lista está ordenada previamente
       int encBusqBin = BusquedaBinaria(li, 2);
       System.out.println("Busqueda binaria: 2 encontrado en la posición: "+ encBusqBin+". Correcto");     
       int encBusqSec = BusquedaSecuencial(li,2);
       System.out.println("Busqueda secuencial: 2 encontrado en la posición: "+ encBusqSec+". Correcto");
       
    }
    // Método usado para comprobar los elementos de dos listas, si son todos iguales devuelve true
    public static boolean ComprobarListas(List<Integer> li, List<Integer> li_copia)
    {
        int contador=0;
        for(int i=0; i<li.size(); i++)
       {// si hay algun elemento diferente en la misma posición, lo guarda en una variable
           if(!Objects.equals(li.get(i), li_copia.get(i)))
               contador++;
       }
        if(contador == 0)
            return true;
        else return false;
    }
    // Método que mide los tiempos de cada algoritmo
    public static void RunTimes(List<Integer> li)
    {
            FileWriter fw = null;
        try {
            // Para escribir en fichero
            fw = new FileWriter("resultados.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            // Relleno las listas de forma aleatoria
            li = ListaAleatoria();
            // Variables que indica el tamaño de las listas
            int Tamanyo = li.size();
            long TInicio, T1, t1, t1Suma=0, t1Media; // Variables de inicio para determinar el tiempo de ejecución
             // Bubble sort
            for(int a=0;a<50;a++)
            {
                TInicio = System.nanoTime(); // Retorna la hora en milisegundos           
            BubbleSort(li);
            T1 = System.nanoTime(); // Tomamos la hora en que finalizó el algoritmo
            t1 = T1 - TInicio; // Calculamos los milisegundos de diferencia
            t1Suma += t1;
            li = ListaAleatoria(); // Volvemos a rellenar aleatoriamente
            }
            t1Media = t1Suma / 50;
            // Selection sort
            long  T2, t2, t2Suma=0, t2Media;
            for(int a=0;a<50;a++)
            {
                T1 = System.nanoTime();            
            SelectionSort(li);
            T2 = System.nanoTime();
            t2 = T2 - T1;
            t2Suma += t2;
             li = ListaAleatoria(); // Volvemos a rellenar aleatoriamente
            }
            t2Media = t2Suma / 50;
                    
            // Insertion sort
            long  T3, t3, t3Suma=0, t3Media;
             for(int a=0;a<50;a++)
            {
                T2 = System.nanoTime();
            InsertionSort(li);
            T3 = System.nanoTime();
            t3 = T3 - T2;
            t3Suma += t3;
            li = ListaAleatoria(); // Volvemos a rellenar aleatoriamente
            }
             t3Media = t3Suma / 50;
            // Quick sort
            long  T4, t4, t4Suma=0, t4Media;
             for(int a=0;a<50;a++)
            {
                T3 = System.nanoTime();
            QuickSort(li);
            T4 = System.nanoTime();
            t4 = T4 - T3;
            t4Suma += t4;
            li = ListaAleatoria(); // Volvemos a rellenar aleatoriamente
            }
             t4Media = t4Suma / 50;
            // Merge sort
            long  T5, t5, t5Suma=0, t5Media;
             for(int a=0;a<50;a++)
            {
            List<Integer> ali = new ArrayList<>();
            T4 = System.nanoTime();
            ali = MergeSort(li);
            T5 = System.nanoTime();            
            t5 = T5 - T4;
            t5Suma += t5;
            ali = ListaAleatoria();
            }
             t5Media = t5Suma / 50;
            // Búsqueda binaria
             long  T6, t6, t6Suma=0, t6Media;
             for(int a=0;a<50;a++)
            {
             T5 = System.nanoTime();            
            int encBusqBin = BusquedaBinaria(li, 2);
            T6 = System.nanoTime();
            T6 = T6 - T5;
            t6Suma += T6;
            }
            t6Media = t6Suma / 50;
            // Búsqueda secuencial
            long  T7, t7, t7Suma=0, t7Media;
            for(int a=0;a<50;a++)
            {
            T6 = System.nanoTime();
            int encBusqSec = BusquedaSecuencial(li, 2);
            T7 = System.nanoTime();
            t7 = T7 - T6;
            t7Suma += t7;
            }
            t7Media = t7Suma / 50;
            // Borro la lista
            li.clear();
            
            ;
            // Ahora con lista ordenada
            // Rellenamos con una lista ya ordenada
            li = ListaOrdenada();
            TInicio = System.nanoTime();
             // Bubble sort
            long  t1a, t1aSuma=0, t1aMedia;
            for(int a=0;a<50;a++)
            {
                TInicio = System.nanoTime(); // Retorna la hora en milisegundos           
            BubbleSort(li);
            T1 = System.nanoTime(); // Tomamos la hora en que finalizó el algoritmo
            t1a = T1 - TInicio; // Calculamos los milisegundos de diferencia
            t1aSuma += t1a;
            li = ListaOrdenada(); // Volvemos a rellenar lista ordenada
            }
            t1aMedia = t1aSuma / 50;
            // Selection sort
            long  t2a, t2aSuma=0, t2aMedia;
            for(int a=0;a<50;a++)
            {
                T1 = System.nanoTime();            
            SelectionSort(li);
            T2 = System.nanoTime();
            t2a = T2 - T1;
            t2aSuma += t2a;
             li = ListaOrdenada(); // Volvemos a rellenar 
            }
            t2aMedia = t2aSuma / 50;
                    
            // Insertion sort
            long  t3a, t3aSuma=0, t3aMedia;
             for(int a=0;a<50;a++)
            {
                T2 = System.nanoTime();
            InsertionSort(li);
            T3 = System.nanoTime();
            t3a = T3 - T2;
            t3aSuma += t3a;
            li = ListaOrdenada(); // Volvemos a rellenar 
            }
             t3aMedia = t3Suma / 50;
            // Quick sort
            long  t4a, t4aSuma=0, t4aMedia;
             for(int a=0;a<50;a++)
            {
                T3 = System.nanoTime();
            QuickSort(li);
            T4 = System.nanoTime();
            t4a = T4 - T3;
            t4aSuma += t4a;
            li = ListaOrdenada();; // Volvemos a rellenar 
            }
             t4aMedia = t4aSuma / 50;
            // Merge sort
            long  t5a, t5aSuma=0, t5aMedia;
             for(int a=0;a<50;a++)
            {
            List<Integer> ali = new ArrayList<>();
            T4 = System.nanoTime();
            ali = MergeSort(li);
            T5 = System.nanoTime();            
            t5a = T5 - T4;
            t5aSuma += t5a;
            li = ListaOrdenada();
            }
             t5aMedia = t5aSuma / 50;
            // Búsqueda binaria
             long  t6a, t6aSuma=0, t6aMedia;
             for(int a=0;a<50;a++)
            {
             T5 = System.nanoTime();            
            int encBusqBin = BusquedaBinaria(li, 2);
            T6 = System.nanoTime();
            T6 = T6 - T5;
            t6aSuma += T6;
            }
            t6aMedia = t6aSuma / 50;
            // Búsqueda secuencial
            long  t7a, t7aSuma=0, t7aMedia;
            for(int a=0;a<50;a++)
            {
            T6 = System.nanoTime();
            int encBusqSec = BusquedaSecuencial(li, 2);
            T7 = System.nanoTime();
            t7a = T7 - T6;
            t7aSuma += t7a;
            }
            t7aMedia = t7aSuma / 50;
            // Borro la lista
            li.clear();
            // Rellenamos con una lista ya ordenada
            //li = ListaOrdenada();
            li = ListaInversOrdenada();
            TInicio = System.nanoTime();
             // Bubble sort
            long  t1b, t1bSuma=0, t1bMedia;
            for(int a=0;a<50;a++)
            {
                TInicio = System.nanoTime(); // Retorna la hora en milisegundos           
            BubbleSort(li);
            T1 = System.nanoTime(); // Tomamos la hora en que finalizó el algoritmo
            t1b = T1 - TInicio; // Calculamos los milisegundos de diferencia
            t1bSuma += t1b;
            li = ListaInversOrdenada(); // Volvemos a rellenar 
            }
            t1bMedia = t1bSuma / 50;
            // Selection sort
            long  t2b, t2bSuma=0, t2bMedia;
            for(int a=0;a<50;a++)
            {
                T1 = System.nanoTime();            
            SelectionSort(li);
            T2 = System.nanoTime();
            t2b = T2 - T1;
            t2bSuma += t2b;
             li = ListaInversOrdenada(); // Volvemos a rellenar 
            }
            t2bMedia = t2bSuma / 50;
                    
            // Insertion sort
            long  t3b, t3bSuma=0, t3bMedia;
             for(int a=0;a<50;a++)
            {
                T2 = System.nanoTime();
            InsertionSort(li);
            T3 = System.nanoTime();
            t3b = T3 - T2;
            t3bSuma += t3b;
            li = ListaInversOrdenada(); // Volvemos a rellenar 
            }
             t3bMedia = t3bSuma / 50;
            // Quick sort
            long  t4b, t4bSuma=0, t4bMedia;
             for(int a=0;a<50;a++)
            {
                T3 = System.nanoTime();
            QuickSort(li);
            T4 = System.nanoTime();
            t4b = T4 - T3;
            t4bSuma += t4b;
            li = ListaInversOrdenada(); // Volvemos a rellenar 
            }
             t4bMedia = t4bSuma / 50;
            // Merge sort
            long  t5b, t5bSuma=0, t5bMedia;
             for(int a=0;a<50;a++)
            {
            List<Integer> ali = new ArrayList<>();
            T4 = System.nanoTime();
            ali = MergeSort(li);
            T5 = System.nanoTime();            
            t5b = T5 - T4;
            t5bSuma += t5b;
            li = ListaInversOrdenada();
            }
             t5bMedia = t5bSuma / 50;
            // Búsqueda binaria
             long  t6b, t6bSuma=0, t6bMedia;
             for(int a=0;a<50;a++)
            {
             T5 = System.nanoTime();            
            int encBusqBin = BusquedaBinaria(li, 2);
            T6 = System.nanoTime();
            T6 = T6 - T5;
            t6bSuma += T6;
            }
            t6bMedia = t6bSuma / 50;
            // Búsqueda secuencial
            long  t7b, t7bSuma=0, t7bMedia;
            for(int a=0;a<50;a++)
            {
            T6 = System.nanoTime();
            int encBusqSec = BusquedaSecuencial(li, 2);
            T7 = System.nanoTime();
            t7b = T7 - T6;
            t7bSuma += t7b;
            }
            t7bMedia = t7bSuma / 50;
            // Borro la lista
            li.clear();
            // Rellenamos con una lista con elementos iguales
            li = ListaElementosIguales(2);
            TInicio = System.nanoTime();
             // Bubble sort
            long  t1c, t1cSuma=0, t1cMedia;
            for(int a=0;a<50;a++)
            {
                TInicio = System.nanoTime(); // Retorna la hora en milisegundos           
            BubbleSort(li);
            T1 = System.nanoTime(); // Tomamos la hora en que finalizó el algoritmo
            t1c = T1 - TInicio; // Calculamos los milisegundos de diferencia
            t1cSuma += t1c;
            li = ListaElementosIguales(2); // Volvemos a rellenar 
            }
            t1cMedia = t1cSuma / 50;
            // Selection sort
            long  t2c, t2cSuma=0, t2cMedia;
            for(int a=0;a<50;a++)
            {
                T1 = System.nanoTime();            
            SelectionSort(li);
            T2 = System.nanoTime();
            t2c = T2 - T1;
            t2cSuma += t2c;
            li = ListaElementosIguales(2);; // Volvemos a rellenar 
            }
            t2cMedia = t2cSuma / 50;
                    
            // Insertion sort
            long  t3c, t3cSuma=0, t3cMedia;
             for(int a=0;a<50;a++)
            {
                T2 = System.nanoTime();
            InsertionSort(li);
            T3 = System.nanoTime();
            t3c = T3 - T2;
            t3cSuma += t3c;
            li = ListaElementosIguales(2); // Volvemos a rellenar 
            }
             t3cMedia = t3cSuma / 50;
            // Quick sort
            long  t4c, t4cSuma=0, t4cMedia;
             for(int a=0;a<50;a++)
            {
                T3 = System.nanoTime();
            QuickSort(li);
            T4 = System.nanoTime();
            t4c = T4 - T3;
            t4cSuma += t4c;
            li = ListaElementosIguales(2); // Volvemos a rellenar 
            }
             t4cMedia = t4cSuma / 50;
            // Merge sort
            long  t5c, t5cSuma=0, t5cMedia;
             for(int a=0;a<50;a++)
            {
            List<Integer> ali = new ArrayList<>();
            T4 = System.nanoTime();
            ali = MergeSort(li);
            T5 = System.nanoTime();            
            t5c = T5 - T4;
            t5cSuma += t5c;
            li = ListaElementosIguales(2);
            }
             t5cMedia = t5cSuma / 50;
            // Búsqueda binaria
             long  t6c, t6cSuma=0, t6cMedia;
             for(int a=0;a<50;a++)
            {
             T5 = System.nanoTime();            
            int encBusqBin = BusquedaBinaria(li, 2);
            T6 = System.nanoTime();
            T6 = T6 - T5;
            t6cSuma += T6;
            }
            t6cMedia = t6cSuma / 50;
            // Búsqueda secuencial
            long  t7c, t7cSuma=0, t7cMedia;
            for(int a=0;a<50;a++)
            {
            T6 = System.nanoTime();
            int encBusqSec = BusquedaSecuencial(li, 2);
            T7 = System.nanoTime();
            t7c = T7 - T6;
            t7cSuma += t7c;
            }
            t7cMedia = t7cSuma / 50;
            pw.println("PARTE 2");
            pw.println("Lista aleatoria");
            pw.println("Test             Tiempo(nanosegundos)");
            pw.println("----             --------------------");
            pw.println("Bubble sort" + "            " + t1Media);
            pw.println("Selection sort" + "         " + t2Media);
            pw.println("Insertion sort" + "         " + t3Media);
            pw.println("Quick sort" + "             " + t4Media);
            pw.println("Merge sort" + "             " + t5Media);
            pw.println("Busqueda binaria" + "       " + t6Media);
            pw.println("Busqueda secuencial" + "    " + t7Media);
            pw.println("\nLista ordenada");
            pw.println("Test             Tiempo(nanosegundos)");
            pw.println("----             --------------------");
            pw.println("Bubble sort" + "            " + t1aMedia);
            pw.println("Selection sort" + "         " + t2aMedia);
            pw.println("Insertion sort" + "         " + t3aMedia);
            pw.println("Quick sort" + "             " + t4aMedia);
            pw.println("Merge sort" + "             " + t5aMedia);
            pw.println("Busqueda binaria" + "       " + t6aMedia);
            pw.println("Busqueda secuencial" + "    " + t7aMedia);
            pw.println("\nLista inversamente ordenada");
            pw.println("Test             Tiempo(nanosegundos)");
            pw.println("----             --------------------");
            pw.println("Bubble sort" + "            " + t1bMedia);
            pw.println("Selection sort" + "         " + t2bMedia);
            pw.println("Insertion sort" + "         " + t3bMedia);
            pw.println("Quick sort" + "             " + t4bMedia);
            pw.println("Merge sort" + "             " + t5bMedia);
            pw.println("Busqueda binaria" + "       " + t6bMedia);
            pw.println("Busqueda secuencial" + "    " + t7bMedia);
            pw.println("\nLista con elementos iguales");
            pw.println("Test             Tiempo(nanosegundos)");
            pw.println("----             --------------------");
            pw.println("Bubble sort" + "            " + t1cMedia);
            pw.println("Selection sort" + "         " + t2cMedia);
            pw.println("Insertion sort" + "         " + t3cMedia);
            pw.println("Quick sort" + "             " + t4cMedia);
            pw.println("Merge sort" + "             " + t5cMedia);
            pw.println("Busqueda binaria" + "       " + t6cMedia);
            pw.println("Busqueda secuencial" + "    " + t7cMedia);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Devuelve lista aleatoria
    public static List<Integer> ListaAleatoria()
    {
        ArrayList<Integer> li = new ArrayList<Integer>();
        RellenarListas(li);
        return li;
    }
    // Devuelve lista ordenada
    public static List<Integer> ListaOrdenada()
    {
        ArrayList<Integer> li = new ArrayList<Integer>();
        RellenarListas(li);
        Collections.sort(li);
        return li;
    }
    // Devuelve lista en orden inverso
    public static List<Integer> ListaInversOrdenada() 
     {
        ArrayList<Integer> li = new ArrayList<Integer>();
        RellenarListas(li);
        Collections.sort(li, Collections.reverseOrder());
        return li;
     }
    // Devuelve lista cuyos elementos son todos iguales
    public static List<Integer> ListaElementosIguales(int n)
    {
        ArrayList<Integer> li = new ArrayList<Integer>();
        for(int i=0; i<10; i++)
        {
            li.add(i, n);            
        }  
        return li;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> li = new ArrayList<>();
        RunTests(li);
        
        RunTimes(li);
        
        
    }
    
}
