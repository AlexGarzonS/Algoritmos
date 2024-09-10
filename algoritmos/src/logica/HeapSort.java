package logica;

public class HeapSort {

	public void heapSort(int[] arr) {
        int n = arr.length;
        
        long timeIni;
    	long timeEnd;
    	long time;
    	
    	
    	timeIni = System.nanoTime();
        // Construir el heap (arreglo reorganizado)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer un elemento del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual (el mayor elemento) al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Aplicar heapify al arreglo reducido
            heapify(arr, i, 0);
        }
        
        timeEnd = System.nanoTime();
        
        time = timeEnd - timeIni;
        
        System.out.println(" Elementos ordenados Heap ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]); 
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println("Tiempo de ejecucion "+time);
    }

    // Función para reorganizar un subárbol con la raíz en el nodo i, n es el tamaño del heap
    void heapify(int[] arr, int n, int i) {
        int largest = i;  // Inicializar el mayor como la raíz
        int left = 2 * i + 1;  // Hijo izquierdo
        int right = 2 * i + 2;  // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Si el hijo derecho es mayor que el nodo más grande encontrado hasta ahora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si el mayor no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente aplicar heapify al subárbol afectado
            heapify(arr, n, largest);
        }
    }	
	
}
