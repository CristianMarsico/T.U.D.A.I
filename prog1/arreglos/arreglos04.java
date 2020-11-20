/*
Buscar un elemento en un arreglo de caracteres ya cargado de tamaño 10 y mostrar la/s
posicion/es del elemento, en caso de no estar indicarlo también.
*/
public class arreglos04 {

	final static int MAX = 10;
	final static int POS = 0;
	final static int NO_EXISTE = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'g', 'h', 'i', 'j', 'k' };
		
		char elemento = 'c';
		int pos = obtener_pos_del_elemento(arr, elemento);
		if (pos == NO_EXISTE) {
			System.out.println("no existe el elemento en el arreglo");
		} else {
			System.out
					.println("el elemento se encuentra en la posicion " + pos);
		}
	}

	public static int obtener_pos_del_elemento(char arr[], char elem) {
		boolean encontrado = false;
		int pos = POS;
		while (pos < MAX && encontrado == false) {
			if (arr[pos] == elem) {
				encontrado = true;
				return pos;
			}
			pos++;
		}
		return NO_EXISTE;
	}

}
