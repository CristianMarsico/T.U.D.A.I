/*
Hacer un corrimiento a derecha de una posicion.
Hacer un corrimiento a izquierda de una posicion.
 */
public class arreglos07 {

	final static int MAX = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1) correr derecha
		int arr_A[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		int pos_a_agregar = 3;
		correrDer(arr_A, pos_a_agregar);
		mostrar(arr_A, pos_a_agregar);

		// 2) correr izquieda
		int arr_B[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
		int pos_a_eliminar = 6;
		correrIzq(arr_B, pos_a_eliminar);
		imprimir(arr_B, pos_a_eliminar);
	}

	public static void imprimir(int arrB[], int pos) {
		System.out.println("Acá CORREMOS A IZQUIERDA o eliminamos la posicion "
				+ pos);
		for (int i = 0; i < MAX; i++) {
			System.out.print(arrB[i] + "  ");
		}
	}
	public static void mostrar(int arr[], int pos) {
		System.out.println("Acá CORREMOS A DERECHA o agregamos un elemento en la posicion "+ pos);
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
	public static void correrIzq(int arrB[], int pos) {
		for (int i = pos; i < MAX - 1; i++) {
			arrB[i] = arrB[i + 1];
		}
		arrB[MAX - 1] = -1;
	}
	public static void correrDer(int arr[], int pos) {
		for (int i = MAX - 1; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
	}
}
