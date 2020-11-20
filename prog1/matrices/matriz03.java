/*
Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se encuentra precargada,
solicite al usuario una posición fila, columna y realice un corrimiento a izquierda.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz03 {
	
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
		correrIzq (ma, fila, col);
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
	public static void correrIzq (int ma[][], int fila, int col){
		
			for (int c = col; c <COL-1; c++ ){
				ma[fila][c] = ma[fila][c + 1];
		}
	}
	public static int obtenerFila (){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int fila = -1;
		while (fila < 0 || fila > 4 ){
			try{
				System.out.println("ingrese fila");
				fila = new Integer(e.readLine());
			}catch (Exception exc){
				fila = -1;
			}
		}
		return fila;
	}
	public static int obtenerCol (){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int col = -1;
		while (col < 0 || col > 9 ){
			try{
				System.out.println("ingrese col");
				col = new Integer(e.readLine());
			}catch (Exception exc){
				col = -1;
			}
		}
		return col;
	}
	

}
