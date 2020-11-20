/*
Escribir un programa que mientras que el usuario ingrese un número entero
natural, llame a un método que calcule la sumatoria entre 1 y dicho
numero y se lo retorne como resultado.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño02 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int suma = 0;
		while (num > 0){
			num = obtenerNum();
			if(num > 0){
				suma = obtenerSuma(num);
				System.out.println("la suma es de "+suma);
			}
		}
		System.out.println("fin del bucle");
	}
	public static int obtenerSuma(int num){
		int suma = 0;
		for (int i = 1; i<=num; i++){
			suma += i;
		}
		return suma;
	}
	public static int obtenerNum(){
		int num = 0;
		try{
			System.out.println("ingrese un numero");
			num = new Integer(e.readLine());
		}catch (Exception exc){
			System.out.println(exc);
		}
		return num;
	}
}
