import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuatroEnLineaAzar {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		String jugador;
		char ficha;
		boolean linea = false, comparar = false;
		iniciar();
		int modo = seleccionar_modo();
		informar_eleccion(modo);
		int cont = 0, f = 0, c = 0, j = 0;
		int FILA = 0;
		FILA = tamaño_matriz(FILA);
		int COL = tamaño_matriz(FILA);
		FILA++;
		COL++;
		char ma[][] = new char[FILA][COL];
		cargar(ma, FILA, COL);

		while (linea == false && cont < (FILA - 1) * (COL - 1)) {
			jugador = seleccionar_jugador(cont, modo);
			ficha = tipo(cont);
			saltar_linea();
			mostrar(ma, FILA, COL);
			f = pedir_fila(ma, FILA, jugador, j);
			c = pedir_fila(ma, COL, jugador, f);
			comparar = verificar_ficha(ma, FILA, COL, f, c, ficha);

			while (comparar == false) {
				System.out.println("Lugar ocupado, seleccione otro");
				f = pedir_fila(ma, FILA, jugador, j);
				c = pedir_fila(ma, COL, jugador, f);
				comparar = verificar_ficha(ma, FILA, COL, f, c, ficha);
			}
			if (comparar == true) {
				colocar_ficha(ma, f, c, ficha);
				cont++;
				informar_jugada(f, c, jugador, ficha);
				saltar_linea();
			}
			if (cont > 6) {
				linea = sumar_lugares(ma, FILA, COL, f, c, ficha, cont, jugador);
			}
		}
		System.out.println("FIN DEL JUEGO");
	}

	public static boolean sumar_lugares(char ma[][], int FILA, int COL, int f,
			int c, char ficha, int cont, String jugador) {
		boolean linea = false;
		if (linea == false) {
			linea = vertical(ma, FILA, f, c, ficha);
		}
		if (linea == false) {
			linea = horizontal(ma, COL, f, c, ficha);
		}
		if (linea == false) {
			linea = diag_der(ma, FILA, COL, f, c, ficha);
		}
		if (linea == false) {
			linea = diag_izq(ma, FILA, COL, f, c, ficha);
		}

		if (linea == true) {
			mostrar(ma, FILA, COL);
			System.out.println("HAS GANADO !!! ganador " + jugador);
			informar_jugada(f, c, jugador, ficha);
		}
		if (linea == false && cont == (FILA - 1) * (COL - 1)) {
			mostrar(ma, FILA, COL);
			System.out.println("HAS EMPATADO !!!");
			informar_jugada(f, c, jugador, ficha);
		}
		return linea;
	}

	public static boolean diag_izq(char ma[][], int FILA, int COL, int f,
			int c, char ficha) {
		int cont = 0, auxF = f, auxC = c;
		while (f > 0 && c > 0 && ma[f][c] == ficha) {
			cont++;
			f--;
			c--;
		}
		auxF++;
		auxC++;
		while (auxF < FILA && auxC < COL && ma[auxF][auxC] == ficha) {
			cont++;
			auxF++;
			auxC++;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean diag_der(char ma[][], int FILA, int COL, int f,
			int c, char ficha) {
		int cont = 0, auxC = c, auxF = f;
		while (f > 0 && c < COL && ma[f][c] == ficha) {
			cont++;
			f--;
			c++;
		}
		auxF++;
		auxC--;
		while (auxF < FILA && auxC > 0 && ma[auxF][auxC] == ficha) {
			cont++;
			auxF++;
			auxC--;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean horizontal(char ma[][], int COL, int f, int c,
			char ficha) {
		int auxC = c, cont = 0;
		while (c > 0 && ma[f][c] == ficha) {
			cont++;
			c--;
		}
		auxC++;
		while (auxC < COL && ma[f][auxC] == ficha) {
			cont++;
			auxC++;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean vertical(char ma[][], int FILA, int f, int c,
			char ficha) {
		int cont = 0, auxF = f;
		while (f > 0 && ma[f][c] == ficha) {
			cont++;
			f--;
		}
		auxF++;
		while (auxF < FILA && ma[auxF][c] == ficha) {
			cont++;
			auxF++;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static int pedir_fila(char ma[][], int FILA, String jugador, int j) {
		int num = 0;
		while (num < 1 || num > FILA - 1) {
			try {
				if (jugador != "PC") {
					if (j == 0) {
						System.out.print("Ingrese el numero de FILA ");
						num = new Integer(e.readLine());
					} else {
						System.out.print("ingrese el numero de COLUMNA ");
						num = new Integer(e.readLine());
					}
				} else {
					System.out.print("precione ENTER para que juegue PC ");
					String enter = e.readLine();
					num = (int) (Math.random() * FILA - 1);
				}
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
		return num;
	}

	public static void saltar_linea() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

	public static void informar_jugada(int f, int c, String jugador, char ficha) {
		System.out.println("el " + jugador + " coloco su ficha " + ficha
				+ " en la fila " + f + " columna " + c);
	}

	public static void colocar_ficha(char ma[][], int f, int c, char ficha) {
		ma[f][c] = ficha;
	}

	public static boolean verificar_ficha(char ma[][], int FILA, int COL,
			int f, int c, char ficha) {
		if ((f > 0 || f < FILA) && (c > 0 || c < COL) && ma[f][c] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	public static int pedir_fila(int FILA, int f) {
		int num = 0;
		while (num < 1 || num > FILA - 1) {
			try {
				if (f == 0) {
					System.out.print("Elige el numero de FILA ");
					num = new Integer(e.readLine());

				} else {
					System.out.print("Elige el numero de COLUMNA ");
					num = new Integer(e.readLine());
				}
			} catch (Exception exc) {
				num = 0;
			}
		}
		return num;
	}

	public static char tipo(int cont) {
		char ficha;
		if (cont % 2 == 0) {
			ficha = 'O';
		} else {
			ficha = 'X';
		}
		return ficha;
	}

	public static String seleccionar_jugador(int cont, int modo) {
		String player;
		if (cont % 2 == 0) {
			player = "jugador 1";
		} else if (modo == 1) {
			player = "jugador 2";
		} else {
			player = "PC";
		}
		return player;
	}

	public static void mostrar(char ma[][], int FILA, int COL) {
		for (int i = 1; i < COL; i++) {
			System.out.print("    " + i);
		}

		for (int f = 1; f < FILA; f++) {
			System.out.println();
			System.out.print(f + " ¦");
			for (int c = 1; c < COL; c++) {
				System.out.print(" " + ma[f][c] + "  ¦");
			}
			System.out.println();
			if (f < FILA - 1) {
				for (int c = 1; c < COL; c++) {
					if (c == 1) {
						System.out.print("  +----+");
					} else {
						System.out.print("----+");
					}
				}
			} else {
				for (int j = 1; j < COL; j++) {
					if (j == 1) {
						System.out.print("  +-----");
					} else if (j < COL - 1) {
						System.out.print("-----");
					} else {
						System.out.println("----+");
					}
				}
			}
		}
	}

	public static void cargar(char ma[][], int FILA, int COL) {
		for (int f = 0; f < FILA; f++) {
			for (int c = 0; c < COL; c++) {
				ma[f][c] = ' ';
			}
		}
	}

	public static int tamaño_matriz(int F) {
		int tam = 0;
		while (tam < 4 || tam > 15) {
			try {
				if (F == 0) {
					System.out.print("Seleccione el tamaño de las FILAS ");
					tam = new Integer(e.readLine());
				} else {
					System.out.print("Seleccione el tamaño de las COLUMNAS ");
					tam = new Integer(e.readLine());
				}
			} catch (Exception exc) {
				tam = 0;
			}
		}
		return tam;
	}

	public static void informar_eleccion(int modo) {
		if (modo == 1) {
			System.out.println("Ud. ha elegido modo 1vs1");
		} else {
			System.out.println("Ud. ha elegido modo 1vsPC");
		}
		System.out.println("---------------------------------------");
	}

	public static int seleccionar_modo() {
		int num = 0;
		while (num < 1 || num > 2) {
			try {
				System.out.println("Seleccione una de las dos opciones");
				System.out.println("1-  1vs1");
				System.out.println("2-  1vsPC");
				num = new Integer(e.readLine());
			} catch (Exception exc) {
				num = 0;
			}
		}
		System.out.println("---------------------------------------");
		return num;
	}

	public static void iniciar() {
		String enter;
		System.out.println("Bienvendidos al 4 en linea ");
		try {
			System.out.print("Precione cualquier tecla para continuar ");
			enter = e.readLine();
		} catch (Exception exc) {
			enter = " ";
		}
		System.out.println("---------------------------------------");
	}
}
