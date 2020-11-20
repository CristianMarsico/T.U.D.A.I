/*
Escribir un programa que mientras el usuario ingrese un número entero
entre 1 y 10, pida ingresar un caracter, y por cada caracter ingresado
imprima:
– “letra minúscula” si el caracter es una letra del abecedario en minúscula;
– “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
– “dígito” si el caracter corresponde a un carácter número;
– “otro” para los restantes casos de caracteres.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño04 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		char letra = ' ';
		
		while (num >= 1 && num <=10){
			letra = obtenerChar();
			imprimir(letra);
			num = obtenerNum();
		}
		System.out.println("fin del bucle");
	}
	public static int obtenerNum(){
		int n= 0;
		try{
			System.out.println("ingrese un num ");
			n = new Integer(e.readLine());
		}catch(Exception exc){
			System.out.println(exc);
			return n=0;
		}
		return n;
	}
	public static boolean esDigito(char letra){
		return (letra >= '0' && letra <= '9');
	}
	public static boolean esMayuscula(char letra){
		return (letra >= 'A' && letra <= 'Z');
	}
	public static boolean esMinuscula(char letra){
		return (letra >= 'a' && letra <= 'z');
	}
	public static void imprimir (char letra){
		if (esMinuscula(letra)){
			System.out.println("es minuscula");
		}else if (esMayuscula(letra)){
			System.out.println("es mayuscula");
		}else if(esDigito(letra)){
			System.out.println("es digito");
		}else{
			System.out.println("es otra cosa");
		}
	}
	public static char obtenerChar(){
		char letra= ' ';
		try{
			System.out.println("ingrese un caracter");
			letra = (char)e.readLine().charAt(0);
		}catch(Exception exc){
			System.out.println(exc);
		}
		return letra;
	}
}
