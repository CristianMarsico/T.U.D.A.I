/*
Escribir un prog que mientras el usuario ingrese la 'x' termine .
Determinar cuantas veces salio la secuencia 'p' 'r' 'o' 'g'
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letra = ' ';
		String texto = " ";
		int cont = 0;

		while (letra != 'x') {
			letra = obtenerLetra();
			if (letra != 'x') {
				if (letra == 'p') {
					texto += letra;
				} else if (letra == 'r' && texto.equals("p")) {
					texto += letra;
				} else if (letra == 'o' && texto=="pr") {
					texto += letra;
				} else if (letra == 'g' && texto == "pro"){
					texto+=letra;
				} else{
					texto = " ";
				}
			}
			if (texto.equals("prog")){
				cont ++;
			}
		}
	}

	public static char obtenerLetra() {
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char letra = ' ';
		try {
			System.out.println("ingrese caracter");
			letra = (char) e.readLine().charAt(0);
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return letra;
	}

}
