/*
Escribir un programa que mientras que el usuario ingrese un caracter letra
minúscula, pida ingresar un numero entero. Si el número ingresado está
entre 1 y 5 inclusive deberá imprimir la tabla de multiplicar de dicho
numero.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño03 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letra = 'a';
		int num = 0;
		
		while (letra >='a' && letra <= 'z'){
			num = obtenerNum();
			if (verif(num)){
				imprimirTabla(num);
			}
			letra = obtenerChar();
		}
		System.out.println("fin del bucle");
	}
	public static char obtenerChar(){
		char letra = ' ';
		try{
			System.out.println("ingrese una letra");
			letra = (char)e.readLine().charAt(0);
		}catch(Exception exc){
			System.out.println(exc);
		}
		return letra;
	}
	public static void imprimirTabla(int num){
		System.out.println("tabla del "+num);
		for (int i=1;i<=10;i++){
			System.out.print(i*num +"  ");
		}
		System.out.println();
	}
	public static boolean verif(int num){
		return (num >=1 && num <=5);
	}
	public static int obtenerNum(){
		int num = 0;
		try{
			System.out.println("ingrese un num");
			num = new Integer(e.readLine());
		}catch(Exception exc){
			System.out.println(exc);
		}
		return num;
	}
}
