import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bucles {

	final static int MAX = 10;
	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*--------------------------------------------------------------------------------------------------------
		 * Escribir un programa que dado un número natural ingresado por el
		 * usuario imprima la tabla de multiplicar de ese número.
		 */
		// verif1();

		/*---------------------------------------------------------------------------------------------------------
		 * Escribir un programa que dado un valor ingresado por el usuario menor
		 * que 10 y mayor a 1, muestre por pantalla una cuenta regresiva de
		 * números desde dicho valor hasta el 0 inclusive.
		 */
	//	verif2();

		/*
		 * Escribir un programa que solicite el ingreso de un número mayor a 50,
		 * y los muestre por pantalla en caso de ser múltiplo de 2 o 3.
		 */
		
		//verif3();
	
	}
	public  static void verif3(){
		char letra;
		int cont=0;
		try{
			System.out.println("ingrese una letra");
			letra = (char) (e.readLine().charAt(0));
			
			while (('a'<=letra) || ('z'<=letra)){
				System.out.println("ingrese una letra");
				letra = (char) (e.readLine().charAt(0));
			switch (letra){
				case 'a':cont++;break;
				case 'e': cont++;break;
				case 'i': cont++;break;
				case 'o': cont++;break;
				case 'u': cont++;break;
			}
			System.out.println("ingrese otra letra");
			letra = (char) (e.readLine().charAt(0));
			}
			System.out.println("se ingresaron " + cont + "vocales");
		}catch (Exception exc){
			System.out.println(exc);
		}
	}

	public static void verif2() {
		int num;
		try {
			System.out.println("ingrese un num");
			num = new Integer(e.readLine());
			if ((num >= 1) && (num <= 10)) {
				for (int i = num; i >= 0; i--) {
					System.out.println(i);
				}
			} else {
				System.out.println("error");
			}

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void verif1() {
		int num;
		try {
			System.out.println("ingrese un num");
			num = new Integer(e.readLine());

			for (int i = 0; i <= MAX; i++) {
				System.out.print(num * i + "  ");
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

}
