package logica;

public class Burbuja {
	
	public void burbuja(int[] data) 
	{
		long timeIni;
    	long timeEnd;
    	long time;
    	
    	timeIni = System.nanoTime();
    	
        for (int i = 0; i < data.length; i++) {
        	
            for (int j = 0; j < data.length - 1; j++)
            {
                if (data[j] > data[j + 1]) 
                {
                    Integer temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        
        timeEnd = System.nanoTime();
        
        time = timeEnd - timeIni;
        
        System.out.println(" Elementos ordenados Burbuja ");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%4d", data[i]); 
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        
        System.out.println("Tiempo de ejecución: "+time);
    }
	
}
