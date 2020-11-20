/*
Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se encuentra precargada,
solicite al usuario un número entero y una posición fila, columna. Con estos datos tendrá que realizar
un corrimiento a derecha (se pierde el último valor en dicha fila) y colocar el número en la matriz en la
posición fila, columna indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz04 {
	
	final static int FILA = 5;
	final static int COL = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ma[][] = {  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

		int fila = obtenerFila();
		int col = obtenerCol();
		int num = (int) (10*Math.random()+1);
		System.out.println("el numero seleccionado es: "+num);
		correrDer(ma, fila, col);
		ma[fila][col] = num;
		mostrar(ma);

	}
	public static void mostrar (int ma[][]){
		for (int f = 0; f<FILA; f++){
			for (int c = 0; c <COL; c++){
				System.out.print(ma[f][c] + "  ");
			}
			System.out.println();
		}
	}
	public static void correrDer (int ma[][], int fila, int col){
		for (int c = COL-1; c > col; c--){
			ma[fila][c] = ma[fila][c-1];
		}
		
	}

	public static int obtenerFila() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int fila = -1;
		while (fila < 0 || fila > FILA-1) {
			try {
				System.out.println("ingrese fila");
				fila = new Integer(e.readLine());
			} catch (Exception exc) {
				fila = -1;
			}
		}
		return fila;
	}

	public static int obtenerCol() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int col = -1;
		while (col < 0 || col > COL-1) {
			try {
				System.out.println("ingrese col");
				col = new Integer(e.readLine());
			} catch (Exception exc) {
				col = -1;
			}
		}
		return col;
	}

}
