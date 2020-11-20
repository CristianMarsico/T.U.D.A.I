/*
Hacer un programa que dado una matriz ordenada creciente por filas de enteros de tamaño 4*5 que se
encuentra precargada, solicite al usuario un número entero y una fila, y elimine la primer ocurrencia de
número en la fila indicada (un número igual) si existe.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz08 {

	final static int FILA = 4;
	final static int COL = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ma[][] = {  { 1, 3, 5, 5, 7 }, 
						{ 8, 9, 11, 13, 15 },
						{ 22, 24, 26, 28, 29 }, 
						{ 37, 38, 39, 40, 52 } };

		int num = obtenerNum();
		int fila = obtenerFila();
		buscarPos(ma[fila], num);
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

	public static void buscarPos(int ma[], int num) {
		int c = 0;
		boolean encontrado = false;
		while (c < COL && encontrado == false) {
			if (num == ma[c]) {
				encontrado = true;
				correrIzq(ma, c, num);
			}
			c++;
		}
	}

	public static void correrIzq(int ma[], int pos, int num) {
		for (int c = pos; c < COL-1; c++) {
			ma[c] = ma[c + 1];
		}
		ma[COL-1] = 0;
	}

	public static int obtenerNum() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		while (n < 0) {
			try {
				System.out.println("ingrese un num");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = -1;
			}
		}
		return n;
	}

	public static int obtenerFila() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		while (n < 0 || n > FILA - 1) {
			try {
				System.out.println("ingrese una fila");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = -1;
			}
		}
		return n;
	}

}
