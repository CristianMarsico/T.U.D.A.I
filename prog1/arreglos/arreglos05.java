/*
Hacer un programa que dado un arreglo de caracteres de tamaño 10 que se encuentra cargado,
invierta el orden del contenido. Este intercambio no se debe realizar de manera explícita, hay que
hacer un método que incluya una iteración de intercambio.
 */
public class arreglos05 {

	final static int MAX = 10;
	final static int POS = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		invertir(arr);
		mostrar(arr);
	}

	public static void mostrar(int arr[]) {
		for (int i = POS; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void invertir(int arr[]) {
		int izq = POS;
		int der = MAX - 1;
		int aux = POS;

		while (izq < der) {
			intercambiarPos(arr, izq, der, aux);
			izq++;
			der--;
		}
	}
	public static void intercambiarPos (int arr[], int izq, int der, int aux){
		aux = arr[izq];
		arr[izq] = arr[der];
		arr[der] = aux;
	}

}
