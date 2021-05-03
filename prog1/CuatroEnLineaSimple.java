import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuatroEnLineaSimple {

	final static BufferedReader e = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jugador = " ";
		char ficha = ' ';
		boolean linea = false;
		int cont = 0, f = 0, c = 0, col_Pos = -1, fila_Pos = -1;

		f = obtenerTam(cont);
		c = obtenerTam(f);
		f++;
		c++;
		char ma[][] = new char[f][c];
		cargar(ma, f, c);

		int modo = selec_Jugadores(); // Seleccionamos 1 o 2 jugadores.
		inicio_Juego(modo); // informamos cual fue la seleccion si 1 o 2.

		while (linea == false && cont < (f - 1) * (c - 1)) {
			if (cont > 0) {
				informar_jugada(jugador, ficha, fila_Pos, col_Pos);
			}
			jugador = establecer_Turno(cont, modo);
			ficha = obtener_ficha(cont);
			mostrar(ma, f, c);
			col_Pos = obtenerPos(ma, f, c, jugador);
			fila_Pos = colocar_ficha(ma, f, col_Pos, ficha);
			cont++;
			saltar_linea();
			if (cont >= 6) {
				linea = verif_linea(ma, f, c, col_Pos, fila_Pos, ficha,
						jugador, cont);
			}
		}
		System.out.println("FIN DEL JUEGO");
	}

	public static boolean vertical(char ma[][], int FILA, int c, int f,
			char ficha) {
		int cont = 0;
		int pos = f;
		while (f < FILA && ma[f][c] == ficha) {
			cont++;
			f++;
		}
		pos = pos - 1;
		while (pos > 0 && ma[pos][c] == ficha) {
			cont++;
			f--;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean horizontal(char ma[][], int COL, int c, int f,
			char ficha) {
		int cont = 0;
		int pos = c;
		while (c < COL && ma[f][c] == ficha) {
			cont++;
			c++;
		}
		pos = pos - 1;
		while (pos > 0 && ma[f][pos] == ficha) {
			cont++;
			pos--;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean diag_der(char ma[][], int FILA, int COL, int c,
			int f, char ficha) {
		int cont = 0;
		int pos = c;
		int j = f;
		while (f > 0 && c < COL && ma[f][c] == ficha) {
			cont++;
			f--;
			c++;
		}
		pos = pos - 1;
		j = j + 1;
		while (j < FILA && pos > 0 && ma[j][pos] == ficha) {
			cont++;
			j++;
			pos--;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean diag_izq(char ma[][], int FILA, int COL, int c,
			int f, char ficha) {
		int cont = 0;
		int pos = c;
		int j = f;
		while (f > 0 && c > 0 && ma[f][c] == ficha) {
			cont++;
			f--;
			c--;
		}
		pos = pos + 1;
		j = j + 1;
		while (j < FILA && pos < COL && ma[j][pos] == ficha) {
			cont++;
			j++;
			pos++;
		}
		if (cont > 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verif_linea(char ma[][], int FILA, int COL, int c,
			int f, char ficha, String jugador, int cont) {
		boolean linea = false;
		if (linea == false) {
			linea = vertical(ma, FILA, c, f, ficha);
		}
		if (linea == false) {
			linea = horizontal(ma, COL, c, f, ficha);

		}
		if (linea == false) {
			linea = diag_der(ma, FILA, COL, c, f, ficha);
		}
		if (linea == false) {
			linea = diag_izq(ma, FILA, COL, c, f, ficha);
		}

		if (linea == true) {
			saltar_linea();
			mostrar(ma, FILA, COL);
			informar_jugada(jugador, ficha, f, c);
			System.out.println("GANASTE !!!! ganador " + jugador);
		} else if (linea == false && cont == (FILA - 1) * (COL - 1)) {
			saltar_linea();
			mostrar(ma, FILA, COL);
			informar_jugada(jugador, ficha, f, c);
			System.out.println("EMPATE !!!");
		}
		return linea;
	}

	public static void informar_jugada(String jugador, char ficha, int FILA,
			int COL) {
		System.out.println("el " + jugador + " coloco su ficha en la fila "
				+ FILA + " y columna " + COL);
	}

	public static void saltar_linea() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

	public static char obtener_ficha(int cont) {
		char ficha;
		if (cont % 2 == 0) {
			ficha = 'O';
		} else {
			ficha = 'X';
		}
		return ficha;
	}

	public static void mostrar(char ma[][], int FILA, int COL) {
		for (int i = 1; i < COL; i++) {
			System.out.print("   " + (i) + " ");
		}
		System.out.println();

		for (int f = 1; f < FILA; f++) {// IMPRESION DEL TABLERO
			System.out.print((f) + "¦" + " ");// LIMITE IZQUIERDO DEL TABLERO
			for (int c = 1; c < COL; c++) {
				System.out.print(ma[f][c] + " " + "¦" + "  ");// FICHA
			}
			System.out.println();

			if (f < FILA - 1) {// SEPARADOR DE FILAS
				for (int c = 1; c < COL; c++) {
					if (c == 1) {
						System.out.print(" " + "+" + "-" + "-" + "-" + "+");
					} else if (c < COL - 1) {
						System.out.print("-" + "-" + "-" + "-" + "+");
					} else {
						System.out.println("-" + "-" + "-" + "-" + "¦");
					}
				}
			} else {
				for (int j = 1; j < COL; j++) {// FONDO DEL TABLERO
					if (j == 1) {
						System.out.print(" " + "+" + "-" + "-" + "-" + "-");
					} else if (j < COL - 1) {
						System.out.print("-" + "-" + "-" + "-" + "-");
					} else {
						System.out.print("-" + "-" + "-" + "-" + "+");
					}
				}
			}
		}
		System.out.println();
	}

	public static int colocar_ficha(char ma[][], int FILA, int pos, char ficha) {
		int f = FILA - 1;
		while (pos > 0 && ma[f][pos] != ' ') {
			f--;
		}
		ma[f][pos] = ficha;
		return f;
	}

	public static int obtenerPos(char ma[][], int FILA, int COL, String jugador) {
		int pos = 0;
		boolean linea = false;
		while (pos < 1 || pos >= COL && linea == false) {
			if (jugador != "PC") {
				try {
					System.out.print("Elige una pos e/ 1 y " + (COL - 1) + " ");
					pos = new Integer(e.readLine());
					linea = verificar_Pos(ma, COL, pos);
				} catch (Exception exc) {
					pos = 0;
				}
			} else {
				try {
					String enter = " ";
					System.out.print("Precione ENTER para que juegue PC ");
					enter = e.readLine();
					pos = (int) (Math.random() * COL);
					linea = verificar_Pos(ma, COL, pos);
				} catch (Exception exc) {
					System.out.println(exc);
				}
			}
		}
		return pos;
	}

	public static boolean verificar_Pos(char ma[][], int COL, int pos) {
		if (pos == 0 || ma[1][pos] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	public static String establecer_Turno(int cont, int modo) {
		String player;
		if (cont % 2 == 0) {
			player = "jugador_1";
		} else if (modo == 1) {
			player = "jugador_2";
		} else {
			player = "PC";
		}
		return player;
	}

	public static void inicio_Juego(int modo) {
		System.out.println("Bienvenidos/as");
		if (modo == 1) {
			System.out.println("Ud a seleccionado 1 vs 1");
		} else {
			System.out.println("Ud a seleccionado 1 vs PC");
		}
	}

	public static int selec_Jugadores() {
		int player = 0;
		while (player < 1 || player > 2) {
			try {
				System.out.println("Seleccione la cantidad de jugadores");
				System.out.println("1) 1 vs 1");
				System.out.println("2) 1 vs PC");
				player = new Integer(e.readLine());
			} catch (Exception exc) {
				player = 0;
			}
		}
		return player;
	}

	public static void cargar(char ma[][], int FILA, int COL) {
		for (int f = 0; f < FILA; f++) {
			for (int c = 0; c < COL; c++) {
				ma[f][c] = ' ';
			}
		}
	}

	public static int obtenerTam(int cont) {
		int tam = 0;
		while (tam < 4 || tam > 15) {
			try {
				if (cont == 0) {
					System.out.print("Ingrese el tamaño de las FILAS ");
					tam = new Integer(e.readLine());
				} else {
					System.out.print("Ingrese el tamaño de las COLUMNAS ");
					tam = new Integer(e.readLine());
				}
			} catch (Exception exc) {
				tam = 0;
			}
		}
		return tam;
	}
}
