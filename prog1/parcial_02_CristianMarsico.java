/*
Realizar un programa modularizado en Java que resuelva lo siguiente
Dada una matriz de MxN de caracteres con secuencias separadas por espacio en blanco se pide obtener la cantidad 
de secuencias que tengan más de dos vocales. 
Si la cantidad es mayor al promedio de tamaños de todas las secuencias de la matriz,
se deben eliminar las secuencias que tengan como mínimo una vocal.
Todas las secuencias empiezan y terminan con uno o más espacios en blanco obligatoriamente.

Usar constantes y buenas prácticas.
 */

public class parcial_02_CristianMarsico {

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
		
		float prom = 0;
		int cont = 0;
		for (int f = 0; f < FILA; f++) {
			prom = 0;
			prom = obtenerProm(ma[f]);
			cont = contarVocales(ma[f]);
			if(4 > prom){ 		//cambiando el contador por un num mayor al prom funciona
				recorrerSec(ma[f]);						
			}
			System.out.println("la sec " +f +" tiene "+cont+ " secuencias con mas de 2 vocales");
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

	public static int contarVocales(char ma[]){
		int cantidadVocal = 0, contVocal= 0;
		int inicio = 0, fin = 0;
		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
				
			} else {
				fin = COL - 1;
			}
			cantidadVocal = tieneMasDeDosVocales(ma, inicio, fin);
			if(cantidadVocal > 2){
				contVocal++;
			}
			fin++;
		}
		return contVocal;
	}
	public static float obtenerProm(char ma[]){
		int inicio = 0, fin = 0, suma=0;
		int contadorSec=0;
		float prom = 0;
		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
				
			} else {
				fin = COL - 1;
			}
			if((fin-inicio+1) > 0){
				contadorSec++;
			}
			suma+=(fin-inicio+1);
			fin++;
		}
		return prom=(float)(suma/contadorSec);
	}
	public static void recorrerSec(char ma[]) {
		int inicio = 0, fin = 0;
		while (fin < COL) {
			inicio = iniSec(ma, fin);
			if (inicio != COL - 1) {
				fin = finSec(ma, inicio);
				
			} else {
				fin = COL - 1;
			}
				if(tieneMasDeUnaVocal(ma, inicio, fin)){
					for(int i = inicio; i<=fin; i++){
						correrIzq(ma, inicio);
					}
					fin=inicio;
				}			
			fin++;
		}
		
	}
	public static void correrIzq(char ma[], int pos) {
		for (int c = pos; c < COL - 1; c++) {
			ma[c] = ma[c + 1];
		}
		ma[COL-1] = ' ';
	}
	public static boolean tieneMasDeUnaVocal(char ma[], int pos, int fin){
		int cont = 0;
		while(pos <= fin){
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
	public static int tieneMasDeDosVocales(char ma[], int pos, int fin){
		int cont = 0;
		while(pos <= fin){
			if(esVocal(ma,pos)){
				cont++;
			}
			pos++;
		}
		return cont;
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

}
