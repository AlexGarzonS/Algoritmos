package logica;

public class SelectionSort {
	
	public void selectionSort(int[] arr) {
        int n = arr.length;
        
        long timeIni;
    	long timeEnd;
    	long time;
        
    	timeIni = System.nanoTime();
        // Recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del elemento mínimo en la sublista arr[i...n-1]
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento no ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        
        timeEnd = System.nanoTime();
        
        time = timeEnd - timeIni;
        
        System.out.println("Elementos ordenados por Selection Sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]);
            // Insertar un salto de línea cada 10 elementos
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        
        System.out.println("Tiempo de Ejecucion: "+time);
    }
	
}
