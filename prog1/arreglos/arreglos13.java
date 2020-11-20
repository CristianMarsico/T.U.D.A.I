/*
Hacer un programa que devuelva la posicion de inicio y de fin de la primer secuencia
*/
public class arreglos13 {

	final static int MAX = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 0, 1, 2, 3, 0, 0, 4, 5, 6, 0, 0, 7, 8, 0, 0, 0, 9, 10, 8 };
		secuencia(arr);
	}
	public static void secuencia (int arr[]){
		int fin = 0;
		int inicio;
		int cont = 0;
		
		while (fin < MAX-1){
			inicio = iniSec(arr, fin);
			if (inicio != MAX-1){
				fin = finSec(arr, inicio);
				cont++;
			}else{
				fin = MAX-1;
			}
			verificar (inicio, fin, cont);
			fin++;
		}
	}
	public static void verificar (int pos, int fin, int cont){
		if (cont == 1){
			imprimir(pos, fin);
		}
	}
	public static void imprimir (int pos, int fin){
		System.out.println("la primer secuencia del arreglo comienza en "+pos+ " termina en "+fin);
	}
	public static int finSec (int arr[], int pos){
		while (pos < MAX && arr[pos] != 0){
			pos++;
		}
		return pos-1;
	}
	public static int iniSec (int arr[], int pos){
		while (pos < MAX && arr[pos] == 0){
			pos++;
		}
		return pos;
	}

}
