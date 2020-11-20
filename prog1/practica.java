/*
Realizar un programa modularizado en Java que resuelva lo siguiente
Dada una matriz de MxN de caracteres con secuencias separadas por espacio en blanco se pide obtener la cantidad 
de secuencias que tengan más de dos vocales. 
Si la cantidad es mayor al promedio de tamaños de todas las secuencias de la matriz,
se deben eliminar las secuencias que tengan como mínimo una vocal.
Todas las secuencias empiezan y terminan con uno o más espacios en blanco obligatoriamente.
Usar constantes y buenas prácticas.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));
	final static int FILA = 5;
	final static int COL = 15;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ma[][] = {
				{ ' ', 'q', 'e', 'i', ' ', ' ', 'q', 'a', 'e', 'o', ' ', ' ', 'z', 'i', ' ' },
				{ ' ', 'a', 'e', 'u', ' ', ' ', 'a', 'e', 'e', ' ', 'i', 'a', 'e', ' ', ' ' },
				{ ' ', 'a', 'e', 'i', 'z', ' ', ' ', 'a', 'e', ' ', ' ', 'a', 'e', 'o', ' ' },
				{ ' ', 'a', 'e', 'i', 'z', ' ', ' ', 'a', 'e', ' ', ' ', 'a', 'e', 'o', ' ' },
				{ ' ', 'a', 'p', 'p', ' ', ' ', ' ', 'w', 'w', ' ', ' ', 'a', 'e', 'o', 'w' } };

		if(SecConMasDeDosVocalesEsMayorAlProm(ma)){
			for(int f = 0; f<FILA; f++){
				buscarSecConUnaOMasVocales(ma[f]);
			}
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
	public static void buscarSecConUnaOMasVocales(char ma[]){
		int fin = 0, inicio= 0;
		
		while (fin < COL){
			inicio= iniSec (ma, fin);
			if (inicio != COL){
				fin = finSec (ma, inicio);
			}else{
				fin = COL-1;
			}
			if(tieneAlMenosUnaVocal(ma, inicio, fin)){
				for(int i = inicio;i<=fin; i++){
					correrIzq(ma, inicio);
				}
				fin = inicio;
			}
			
			fin++;
		}
	}
	public static boolean tieneAlMenosUnaVocal(char ma[], int pos, int fin){
		int cont = 0;
		while(pos <= fin ){
			if(esVocal(ma, pos)){
				cont++;
			}
			if(cont > 0){
				return true;
			}
			pos++;
		}
		return false;
	}
	public static boolean SecConMasDeDosVocalesEsMayorAlProm(char ma[][]) {
		double prom = 0;
		int suma = 0,  cont= 0;
		for (int f = 0; f < FILA; f++) {
			int fin = 0, inicio= 0, masDeDos= 0;
			
			while (fin < COL){
				inicio= iniSec (ma[f], fin);
				if (inicio != COL){
					fin = finSec (ma[f], inicio);
				}else{
					fin = COL-1;
				}
				suma += (fin-inicio+1);
				if((fin-inicio+1)>0){
					cont++;					
				}
				if (tieneMasDeDosVocales(ma[f], inicio, fin)){
					masDeDos++;
				}
				fin++;
			}
			imprimirSecConMasDeDosVocales(f, masDeDos);
			masDeDos=0;
		}
		
		prom = (suma/cont);
		System.out.println("el promedio es :"+prom);
		if(cont > prom){
			return true;
		}
		return false;

	}
	public static void imprimirSecConMasDeDosVocales(int fila, int cont){
		System.out.println("la matriz en la fila "+fila+" tiene "+cont+" secuencias con mas de 2 vocales");
	}
	public static boolean tieneMasDeDosVocales(char ma[], int pos, int fin){
		int cont = 0;
		while(pos <= fin){
			if(esVocal(ma,pos)){
				cont++;
			}
			pos++;
		}
		if(cont > 2){
			return true;
		}
		return false;
	}
	public static boolean esVocal(char ma[],int pos){
		return (ma[pos] == 'a' ||ma[pos] == 'e' ||ma[pos] == 'i' ||ma[pos] == 'o' ||ma[pos] == 'u');
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

	public static void correrIzq(char ma[], int pos) {
		for (int c = pos; c < COL - 1; c++) {
			ma[c] = ma[c + 1];
		}
		ma[COL-1] = ' ';
	}

}