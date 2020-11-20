/*
Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado de valores entre 1 y 12.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class arreglos01 {

	final static int MAX = 15;
	final static int POS = 0;
	final static int UNO = 1;
	final static int DOCE = 12;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[MAX];
		cargar_arreglo(arr);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = POS; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void cargar_arreglo(int arr[]) {

		for (int i = POS; i < MAX; i++) {
			arr[i] = obtener_num_entre1y12();
		}
	}

	public static int obtener_num_entre1y12() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = POS;
		while (num < UNO || num > DOCE) {
			try {
				System.out.println("ingrese un num");
				num = new Integer(e.readLine());
			} catch (Exception exc) {
				num = POS;
			}
		}
		return num;
	}
}
