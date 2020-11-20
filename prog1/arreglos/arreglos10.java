/*
Obtener un num y eliminar la primer ocurrencia con ese numero del arreglo
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class arreglos10 {

	final static int MAX = 10;
	final static int POS = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int num = obtenerNum();
		int pos = buscarOcurrencia(arr, num);

		if (pos == -1) {
			System.out.println("no existe la ocurrencia en el arreglo");
		} else {
			correrIzq(arr, pos);
		}
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = POS; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void correrIzq(int arr[], int pos) {
		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAX-1] = -1;
	}

	public static int buscarOcurrencia(int arr[], int num) {
		boolean encontrado = false;
		int noExiste = -1;
		int pos = POS;
		while (pos < MAX - 1 && encontrado == false) {
			if (arr[pos] == num) {
				encontrado = true;
				return pos;
			}
			pos++;
		}
		return noExiste;
	}

	public static int obtenerNum() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = POS;
		while (num <= POS) {
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
