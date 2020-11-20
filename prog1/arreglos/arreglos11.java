/*
Eliminar elementos pares del arreglo
*/

public class arreglos11 {

	final static int MAX = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		eliminarPares(arr);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void eliminarPares(int arr[]) {
		int pos = 0;
		while (pos < MAX - 1) {
			if (arr[pos] % 2 == 0) {
				correrIzq(arr, pos);
			} else {
				pos++;
			}
		}
	}

	public static void correrIzq(int arr[], int pos) {
		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAX - 1] = -1;
	}

}
