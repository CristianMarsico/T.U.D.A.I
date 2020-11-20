import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IngresosPorTeclado {

	final static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int entero;
		String texto;
		char caracter;
		double numConComa;
		float flotante;

		try {
			

			System.out.println("ingrese Int");
			entero = new Integer(entrada.readLine());
	
			System.out.println("ingrese String");
			texto = entrada.readLine();
	
			System.out.println("ingrese Char");
			caracter = (char) (entrada.readLine().charAt(0));
			
			System.out.println("ingrese Double");
			numConComa = new Double(entrada.readLine());
			
			System.out.println("ingrese Float");
			flotante = new Float(entrada.readLine());

			System.out.println("entero es " + entero);
			System.out.println("String es " + texto);
			System.out.println("Char es " + caracter);
			System.out.println("Double es " + numConComa);
			System.out.println("Float es " + flotante);
		
		
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

}