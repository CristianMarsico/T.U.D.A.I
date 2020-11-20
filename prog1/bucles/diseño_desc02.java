/*
Escribir un programa que simule 1000 lanzamientos de un dado y
muestre por pantalla cuantas veces salió el valor del dado
correspondiente al número entero N ingresado por el usuario.
Considerar el valor N ingresado se corresponda a un valor posible
para un dado. Usar la sentencia Math.random() que devuelve un
valor aleatorio real entre 0 y 1.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño_desc02 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));
	final static int MAX = 1000;
	final static int DADO_MENOR = 1;
	final static int DADO_MAYOR = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int dado = 0;
		int cont = 0;

		
		num = obtenerNum();
		
		for (int i = 1; i <= MAX; i++) {
			dado = (int) (DADO_MAYOR * Math.random() + DADO_MENOR);
			if (verificar(num, dado)) {
				cont++;
			}
		}
		System.out.println("el num " + num + " salio " + cont + " veces");
	}

	public static boolean verificar(int num, int dado) {
		return (num == dado);
	}

	public static int obtenerNum() {
		int n = DADO_MENOR-1;
		while (n < DADO_MENOR || n > DADO_MAYOR) {
		try {
			System.out.println("ingrese un num e/ 1 y 6");
			n = new Integer(e.readLine());
		} catch (Exception exc) {
			System.out.println(exc);
			return n = 0;
		}	
		}
		return n;
	}
}
