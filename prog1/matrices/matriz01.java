/*
Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se encuentra precargada,
invierta el orden del contenido por fila. Este intercambio no se debe realizar de manera explícita, hay
que hacer un método que incluya una iteración de intercambio. 
 */
public class matriz01 {

	final static int FILA = 5;
	final static int COL = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ma[][] = {  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };
		
		for (int f= 0;f<FILA;f++){
			invertir(ma, f);			
		}
		mostrar (ma);
	}
	public static void mostrar (int ma[][]){
		for (int f = 0; f<FILA; f++){
			for (int c = 0; c <COL; c++){
				System.out.print(ma[f][c] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void invertir (int ma[][], int fila){
		int izq = 0;
		int der = COL-1;
		int aux = 0;
		
			while (izq < der){
				aux = ma[fila][izq];
				ma[fila][izq] = ma[fila][der];
				ma[fila][der] = aux;
				izq++;
				der--;		
		}
	}

}
