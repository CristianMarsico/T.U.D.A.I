/*
1)
Hacer un programa que dado un arreglo ya cargado con 10 enteros, calcule el promedio y lo
muestre por la consola.
2)
Con el mismo arreglo del ejercicio anterior informe por pantalla cuantos elementos del mismo
están por encima del promedio calculado.
*/
public class arreglos02 {

	final static int MAX = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		float prom = calcular_promedio(arr);
		System.out.println("el promedio es "+prom);
		int mayores = verificar_mayores_al_promedio(arr, prom);
		
		if (mayores == 0){
			System.out.println("no hay numeros mayores al promedio obtenido");
		}else{
			System.out.println("hay "+mayores+ " numeros en el arreglo por encima al promedio");			
		}
	}
	public static int verificar_mayores_al_promedio(int arr[], float prom){
		int cont = 0;
		for (int i = 0; i<MAX; i++ ){
			if (arr[i] > prom){
				cont++;
			}
		}
		return cont;
	}
	public static float calcular_promedio(int arr[]){
		int suma =0;
		float prom = 0;
		for (int i =0;i<MAX;i++){
			suma += arr[i];
		}
		prom = (float) suma/MAX;
		return (prom); 
	}
}
