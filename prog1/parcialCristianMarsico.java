/*
Pedir al usuario que ingrese letras minúsculas respetando el orden del abecedario. 
Si una letra no respeta este orden se debe pedir nuevamente. 
Si el caracter no es una letra también se debe pedir nuevamente. 
Las iteraciones terminan cuando se ingresa el caracter ‘z’. Si alguna vez se ingresa la ‘t’, mostrar la tabla de multiplicar del 5. 
Finalmente, se debe informar
cuántos caracteres correctos se ingresaron.
cuántos ingresos fueron erróneos 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class parcialCristianMarsico {
	final static int MAX = 10;
	final static int NUMERO_5 = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char letra = ' ';;
		char aux = 'a';
		int datosErroneos = 0;
		int datosCorrectos = 0;

		while (letra != 'z') {
			while (letra <= aux) {
				letra = obtenerChar(aux);
				if (letra <= aux){
					datosErroneos++;
				}
			}
			aux = letra;
			datosCorrectos++;
			if (letra == 't'){
				imprimir_tabla_multiplicar5();
			}		
		}
		System.out.println("la cantidad de datos erroneos fueron "+datosErroneos);
		System.out.println("la cantidad de datos validos fueron "+datosCorrectos);
	}
	public static void imprimir_tabla_multiplicar5(){
		System.out.println("tabla del "+NUMERO_5);
		for (int i = 1; i<=MAX; i++){
			System.out.print(i*NUMERO_5 + " ");
		}
	}

	public static char obtenerChar(char aux) {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char letra = ' ';
		while (letra < 'a' || letra > 'z') {
			try {
				System.out.println("ingrese un caracter mayor que " + aux);
				letra = (char) e.readLine().charAt(0);
			} catch (Exception exc) {
				letra = ' ';
			}
		}
		return letra;
	}

}
