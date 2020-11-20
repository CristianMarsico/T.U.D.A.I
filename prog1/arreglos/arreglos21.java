/*
 *Hacer un prog que reemplace de un 'arreglo A' todas las ocurrencias dadas por un 'arreglo B',
 *reemplazarlas por la secuencia que posee un 'arreglo C'. 
*/
public class arreglos21 {

	final static int MAX = 22;
	final static int B = 5;
	final static int C = 7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 1, 0, 2, 2, 0, 3, 3, 3, 0, 0, 4, 4, 4, 4, 0, 5, 5, 5, 5, 5, 0 };

		int arrB[] = { 5,5,5,5,5 };

		int arrC[] = { -1, -1,-1,-1,-1,-1,-1 };

		obtenerSec(arr, arrB, arrC);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void obtenerSec(int arr[], int arrB[], int arrC[]) {
		int fin = 0, inicio = 0;
		int total = (B - C);

		while (fin < MAX - 1) {
			inicio = iniSec(arr, fin);
			if (inicio != MAX - 1) {
				fin = finSec(arr, inicio);
			} else {
				fin = MAX - 1;
			}
			if (esIgual(arr, inicio, fin, arrB)) {
				if (total == 0) {
					reemplazar(arr, inicio, arrC);
				} else if (total < 0) {
					//if ((fin - (total)) >= MAX){
						//System.out.println("el arregloC supera el maximo del arreglo");
					//}else{
						correrDer(arr, inicio, total);
						reemplazar(arr, inicio, arrC);
						fin = fin - (total);
					//}
					
				} else {
					correrIzq(arr, inicio, total);
					reemplazar(arr, inicio, arrC);
					fin = fin - total;
				}
			}
			fin++;
		}
	}

	public static void correrIzq(int arr[], int pos, int total) {
		while (total > 0) {
			for (int i = pos; i < MAX - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[MAX - 1] = 0;
			
			total--;
		}
	}

	public static void correrDer(int arr[], int pos, int total) {

		while (total < 0) {
			for (int i = MAX - 1; i > pos; i--) {
				if (i == MAX-1){
					total = 1;
				}
				arr[i] = arr[i - 1];
			}
			total++;
		}
	}

	public static void reemplazar(int arr[], int pos, int arrC[]) {

		for (int i = 0; i < C; i++) {
			if (arr[pos] < MAX){
			arr[pos] = arrC[i];
				pos++;
			}else{
				i  = C+1;
			}
		}
	}

	public static boolean esIgual(int arr[], int pos, int fin, int arrB[]) {
		int j = 0;
		while (pos <= fin && arr[pos] == arrB[j]) {
			pos++;
			j++;
		}
		if (j == B) {
			return true;
		}
		return false;
	}

	public static int finSec(int arr[], int pos) {
		while (pos < MAX && arr[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int iniSec(int arr[], int pos) {
		while (pos < MAX && arr[pos] == 0) {
			pos++;
		}
		return pos;
	}

}
