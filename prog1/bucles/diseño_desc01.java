/*
Escribir un método que retorne el mayor de dos números. Usar
ese método para calcular el máximo de una serie de números
ingresados por el usuario (20 números en total).
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño_desc01 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));
	final static int MAX = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int mayor = 0;
		
		for (int i = 1 ; i <= MAX ; i++){
			num = obtenerNum();
			if (esMayor(num, mayor)){
				mayor = num;
			}
		}
		System.out.println("el mayor de los num ingresados es: "+mayor);
	}
	public static boolean esMayor(int num, int aux){
		return (num > aux);
	}
	public static int obtenerNum(){
		int n = 0;
		try{
			System.out.println("ingrese un num");
			n = new Integer(e.readLine());
		}catch (Exception exc){
			System.out.println(exc);
			return n = 0;
		}
		return n;
	}
}
