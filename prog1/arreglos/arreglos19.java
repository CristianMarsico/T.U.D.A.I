/*
invertir el orden de la ultima secuencia
 */
public class arreglos19 {
	
	final static int MAX = 12;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 0, 1, 2, 0, 4, 5, 6, 0, 10, 9, 8, 7 };
		obtenerSec(arr);
		mostrar(arr);
	}
	public static void mostrar (int arr[]){
		for (int i = 0; i<MAX; i++){
			System.out.print(arr[i] + "  ");
		}
	}
	public static void obtenerSec(int arr[]){
		int fin = MAX-1, inicio= MAX-1;
		int cont = 0;
		
		while (fin >= 0){
			inicio = iniSec(arr, fin);
			if (fin != 0){
				fin = finSec(arr, inicio);
				cont++;
			}else{
				fin = 0;
			}
			
			if(cont == 1){
				invertir(arr, fin, inicio);
			}
			
			fin--;
		}
	}
	public static void invertir (int arr[], int pos, int fin){
		int aux= 0;
		while (pos < fin){
			aux = arr[pos];
			arr[pos] = arr[fin];
			arr[fin] = aux;
			pos++;
			fin--;
		}
	}
	public static int finSec (int arr[], int pos){
		while (pos>0 && arr[pos]!= 0){
			pos--;
		}
		return pos+1;
	}
	public static int iniSec(int arr[], int pos){
		while (pos>0 && arr[pos] == 0){
			pos--;
		}
		return pos;
	}

}
