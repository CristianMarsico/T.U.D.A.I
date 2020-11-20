/*
Solicite el ingreso por teclado de una serie de N caracteres. Informe cuántas veces
fueron ingresados los caracteres ‘t’, ‘u’, ’d’, ‘a’,‘i’ consecutivamente en ese orden.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = obtener_tamano_N();
		char letra = ' ';
		char letraSecuencia = 0;
		char anterior = ' ';
		int cont=0;

		for (int i = 0; i < N; i++) {
			letra = obtenerChar();
			letraSecuencia = verificarSecuencia(letra, anterior);
			anterior = letraSecuencia;
			if (letraSecuencia == 'i'){
				cont++;
				anterior = ' ';
			}
				
		}
		System.out.println("la secuencia TUDAI salio "+cont+" veces");

	}
	public static boolean esLetra_I(char letra, char anterior){
		return (anterior == 'a' && letra == 'i');
	}
	public static boolean esLetra_A(char letra, char anterior){
		return (anterior == 'd' && letra == 'a');
	}
	public static boolean esLetra_D(char letra, char anterior){
		return (anterior == 'u' && letra == 'd');
	}
	public static boolean esLetra_U(char letra, char anterior){
		return (anterior == 't' && letra == 'u');
	}
	public static boolean esLetra_T(char letra, char anterior){
		return (letra == 't' && anterior == ' ');
	}
	public static char verificarSecuencia(char letra, char anterior){
		
		if (esLetra_T(letra, anterior)) {
			anterior = letra;
		} else if (esLetra_U(letra, anterior)) {
			anterior = letra;
		} else if (esLetra_D(letra, anterior)) {
			anterior = letra;
		} else if (esLetra_A(letra, anterior)) {
			anterior = letra;
		} else if (esLetra_I(letra, anterior)){
			anterior = letra;
		} else {
			anterior = ' ';
		}
		return anterior;
	}

	public static char obtenerChar() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char letra = ' ';
		try {
			System.out.println("ingrese letra");
			letra = (char) e.readLine().charAt(0);
		} catch (Exception exc) {
			return letra = ' ';
		}
		return letra;
	}

	public static int obtener_tamano_N() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		while (n <= 0) {
			try {
				System.out.println("ingrese N");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = 0;
			}
		}
		return n;
	}
}
