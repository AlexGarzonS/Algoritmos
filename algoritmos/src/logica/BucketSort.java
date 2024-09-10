package logica;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	
	public void bucketSort(int[] arr) {
        int n = arr.length;
        
        long timeIni;
    	long timeEnd;
    	long time;
    	
    	
    	timeIni = System.nanoTime();
    	
        // Encontrar el valor máximo en el arreglo
        int max = getMax(arr);

        // Crear n buckets vacíos (aquí usamos 10 buckets para un mejor rendimiento)
        int numBuckets = 10;
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuir los elementos en los buckets correspondientes
        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] * numBuckets) / (max + 1);  // Distribuir basado en el valor máximo
            buckets[bucketIndex].add(arr[i]);
        }

        // Ordenar cada bucket individualmente
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenar todos los buckets en el arreglo original
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
        
        timeEnd = System.nanoTime();
        
        time = timeEnd - timeIni;

        // Imprimir los elementos ordenados
        System.out.println("Elementos ordenados por cubeta:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println("tiempo Ejecucion: "+time);
    }

    // Obtener el valor máximo en el arreglo
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
	
}
