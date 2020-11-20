/*
Escribir un programa que mientras el usuario ingresa un caracter distinto
del caracter ‘*’, invoque a un método que imprima si es caracter dígito o
caracter letra minúscula, y si es letra minúscula imprimir si es vocal o
consonante.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño01 {
	
	final static char SIGNO = '*';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char caracter = ' ';

		while (caracter != SIGNO) {
			caracter = obtenerLetra();
			if(caracter != SIGNO)
				imprimir(caracter);
		}
		System.out.println("fin  del bucle");
	}
	public static boolean esDigito(char letra){
		return (letra >= '0' && letra <= '9');
	}
	public static boolean esMinuscula (char letra){
		return (letra >= 'a' && letra <= 'z');
	}
	public static boolean esVocal (char letra){
		return (letra =='a'|| letra == 'e'||letra =='i'||letra =='o'||letra =='u');
	}
	public static void imprimir (char letra){
		if (esDigito(letra)){
			System.out.println("es caracter digito");
		} else if(esMinuscula(letra)){
			System.out.println("es minuscula");
			if (esVocal(letra)){
				System.out.println("es vocal");
			} else{
				System.out.println("es consonante");
			}
		}
	}
	public static char obtenerLetra(){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char letra= ' ';
		try{
			System.out.println("ingrese un caracter");
			letra = (char)e.readLine().charAt(0);
		}catch (Exception exc){
			System.out.println(exc);
			return letra = ' ';
		}
		return letra;
	}
}
