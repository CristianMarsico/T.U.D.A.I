/*
Hacer un programa que dada la matriz de secuencias de enteros definida y precargada, y un número
entero ingresado por el usuario, elimine de cada fila las secuencias de tamaño igual al número
ingresado.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz11 {

	final static int FILA = 4;
	final static int COL = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ma[][] = {
				{ 0, 0, 3, 3, 3, 0, 4, 4, 4, 4, 0, 3, 3, 3, 0, 4, 4, 4, 4, 0 },
				{ 0, 5, 5, 5, 5, 5, 0, 0, 6, 6, 6, 6, 6, 6, 0, 0, 0, 2, 2, 0 },
				{ 1, 0, 0, 2, 2, 0, 0, 0, 3, 3, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 2, 2, 0, 0, 0, 4, 4, 4, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } };
		int num = obtenerNum();

		for (int f = 0; f < FILA; f++) {
			obtenerSec(ma[f], num);
		}
		mostrar(ma);
	}
	public static void mostrar(int ma[][]) {
		for (int f = 0; f < FILA; f++) {
			for (int c = 0; c < COL; c++) {
				System.out.print(ma[f][c] + "  ");
			}
			System.out.println();
		}
	}
	public static void obtenerSec(int ma[], int num) {
		int fin = 0, inicio = 0;
		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
			} else {
				fin = COL - 1;
			}
			if ((fin - inicio + 1) == num) {
				for (int i = inicio; i <= fin; i++) {
					correrIzq(ma, inicio);
				}
			}
			fin++;
		}
	}

	public static void correrIzq(int ma[], int pos) {
		for (int c = pos; c < COL - 1; c++) {
			ma[c] = ma[c + 1];
		}
	}

	public static int finSec(int ma[], int pos) {
		while (pos < COL && ma[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int iniSec(int ma[], int pos) {
		while (pos < COL && ma[pos] == 0) {
			pos++;
		}
		return pos;
	}

	public static int obtenerNum() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		while (num < 0) {
			try {
				System.out.println("ingrese un num");
				num = new Integer(e.readLine());
			} catch (Exception exc) {
				num = -1;
			}
		}
		return num;
	}
}
