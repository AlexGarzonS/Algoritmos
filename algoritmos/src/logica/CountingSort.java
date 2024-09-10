package logica;

import java.util.Arrays;

public class CountingSort {
	

	    public void countingSort(int[] arr) {
	    	long timeIni;
	    	long timeEnd;
	    	long time;
	    	
	    	
	    	try {
	    		timeIni = System.nanoTime();
	    		// Encontrar el valor máximo en el arreglo
	    		int max = Arrays.stream(arr).max().getAsInt();
	    		int min = Arrays.stream(arr).min().getAsInt();
	    		
	    		// Rango de los valores (necesario si hay negativos)
	    		int range = max - min + 1;
	    		
	    		// Crear un arreglo de conteo (count array) y un arreglo de salida (output array)
	    		int[] count = new int[range];
	    		int[] output = new int[arr.length];
	    		
	    		// Almacenar el conteo de cada valor
	    		for (int i = 0; i < arr.length; i++) {
	    			count[arr[i] - min]++;  // Ajuste por el valor mínimo para manejar números negativos
	    		}
	    		
	    		// Modificar el arreglo de conteo para almacenar las posiciones correctas de los elementos
	    		for (int i = 1; i < count.length; i++) {
	    			count[i] += count[i - 1];
	    		}
	    		
	    		// Construir el arreglo de salida
	    		for (int i = arr.length - 1; i >= 0; i--) {
	    			output[count[arr[i] - min] - 1] = arr[i];
	    			count[arr[i] - min]--;
	    		}
	    		
	    		// Copiar el arreglo de salida al arreglo original
	    		for (int i = 0; i < arr.length; i++) {
	    			arr[i] = output[i];
	    		}
	    		
	    		timeEnd = System.nanoTime();
	            
	            time = timeEnd - timeIni;
	    		
	    		System.out.println(" Elementos ordenados conteo ");
	            for (int i = 0; i < arr.length; i++) {
	                System.out.printf("%4d", arr[i]); 
	                if ((i + 1) % 10 == 0) {
	                    System.out.println();
	                }
	            }
	            
	            System.out.println("Tiempo de ejecucion: "+time);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

}
