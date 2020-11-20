/*
Hacer un prog que reemplace de un "arreglo A" todas las ocurrencias de patron dada en un "arreglo B", por la contenida en un "arreglo C"
*/
public class arreglos18 {

	final static int MAX = 15;
	final static int ARR_B = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 0, 1, 2, 0, 3, 4, 5, 6, 0, 0, 7, 11, 10, 9, 0 };

		int arreglo_B[] = { 3, 4, 5, 6 };

		int arreglo_C[] = { 99, 99, 99, 99 };

		obtenerSec(arr, arreglo_B, arreglo_C);
		mostrar (arr);
	}
	public static void mostrar (int arr[]){
		for (int i = 0; i<MAX; i++){
			System.out.print(arr[i] + "  ");
		}
	}

	public static void obtenerSec(int arr[], int arreglo_B[], int arreglo_C[]) {
		int fin = 0, inicio = 0;

		while (fin < MAX) {
			inicio = iniSec(arr, fin);
			if (inicio != MAX - 1) {
				fin = finSec(arr, inicio);
			} else {
				fin = MAX - 1;
			}
			if ((fin - inicio + 1) == ARR_B) {
				if (verificar_patron(arr, inicio, fin, arreglo_B)) {
					reemplazar(arr, inicio, fin, arreglo_C);
				}
			}
			fin++;
		}
	}

	public static void reemplazar(int arr[], int pos, int fin, int arreglo_C[]) {
		int j = 0;
		for (int i = pos; i <= fin; i++) {
			arr[i] = arreglo_C[j];
			j++;
		}
	}

	public static boolean verificar_patron(int arr[], int pos, int fin, int arreglo_B[]) {
		int j = 0;
		while (pos <= fin && arr[pos] == arreglo_B[j]) {
			pos++;
			j++;
		}
		if (j == ARR_B) {
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
