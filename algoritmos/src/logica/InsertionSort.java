package logica;

public class InsertionSort {
	
	
	    public void insertionSort(int array[])
	    {
	    	long timeIni;
	    	long timeEnd;
	    	long time;
	    	int n;
	    	
	        n = array.length;  	        
	        timeIni = System.nanoTime();
	        
	        
	        for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	            }  
	            array[i+1] = key;  
	        }
	        
	        timeEnd = System.nanoTime();
	        
	        time = timeEnd - timeIni;
	        
	        System.out.println(" Elementos ordenados Insertion-Sort ");
	        for (int i = 0; i < array.length; i++) {
	            System.out.printf("%4d", array[i]); 
	            if ((i + 1) % 10 == 0) {
	                System.out.println();
	            }
	        }
	        System.out.println("Tiempo de ejecución: "+time);
	    } 
	    
}
