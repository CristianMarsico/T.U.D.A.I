/*
Hacer un prog que solicite un num entero y lo agregue al principio del arreglo. 
Arreglo ordenado de TAM 10 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class arreglos08 {

	final static int MAX = 10;
	final static int POS = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int num = obtenerEntero();
		correrDer(arr, num);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void correrDer(int arr[], int elem) {
		for (int i = MAX - 1; i > POS; i--) {
			arr[i] = arr[i - 1];
		}
		arr[POS] = elem;
	}

	public static int obtenerEntero() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		while (num <= 0) {
			try {
				System.out.println("ingrese un num");
				num = new Integer(e.readLine());
			} catch (Exception exc) {
				num = 0;
			}
		}
		return num;
	}

}
