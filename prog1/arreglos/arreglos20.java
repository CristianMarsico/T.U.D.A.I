/*
Obtener la secuencia mayor
*/
public class arreglos20 {
	
	final static int MAX = 16;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {0,0,3,2,1,0,4,1,2,3,0,4,2,4,5,4};
		obtenerSec(arr);
	}
	public static void obtenerSec(int arr[]){
		int fin = 0, inicio;
		int sec_mayor = 0;
		int auxIni = 0;
		int auxFin = 0;
		
		while (fin < MAX){
			inicio = iniSec(arr, fin);
			if (inicio != MAX-1){
				fin = finSec(arr, inicio);
			}else{
				fin = MAX-1;
			}
			if ((fin - inicio +1) > sec_mayor){
				sec_mayor = (fin - inicio +1);
				auxIni = inicio;
				auxFin = fin;
			}
			fin++;
		}
		imprimir (sec_mayor, auxIni, auxFin);
	}
	public static void imprimir (int mayor, int inicio, int fin){
		System.out.println("la mayor secuencia es de "+mayor);
		System.out.println("comienza en "+inicio);
		System.out.println("termina en "+fin);
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
