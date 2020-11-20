/*
Escribir un programa que mientras el usuario ingrese un número entero
entre 1 y 10 realice:
– Si el numero ingresado es múltiplo de 3 pida ingresar un caracter, y para el caracter
ingresado imprima a que tipo de carácter esta asociado:
• “letra minúscula” si el caracter es una letra del abecedario en minúscula;
• “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
• “dígito” si el caracter corresponde a un carácter número;
• “otro” para los restantes casos de caracteres.
– Si el numero ingresado es múltiplo de 5 imprima la tabla de multiplicar del numero
ingresado.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class diseño06 {
	
	final static int MAX = 10;
	final static int MIN = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = MIN;
		int numero = MIN;
		char letra = ' ';
		
		while (num >= MIN && num <= MAX){
			numero = obtener_num_entre1y10();
			if (numero % 3 == 0){
				letra = obtenerChar();
				imprimir(letra);				
			}
			if (numero % 5 == 0){
				imprimirTabla(numero);				
			}
			
			num = obtenerNum();
		}
	}
	public static int obtenerNum(){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		try{
			System.out.println("ingrese un numero (menor q "+MIN+" y mayor que "+MAX+ " para salir");
			n = new Integer (e.readLine());
		}catch (Exception exc){
			return n = 0;
		}
		return n;
	}
	public static void imprimirTabla(int num){
		System.out.println("tabla del "+num);
		for (int i = MIN; i<= MAX; i++){
			System.out.print(i*num + "  ");
		}
		System.out.println();
	}
	public static boolean esDigito(char letra){
		return (letra >= '0' && letra <= '9');
	}
	public static boolean esMinuscula (char letra){
		return (letra >= 'a' && letra <= 'z');
	}
	public static boolean esMayuscula (char letra){
		return (letra >= 'A' && letra <= 'Z');
	}
	public static void imprimir (char letra){
		if (esDigito(letra)){
			System.out.println("es caracter digito");
		} else if(esMinuscula(letra)){
			System.out.println("es minuscula");
		} else if (esMayuscula(letra)){
			System.out.println("es mayuscula");
		} else {
			System.out.println("es otro digito");
		}
	}
	public static char obtenerChar(){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		char letra = ' ';
		try{
			System.out.println("ingrese un caracter");
			letra = (char)e.readLine().charAt(0);
		}catch(Exception exc){
			return ' ';
		}
		return letra;
	}
	public static int obtener_num_entre1y10(){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int num = MIN-1;
		while (num < MIN || num > MAX){
			try{
				System.out.println("ingrese un num e/ "+MIN+ " y "+MAX);
				num = new Integer(e.readLine());
			}catch (Exception exc){
				num = MIN-1;;
			}
		}
		return num;
	}

}
