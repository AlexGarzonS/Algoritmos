package logica;

public class RadixSort {
	
	 public void radixSort(int[] arr) {
		 	
		 	long timeIni;
	    	long timeEnd;
	    	long time;
	    	
	    	timeIni = System.nanoTime();
	        // Encontrar el número máximo para saber el número de dígitos
	        int max = getMax(arr);

	        // Realizar Counting Sort para cada dígito. Empezar desde el dígito menos significativo.
	        for (int exp = 1; max / exp > 0; exp *= 10) {
	            countingSortByDigit(arr, exp);
	        }
	        
	        timeEnd = System.nanoTime();
	        
	        time = timeEnd - timeIni;
	        
	        System.out.println("Elementos ordenados por Radix:");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.printf("%4d", arr[i]);
	            // Insertar un salto de línea cada 10 elementos
	            if ((i + 1) % 10 == 0) {
	                System.out.println();
	            }
	        }
	        
	        // Si el número de elementos no es múltiplo de 10, hacer un salto de línea
	        if (arr.length % 10 != 0) {
	            System.out.println();
	        }
	        
	        System.out.println("Tiempo de ejecucion: "+time);
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

	    // Counting Sort basado en el dígito representado por exp
	    private void countingSortByDigit(int[] arr, int exp) {
	        int n = arr.length;
	        int[] output = new int[n]; // Array de salida
	        int[] count = new int[10]; // Hay 10 dígitos (0-9)

	        // Contar las ocurrencias de cada dígito en el arreglo
	        for (int i = 0; i < n; i++) {
	            int digit = (arr[i] / exp) % 10;
	            count[digit]++;
	        }

	        // Cambiar count[i] para que contenga la posición real de este dígito en output[]
	        for (int i = 1; i < 10; i++) {
	            count[i] += count[i - 1];
	        }

	        // Construir el arreglo de salida
	        for (int i = n - 1; i >= 0; i--) {
	            int digit = (arr[i] / exp) % 10;
	            output[count[digit] - 1] = arr[i];
	            count[digit]--;
	        }

	        // Copiar el arreglo de salida al arreglo original
	        for (int i = 0; i < n; i++) {
	            arr[i] = output[i];
	        }
	    }
	
}
