/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, permita
encontrar por cada fila la posición de inicio y fin de la anteúltima secuencia (considerar comenzar a
buscarla a partir de la última posición de la fila).
*/
public class matriz10 {

	final static int FILA = 4;
	final static int COL = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char ma[][] = {
				{ ' ', 'a', 'g', 'e', 'q', ' ', ' ', 'z', 'z', 'z', ' ', 'e', 'q', ' ', 'a', 'z', ' ', 'q', 'w', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', 'a', ' ', 'z', 'z', 'z', 'k', ' ', 'q', 'a', 'a', 'z', ' ', 'v', 'v', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', ' ', ' ', 'z', 'z', 'z', ' ', 'r', 'q', 'a', ' ', 'z', ' ', 'q', ' ', ' ' },
				{ ' ', 'a', 'g', 'e', 'q', ' ', ' ', 'z', 'z', 'z', ' ', ' ', 'q', 'a', 'a', 'z', ' ', ' ', ' ', ' ' } };
		
		for (int f = 0; f< FILA; f++){
			obtenerSec(ma[f], f);
		}
	}
	public static void obtenerSec (char ma[], int fila){
		int fin = COL-1, inicio= COL-1;
		int cont = 0;
		
		while (fin >= 0){
			inicio = iniSec(ma, fin);
			if (fin != 0){
				fin = finSec(ma, inicio);
				cont++;
			}else{
				fin = 0;
			}
			if (cont == 2){
				System.out.println("en la fila "+fila+ " la anteultima sec comienza en "+fin+" - "+inicio);
			}
			fin--;
		}	
	}
	public static int finSec (char arr[], int pos){
		while (pos>0 && arr[pos]!= ' '){
			pos--;
		}
		return pos+1;
	}
	public static int iniSec(char ma[], int pos){
		while (pos>0 && ma[pos] == ' '){
			pos--;
		}
		return pos;
	}
}
