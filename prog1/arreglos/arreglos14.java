/*
Hacer un programa que devuelva la posicion de inicio y fin de la secuencia que mas suma
*/
public class arreglos14 {
	
	final static int MAX = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 0, 1, 2, 3, 0, 0, 14, 5, 6, 0, 0, 7, 8, 0, 0, 0, 9, 10, 0 };
		obtenerSec(arr);
	}
	public static void obtenerSec (int arr[]){
		int fin = 0, inicio; 
		int auxIni = 0, auxFin = 0;
		int suma=0, auxSuma = 0;
		
		while (fin < MAX-1){
			inicio = iniSec(arr, fin);
			if (inicio != MAX){
				fin = finSec(arr, inicio);
			}else{
				fin = MAX-1;
			}
			suma = obtenerSuma (arr, inicio, fin);	
			if (suma > auxSuma){
				auxSuma = suma;
				auxIni = inicio;
				auxFin = fin;
			}
			fin++;
		}
		System.out.println("la que mas suma comienza en "+ auxIni+ " y termina en "+auxFin);
		
	}
	public static int obtenerSuma(int arr[], int pos, int fin){
		int suma = 0;
		for (int i = pos; i<=fin ; i++){
			suma += arr[i];
		}
		return suma;
	}
	public static int iniSec(int[] arr, int pos) {
		while (pos <MAX && arr[pos] == 0){
			pos++;
		}
		return pos;
	}
	public static int finSec(int[] arr, int pos) {
		while (pos <MAX && arr[pos] != 0){
			pos++;
		}
		return pos-1;
	}

}
