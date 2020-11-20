/*
Insertar un elemento a un arreglo ordenado de forma decreciente
*/
public class arreglos09 {

	final static int MAX = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int elem = -1;
		int pos = 1;
		correrDer(arr, elem, pos);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void correrDer(int arr[], int elem, int pos) {
		for (int i = MAX - 1; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = elem;
	}
}
