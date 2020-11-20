/*
Calcular el promedio de 50 num nat ingresados por teclado.
Se debe chequear que el num ingresado sea mayor que el anterior, de lo contrario volver a pedir el num.
Informar cuantos fueron impares o mult de 7
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nuevo {

	final static int MAX = 50;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = -1, impar = 0, mult7 = 0;
		int aux = 0;

		for (int i = 0; i < MAX; i++) {
			while (num <= aux) {
				num = obtenerNum(aux);
			}
			if (num > aux) {
				aux = num;
			}
			if (!(esImpar(num))) {
				impar++;
			}
			if (esMult7(num)) {
				mult7++;
			}
		}
		System.out.println("la cantidad de impares son " + impar);
		System.out.println("la cantidad de mult7 son " + mult7);
	}

	public static boolean esMult7(int num) {
		return (num % 7 == 0);
	}

	public static boolean esImpar(int num) {
		return (num % 2 == 0);
	}

	public static int obtenerNum(int aux) {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		while (n <= 0) {
			try {
				System.out.println("ingrese un num mayor que " + aux);
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = 0;
			}
		}
		return n;
	}

}
