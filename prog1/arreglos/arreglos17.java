/*
Eliminar las secuencias de orden descendente
*/
public class arreglos17 {

	final static int MAX = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 0, 3, 2, 1, 0, 4, 2, 3, 0, 7, 6, 5, 4, 0, 9, 8, 7, 6 };
		obtenerSec(arr);
		mostrar (arr);
	}
	public static void mostrar (int arr[]){
		for (int i = 0; i < MAX; i++){
			System.out.print(arr[i] + "  ");
		}
	}
	public static void obtenerSec(int arr[]){
		int fin = 0, inicio;
		
		while (fin < MAX-1){
			inicio = iniSec (arr, fin);
			if(inicio != MAX-1){
				fin = finSec (arr, inicio);
			}else{
				fin = MAX-1;
			}
			if (esDecreciente(arr, inicio, fin)){
				for (int i = inicio; i<=fin; i++){
					correrIzq(arr, inicio, fin);
				}
				fin = inicio;
			}
			fin++;
		}
	}
	public static void correrIzq(int arr[], int pos, int fin){
		for (int i = pos; i< MAX-1; i++){
			arr[i] = arr[i+1];
		}
		arr[MAX-1] = 0;
	}
	public static boolean esDecreciente(int arr[], int pos, int fin){
		int j= 1;
		int inicio = pos;
		while (pos < fin && arr[pos] > arr[pos+1]){
			pos++;
			j++;
		}
		if ((fin - inicio + 1) == j){
			return true;
		}
		return false;
	}
	public static int finSec (int arr[], int pos){
		while (pos < MAX && arr[pos] != 0){
			pos++;
		}
		return pos-1;
	}
	public static int iniSec (int arr[], int pos){
		while (pos < MAX && arr[pos] == 0){
			pos++;
		}
		return pos;
	}

}
