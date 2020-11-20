/*
Hacer un programa que dada la matriz de secuencias de enteros definida y precargada permita
encontrar por cada fila la posición de inicio y fin de la secuencia cuya suma de valores sea mayor.
 */

public class matriz09 {

	final static int FILA = 4;
	final static int COL = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ma[][] = {
				{ 0, 0, 2, 4, 6, 0, 7, 5, 8, 0, 0, 3, 4, 6, 0, 0, 99, 0, 0, 1000 },
				{ 0, 9, 4, 7, 8, 2, 0, 1, 2, 3, 6, 5, 0, 1, 2, 7, 0, 1, 4, 0 },
				{ 0, 7, 4, 5, 0, 0, 0, 0, 4, 4, 3, 3, 7, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 9, 9, 9, 0, 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0, 0 } };

		for (int f = 0; f < FILA; f++) {
			obtenerSec(ma[f], f);
		}
	}

	public static void obtenerSec(int ma[], int f) {
		int fin = 0, inicio;
		int suma = 0, auxIni = 0, auxFin = 0, auxSuma = 0;

		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
			} else {
				fin = COL - 1;
			}
			suma = sumarSec(ma, inicio, fin);
			if (suma > auxSuma){
				auxSuma = suma;
				auxIni = inicio;
				auxFin = fin;
			}
			fin++;
		}
		imprimir (ma, f, auxSuma, auxIni, auxFin);
	}
	public static void imprimir (int ma[], int fila, int suma, int inicio, int fin){
		System.out.println("la matriz en la fila "+fila+ " suma "+suma+ ", la secuencia va de "+inicio+" a "+fin);
	}
	public static int sumarSec(int ma[], int pos, int fin) {
		int suma = 0;
		for (int c = pos; c <= fin; c++) {
			suma += ma[c];
		}
		return suma;
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
}
