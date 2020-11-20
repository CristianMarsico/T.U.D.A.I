/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada elimine todas
las secuencias que tienen orden descendente entre sus elementos.
*/

public class matriz13 {
	
	final static int FILA = 4;
	final static int COL = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char ma[][] = {
				{ ' ', 'z', 'y', 'x', 'w', ' ', ' ', 'z', 'b', 'n', ' ', 'e', 'd', 'c', 'a', 'z', ' ', 'q', 'w', ' ' },
				{ ' ', 'a', 'b', 'c', 'f', 't', ' ', 'c', 'b', 'a', ' ', ' ', ' ', 'g', 'd', 'e', ' ', 'v', 'v', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', ' ', ' ', 'e', 'c', 'a', ' ', 'r', 'v', 'a', ' ', 'z', ' ', 'q', ' ', ' ' },
				{ ' ', 'e', 'q', 'r', 'a', 'z', ' ', 'z', 'z', 'z', ' ', ' ', 'q', 'a', 'a', 'z', ' ', ' ', ' ', ' ' } };
		
		for(int f = 0; f< FILA;f++){
			obtenerSec(ma[f]);
		}
		mostrar(ma);

	}
	public static void mostrar(char ma[][]) {
		for (int f = 0; f < FILA; f++) {
			for (int c = 0; c < COL; c++) {
				System.out.print(ma[f][c] + "  ");
			}
			System.out.println();
		}
	}
	public static void obtenerSec(char ma[]){
		int fin = 0, inicio= 0;
		
		while (fin<COL){
			inicio = iniSec(ma, fin);
			if(inicio!=COL-1){
				fin = finSec(ma, inicio);
			}else{
				fin = COL-1;
			}
			if (esDescendente(ma, inicio, fin)){
				for(int i = inicio;i<=fin;i++){
					correrIzq(ma, inicio);
				}
				fin = inicio;
			}
			fin++;
		}
	}
	public static void correrIzq(char ma[], int pos) {
		for (int c = pos; c < COL - 1; c++) {
			ma[c] = ma[c + 1];
		}
	}
	public static int iniSec(char ma[], int pos) {
		while (pos < COL && ma[pos] == ' ') {
			pos++;
		}
		return pos;
	}
	public static int finSec(char ma[], int pos) {
		while (pos < COL && ma[pos] != ' ') {
			pos++;
		}
		return pos - 1;
	}
	public static boolean esDescendente(char ma[], int pos, int fin){
		int j = 1;
		int inicio = pos;
		while (pos < fin && ma[pos] > ma[pos+1]){
			pos++;
			j++;
		}
		if((fin-inicio+1) == j){
			return true;
		}else{
			return false;
		}
	}

}
