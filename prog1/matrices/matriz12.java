/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, elimine de
cada fila todas las ocurrencias de una secuencia patrón dada por un arreglo de caracteres de tamaño
igual al tamaño de columnas de la matriz (sólo tiene esa secuencia con separadores al inicio y al final).
Al eliminar en cada fila se pierden los valores haciendo los corrimientos.
*/

public class matriz12 {

	final static int FILA = 4;
	final static int COL = 20;
	final static int PATRON = COL;
	final static int TAM = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ma[][] = {
				{ ' ', 'z', 'z', 'z', 'k', ' ', ' ', 'z', 'z', 'z', ' ', 'e', 'q', 'r', 'a', 'z', ' ', 'q', 'w', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', 'a', ' ', 'z', 'z', 'z', 'k', ' ', ' ', 'a', 'a', 'z', ' ', 'v', 'v', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', ' ', ' ', 'z', 'z', 'z', ' ', 'r', 'q', 'a', ' ', 'z', ' ', 'q', ' ', ' ' },
				{ ' ', 'e', 'q', 'r', 'a', 'z', ' ', 'z', 'z', 'z', ' ', ' ', 'q', 'a', 'a', 'z', ' ', ' ', ' ', ' ' } };

		char arr[] = { ' ', ' ', ' ', ' ', ' ', ' ', 'e', 'q', 'r', 'a', 'z', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

		
		for (int f = 0; f < FILA; f++) {
			obtenerSec(ma[f], arr);
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

	public static void obtenerSec(char ma[], char arr[]) {
		int fin = 0, inicio = 0;
		int iniArr = 0, finArr = 0;

		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
			} else {
				fin = COL - 1;
			}
			if (finArr < COL && iniArr <= 0){
				iniArr = iniSec (arr, finArr);{
					if (iniArr != COL - 1) {
						finArr = finSec(arr, iniArr);
					} else {
						finArr = COL - 1;
					}
				}		
			}
			
			if ((fin - inicio + 1) == ((finArr-iniArr+1))) {
				if (comparar(ma, inicio, fin, arr, iniArr)) {
					for (int i = inicio; i <= fin; i++) {
						correrIzq(ma, inicio);
					}
					fin = inicio;
				}
			}
			fin++;
		}
	}

	public static void correrIzq(char ma[], int pos) {
		for (int c = pos; c < COL - 1; c++) {
			ma[c] = ma[c + 1];
		}
	}

	public static boolean comparar(char ma[], int pos, int fin, char arr[], int posArr) {
		int cont = 0;
		while (pos <= fin && ma[pos] == arr[posArr]) {
			pos++;
			posArr++;
			cont++;
		}
		if (cont == TAM) {
			return true;
		} else {
			return false;
		}
	}

	public static int finSec(char ma[], int pos) {
		while (pos < COL && ma[pos] != ' ') {
			pos++;
		}
		return pos - 1;
	}

	public static int iniSec(char ma[], int pos) {
		while (pos < COL && ma[pos] == ' ') {
			pos++;
		}
		return pos;
	}

}
