/*
Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se encuentra precargada,
obtenga la cantidad de números pares que tiene y la imprima.
 */
public class matriz02 {
	
	final static int FILA = 5;
	final static int COL = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ma[][] = {  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };
		
		int par = 0;
		for (int f = 0;f<FILA; f++){
			 par += obtenerPar(ma[f]);
		}
		System.out.println("la cantidad de pares es: "+par);
	}
	public static int obtenerPar(int ma[]){
		int pos = 0, cont =0;
		while (pos < COL){
			if (ma[pos] % 2 == 0){
				cont++;
			}
			pos++;
		}
		return cont;
	}

}
