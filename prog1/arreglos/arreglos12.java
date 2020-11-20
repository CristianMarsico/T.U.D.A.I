/*
Invertir el orden de un arreglo
 */
public class arreglos12 {

	final static int MAX = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		invertirOrden(arr);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void invertirOrden(int arr[]) {
		int izq = 0;
		int der = MAX - 1;
		int aux = 0;
		
		while (izq < der) {
			aux = arr[izq];
			arr[izq] = arr[der];
			arr[der] = aux;
			izq++;
			der--;
		}
	}

}
