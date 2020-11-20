/*
Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class arreglos15 {

	final static int MAX = 22;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 0, 1, 0, 2, 2, 0, 3, 3, 3, 0, 4, 4, 4, 4, 0, 0, 5, 5, 5, 5, 5, 0 };
		int N = obtenerNum();
		obtenerSecuencia(arr, N);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void obtenerSecuencia(int arr[], int N) {
		int fin = 0, inicio, cont = 0;
		
		while (fin < MAX - 1) {
			inicio = iniSec(arr, fin);
			if (inicio != MAX - 1) {
				fin = finSec(arr, inicio);
				cont++;
			} else {
				fin = MAX - 1;
			}
			if ((fin - inicio + 1) == N) {
				for (int i = inicio; i <= fin; i++) {
					correrIzq(arr, inicio);
				}
			} else {
				System.out.println("tamaño de secuencia numero " + cont + " no es igual a " + N);
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

	public static int obtenerNum() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		while (n < 0) {
			try {
				System.out.println("ingrese el tamaño N de secuencias");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = -1;
			}
		}
		return n;
	}

}
