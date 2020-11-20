/*
 Realizar un programa que, dada una opción (1,2,3,4), permita
 realizar operaciones entre tres números reales (r1,r2,r3) ingresados
 desde teclado. Para la opción

 1. Calcular la raíz cuadrada de (r1-r3)
 2. Calcular el promedio de r1, r2 y r3
 3. Calcular cociente de la raíz cuadrada de (r3 - r2) dividida
 por r1
 4. Calcular el cociente del promedio de los tres valores
 dividido por la raíz cuadrada de r2
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class diseño_desc03 {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 1;
		int num1 = 0, num2 = 0, num3 = 0;
		int cont = 0;

		while (opcion >= 1 && opcion <= 4) {
			opcion = obtenerNum(cont);
			cont++;
			if (opcion >= 1 && opcion <= 4) {
				num1 = obtenerNum(cont);
				cont++;
				num2 = obtenerNum(cont);
				cont++;
				num3 = obtenerNum(cont);
				cont = 0;
				resolver(num1, num2, num3, opcion);
			}
		}
		System.out.println("fin del bucle");
	}

	public static float calcularRaiz(int num1, int num3) {
		int resultado = num1 - num3;
		if (resultado < 0) {
			System.out.println("no se puede sacar la raiz a un num negativo");
			return resultado = -1;
		} else {
			float raiz = (float) Math.sqrt(resultado);
			return raiz;
		}
	}

	public static float calcularProm(int n1, int n2, int n3) {
		int suma = n1 + n2 + n3;
		float prom = (float) (suma / 3);
		return prom;
	}

	public static float itemPuntoTres(int n1, int n2, int n3) {
		int resultadoResta = n3 - n2;
		float raiz = 0;
		float resultadoFinal = 0;

		if (resultadoResta < 0) {
			return -1;
		} else {
			raiz = (float) (Math.sqrt(resultadoResta));
			resultadoFinal = (float) (raiz / n1);
			return resultadoFinal;
		}
	}

	public static void resolver(int num1, int num2, int num3, int opc) {
		float raiz = 0;
		float prom = 0;
		float cociente_raiz = 0;
		float cociente_Prom = 0;
		
		switch (opc) {
		case 1:
			raiz = calcularRaiz(num1, num3);
			if (raiz < 0) 
				System.out.println("no se puede sacar raiz a un num negativo");
			else 
				System.out.println("la RAIZ del resultado de la resta de n1 y n3 es: " + raiz);
			break;
		
		case 2:
			prom = calcularProm(num1, num2, num3);
			System.out.println("el promedio de los tres numeros es " + prom);
			break;
		
		case 3:
			cociente_raiz = itemPuntoTres(num1, num2, num3);
			if (cociente_raiz < 0) 
				System.out.println("no se puede hacer operacion, resultado de la raiz es negativa");
			else 
				System.out.println("el resultado de raiz(num3-num2) dividido n1 es: "+ cociente_raiz);
			break;
		
		default:
			cociente_Prom = itemPuntoCuatro(raiz, prom, cociente_raiz, num2);
			if (cociente_Prom <0)
				System.out.println("la raiz de num2 fue negativa y no se pudo hacer la operacion");
			else
				System.out.println("el resultado de los 3 promedios anteriores divido raiz de num2 es: "+cociente_Prom);
			break;
		}
	}
	public static float itemPuntoCuatro (float caso1, float caso2, float caso3, int num2){
		float suma = (float)((caso1+caso2+caso3)/3);
		float raiz = 0;
		float resultadoFinal = 0;
		if (num2 < 0){
			return -1;
		} else {
			raiz = (float)(Math.sqrt(num2));
			 resultadoFinal = (float) suma/raiz;
			 return resultadoFinal;
		}
	}

	public static int obtenerNum(int cont) {
		int n = 0;
		try {
			if (cont == 0) {
				System.out.println("ingrese opcion e / 1 y 4");
				n = new Integer(e.readLine());
			} else {
				System.out.println("elija numero n° " + cont);
				n = new Integer(e.readLine());
			}

		} catch (Exception exc) {
			return n = 0;
		}
		return n;
	}

}
