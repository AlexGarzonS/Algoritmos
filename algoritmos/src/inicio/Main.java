package inicio;

import java.util.Scanner;
import java.util.Random;

import logica.BucketSort;
import logica.Burbuja;
import logica.CountingSort;
import logica.HeapSort;
import logica.InsertionSort;
import logica.RadixSort;
import logica.SelectionSort;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner scanner;
        int opcion;
        int[] numerosAleatorios;
        
        scanner = new Scanner(System.in);
        numerosAleatorios = new int[1000];
        
        do {
            System.out.println("==== MENÚ PRINCIPAL ====");
            System.out.println("1. burbuja");
            System.out.println("2. Insert Sort");
            System.out.println("3. Bucket Sort");
            System.out.println("4. Counting Sort");
            System.out.println("5. Heap Sort");
            System.out.println("6. Radix Sort");
            System.out.println("7. Selection Sort");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	try 
                	{
                		Burbuja burbuja;
                		
                		burbuja = new Burbuja();
                		System.out.print("------Burbujas------");
                		System.out.print("\n");
                		burbuja.burbuja(numeros(numerosAleatorios));
					}
                	catch (Exception e) {
						e.printStackTrace();
					}
                    break;
                case 2:
                	try 
                	{
                		InsertionSort insertS;
                		
                		insertS = new InsertionSort();
                		
                		insertS.insertionSort(numeros(numerosAleatorios));
					}
                	catch (Exception e) {
						e.printStackTrace();
					}
                    break;
                case 3:
                    try 
                    {
                    	BucketSort bucketS;
                    	
                    	bucketS = new BucketSort();
                    	
                    	bucketS.bucketSort(numeros(numerosAleatorios));
                    	
					} catch (Exception e) {
						e.printStackTrace();
					}
                    break;
                case 4:
                	 try 
                	 {
                		 CountingSort countinS;
                		 countinS =  new CountingSort();
                		 countinS.countingSort(numeros(numerosAleatorios));
                	 } 
                	 catch (Exception e) {
						e.printStackTrace();
					}
                    break;
                case 5:
                	try {
						HeapSort headS;
						headS = new HeapSort();
						
						headS.heapSort(numeros(numerosAleatorios));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
                	break;
                case 6:
                	try 
                	{
                		RadixSort radixS;
                		radixS =  new RadixSort();
                		
                		radixS.radixSort(numeros(numerosAleatorios));
					} catch (Exception e) {
						e.printStackTrace();
					}
                	break;
                case 7:
                	try 
                	{
                		
						SelectionSort selectionS;
						selectionS = new SelectionSort();
						
						selectionS.selectionSort(numeros(numerosAleatorios));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
                	break;
                case 8:
                	System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
	
	public static int[] numeros(int[] numerosAleatorios)
	{
		Random random;
        random = new Random();
        
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = random.nextInt(1000); 
        }
        
        System.out.println("Números aleatorios generados");
        for (int i = 0; i < numerosAleatorios.length; i++) {
            System.out.printf("%4d", numerosAleatorios[i]); 
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        
        return  numerosAleatorios;
	}
	
	}
	
