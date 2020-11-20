/*
Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se encuentra precargada,
solicite al usuario un número entero y elimine la primer ocurrencia de número en la matriz (un número
igual) si existe. Para ello tendrá que buscar la posición y si está, realizar un corrimiento a izquierda y no
continuar buscando. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz05 {

	final static int FILA = 5;
	final static int COL = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ma[][] = { 	{ 1, 2, 3, 4, 5, 6, 7, 8, 4, 10 },
						{ 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 },
						{ 1, 3,	5, 7, 9, 11, 13, 15, 17, 19 },
						{ 45, 21, 65, 879, 342, 123, 534, 7, 4, 5 },
						{ -7, -4, -2, -7, -9, -2, -5, -57, -9, -1 } };
		
		
		int num = obtenerNum();
		
		//for (int f = 0; f<FILA;f++){
			 verificar(ma, num);			
		//}
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
	public static void verificar(int ma[][], int num){
		
		boolean encontrado = false;
		for (int f = 0; f<FILA;f++){
			int c= 0;
			while (c < COL && encontrado == false){
				if (ma[f][c] == num){
					correrIzq(ma[f], c);
					encontrado = true;
					
				}
				c++;
			}
		}	
	}
	public static void correrIzq(int ma[], int col){
		for (int c = col; c<COL-1;c++){
			ma[c] = ma[c+1];
		}
		ma[COL-1] = -1;
	}

	public static int obtenerNum() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;	
			try {
				System.out.println("ingrese un num");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				return -1;
			}		
		return n;
	}
}
