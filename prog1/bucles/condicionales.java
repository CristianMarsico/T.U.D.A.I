/*
 * FILMINA 3 DE PROGRAMACION 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class condicionales {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*---------------------------------------------------------------------------------------------------------------------------------
		 *Verifica si el numero ingresado es positivo o negativo 
		 */
		// pos_Neg();

		/*------------------------------------------------------------------------------------------------------------------------------
		 *Imprime "grande" si el numero es > a 100 y "chico" si es menor 
		 */
		// grande_Chico();

		// nombreDia();
		// vocal_Cons();
		// Crec_Decr();

		/*--------------------------------------------------------------------------------------------------------------------------------
		 *Verifica si el numero ingresado corresponde a un mes del año.
		 *En caso de ingresar el num 2 (febrero) debe ingresar el año para ver si es biciesto o no
		 */
		// mes_Anio();

		/*---------------------------------------------------------------------------------------------------------------------------------
		 * Distingue mayúsculas de minúsculas
		 */
		// caracteres();

		/*-------------------------------------------------------------------------------------------------------------------
		 * Escribir un programa que permita el ingreso de dos números enteros
		 * por teclado y realice: _ imprima A si el primero mayor al segundo, _
		 * o imprima B si ambos son múltiplos de 2, _ o imprima C para ninguna
		 * de las opciones anteriores
		 */
		// comparar();

		/*---------------------------------------------------------------------------------------------------------------------------------------
		 * Escribir un programa que ingrese un número entero por teclado y
		 * realice: _ imprima es múltiplo de 6 y de 7 si cumple con esa
		 * condición, _ o imprima es mayor a 30 y múltiplo de 2 si cumple con
		 * esa condición, _ imprima si el cociente de la división de dicho
		 * número con 5 es mayor a 10 sin importar las condiciones previas.
		 */
		//verif();
	}

	public static void verif() {
		int num;
		try {
			System.out.println("ingrese un num");
			num = new Integer(e.readLine());

			if ((num % 6 == 0) && (num % 7 == 0)) {
				System.out.println("es multiplo de 6 y 7");
			} else if ((num > 30) && (num % 2 == 0)) {
				System.out.println("es mayor a 30 y mult de 2");
			}
			if ((num / 5) > 10) {
				System.out.println("la division entre 5 es mayor a 10");
			}

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void comparar() {
		int num1, num2;
		try {
			System.out.println("ingrese 2 num");
			num1 = new Integer(e.readLine());
			num2 = new Integer(e.readLine());

			if (num1 > num2) {
				System.out.println("A");
			} else if ((num1 % 2 == 0) && (num2 % 2 == 0)) {
				System.out.println("B");
			} else {
				System.out.println("C");
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void caracteres() {
		char caracter;
		try {

			System.out.println("Ingrese un caracter :");
			caracter = e.readLine().charAt(0);
			if (('a' <= caracter) && (caracter <= 'z')) {

				System.out.println("Es caracter minuscula");

			} else if (('A' <= caracter) && (caracter <= 'Z')) {

				System.out.println("Es caracter mayuscula");

			} else {

				System.out.println("No es caracter letra");

			}
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void mes_Anio() {
		try {
			System.out.println("ingrese mes");
			int mes = new Integer(e.readLine());

			switch (mes) {
			case 1:
				System.out.println("enero, 30 dias");
				break;
			case 12:
				System.out.println("diciembre, 31 dias");
				break;
			case 2:
				System.out.println("ingrese año");
				int anio = new Integer(e.readLine());
				if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
					System.out.println("biciesto");
					System.out.println("febrero, tiene 29 dias");
				} else {
					System.out.println("febrero, tiene 28 dias");
				}

				break;
			default:
				System.out.println("otro año");
				break;
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void vocal_Cons() {
		try {
			System.out.println("ingrese una letra");
			char letra = (char) (e.readLine().charAt(0));

			switch (letra) {
			case 'a':
			case 'A':
				System.out.println("es vocal");
			case 'b':
			case 'B':
				System.out.println("es vocal");
			case 'c':
			case 'C':
				System.out.println("es vocal");
			case 'd':
			case 'D':
				System.out.println("es vocal");
			case 'e':
			case 'E':
				System.out.println("es vocal");
			default:
				System.out.println("es consonante");
				break;
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void Crec_Decr() {
		try {
			System.out.print("ingrese 3 num");
			int num1 = new Integer(e.readLine());
			int num2 = new Integer(e.readLine());
			int num3 = new Integer(e.readLine());

			if (num1 > num2 && num2 > num3) {
				System.out.println("decreciente");
			} else if (num1 < num2 && num2 < num3) {
				System.out.println("creciente");
			} else {
				System.out.println("error");
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void nombreDia() {
		try {
			System.out.println("ingrese un num p/ver el dia");
			int num = new Integer(e.readLine());
			if (num <= 7 || num != 0) {
				switch (num) {
				case 1:
					System.out.println("es Lunes");
					break;
				case 2:
					System.out.println("es Martes");
					break;
				case 3:
					System.out.println("es Miercoles");
					break;
				case 4:
					System.out.println("es Jueves");
					break;
				case 5:
					System.out.println("es Viernes");
					break;
				case 6:
					System.out.println("es Sabado");
					break;
				case 7:
					System.out.println("es Domingo");
					break;
				default:
					System.out.println("no corresponde con dia de la semana");
					break;
				}
			}

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void grande_Chico() {
		try {
			System.out.println("ingrese un num p/ver si es grande o chico");
			int num = new Integer(e.readLine());

			if (num > 100) {
				System.out.println("el num es grande");
			} else {
				System.out.println("el num es chico");
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void pos_Neg() {
		try {
			System.out.println("ingrese un num");
			int num = new Integer(e.readLine());

			if (num >= 0) {
				System.out.println("el num es pos");
			} else {
				System.out.println("el num es neg");
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

}
