/*
Eliminar las ocurrencias de una secuencia patron dada por otro arreglo
*/
public class arreglos16 {

	final static int MAX = 10;
	final static int PATRON = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 1, 2, 0, 3, 4, 5, 0, 6, 0 };

		int patron[] = { 3,4,5 };

		obtenerSec(arr, patron);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void obtenerSec(int arr[], int arr_B[]) {
		int fin = 0, inicio;

		while (fin < MAX) {
			inicio = iniSec(arr, fin);
			if (inicio != MAX - 1) {
				fin = finSec(arr, inicio);
			} else {
				fin = MAX - 1;
			}
			if ((fin - inicio + 1) == PATRON) {
				if (verificarSec(arr, inicio, fin, arr_B)) {
					for (int i = inicio; i <= fin; i++) {
						correrIzq(arr, inicio);
					}
				}
			}
			fin++;
		}
	}

	public static void correrIzq(int arr[], int pos) {
		for (int i = pos; i < MAX-1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAX-1] = -1;
	}

	public static boolean verificarSec(int arr[], int pos, int fin, int arr_B[]) {
		int j = 0;
		while (pos <= fin && arr[pos] == arr_B[j]) {
			pos++;
			j++;
		}
		if (j == PATRON) {
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
