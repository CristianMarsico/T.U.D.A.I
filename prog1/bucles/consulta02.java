/*
Solicite el ingreso por teclado de una serie de N caracteres. Informe cuántos de ellos
fueron vocales y cuántos no fueron letras.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class consulta02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = obtener_tamano_N();
		char letra = ' ';
		int vocal = 0, noLetra = 0;

		for (int i = 0; i < N; i++) {
			letra = obtenerChar();
			if (esVocal(letra)) {
				vocal++;
			}
			if (!(esLetra(letra))) {
				noLetra++;
			}
		}
		System.out.println("la cantidad de vocales son: " + vocal);
		System.out
				.println("la cantidad de caracteres que NO fueron letras son: "
						+ noLetra);
	}

	public static boolean esLetra(char letra) {
		return (letra >= 'a' && letra <= 'z' || letra >= 'A' && letra <= 'Z');
	}

	public static boolean esVocal(char letra) {
		return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o'
				|| letra == 'u' || letra == 'A' || letra == 'E' || letra == 'I'
				|| letra == 'O' || letra == 'U');
	}

	public static char obtenerChar() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char l = ' ';
		try {
			System.out.println("ingrese un caracter");
			l = (char) e.readLine().charAt(0);
		} catch (Exception exc) {
			return ' ';
		}
		return l;
	}

	public static int obtener_tamano_N() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;

		while (n <= 0) {
			try {
				System.out.println("ingrese un numero");
				n = new Integer(e.readLine());
			} catch (Exception exc) {
				n = 0;
			}
		}
		return n;
	}

}
