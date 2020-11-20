/*
Hacer un programa que dada la matriz de secuencias de enteros definida y precargada, permita
obtener a través de métodos la posición de inicio y la posición de fin de la secuencia ubicada a
partir de una posición entera y una fila, ambas ingresadas por el usuario. Finalmente, si existen
imprima por pantalla ambas posiciones obtenidas.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz14 {
	
	final static int FILA = 4;
	final static int COL = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ma[][] = {
				{ 0, 0, 3, 3, 3, 0, 4, 4, 4, 4, 0, 3, 3, 3, 0, 4, 4, 4, 4, 0 },
				{ 0, 5, 5, 5, 5, 5, 0, 0, 6, 6, 6, 6, 6, 6, 0, 0, 0, 2, 2, 0 },
				{ 1, 0, 0, 2, 2, 0, 0, 0, 3, 3, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 2, 2, 0, 0, 0, 4, 4, 4, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } };
		
		int num = obtenerEntero();
		int fila = obtenerFila();
		
		obtenerSec(ma[fila], num);
	}
	public static void obtenerSec(int ma[], int num){
		int inicio = 0, fin = 0;
		
		while (fin < COL){
			inicio = iniSec(ma, fin);
			if(inicio != COL-1){
				fin = finSec(ma, inicio);
			}else{
				fin = COL-1;
			}
			if (inicio < num && (num > inicio || num < fin)){
				fin++;
			}else{
				System.out.println("la secuencia que sigue comienza en "+inicio+" termina en "+fin);
				fin = COL;
			}
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
	public static int obtenerFila() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		while (num < 0 || num > FILA-1) {
			try {
				System.out.println("ingrese una fila");
				num = new Integer(e.readLine());
			} catch (Exception exc) {
				num = -1;
			}
		}
		return num;
	}
	public static int obtenerEntero() {
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
