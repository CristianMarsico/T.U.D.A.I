/*
Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra cargado,
obtenga la cantidad de números pares que tiene y la imprima.
*/
public class arreglos06 {
	
	final static int MAX = 10;
	final static int POS = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int pares = obtener_catidad_pares(arr);
		System.out.println("el arreglo posee "+pares+ " numero pares");
	}
	public static int obtener_catidad_pares(int arr[]){
		int pos = POS;
		int cont = POS;
		while (pos < MAX){
			if (arr[pos] % 2 == 0){
				cont++;
			}
			pos++;
		}
		return cont;
	}

}
