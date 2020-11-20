/*
Simule 10000 tiradas de un dado de 4 caras con valores del 1 al 4. Calcule qué número
salió más veces (se considera que no hay empates). Luego solicite al/la usuario/a que
intente adivinar cuál fue este número, mostrándole un mensaje dependiendo de si lo
adivinó o no.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nuevo1 {
	
	final static int MAX = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int caraMayor = tirarDado();
		int num = elegirCaraDado();
		verificar(caraMayor, num);
	}
	public static void verificar(int mayor, int num){
		if (num == mayor){
			System.out.println("ganaste, el que mas veces salio es el num "+mayor);
		}else{
			System.out.println("perdiste, el que mas veces salio es el num "+mayor);
		}
	}
	public static int elegirCaraDado(){
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		int n= 0;
		while (n < 1 || n > 4){
			try{
				System.out.println("intente advinar");
				n = new Integer(e.readLine());
			}catch (Exception exc){
				n = 0;
			}
		}
		return n;
	}
	public static int tirarDado(){
		int dado = 0;
		int cara1=0, cara2=0,cara3=0,cara4=0;
		for (int i = 0;i<MAX;i++){
			dado = (int)(4*Math.random()+1);
			
			if(dado==1){
				cara1++;
			}else if (dado == 2){
				cara2++;
			}else if(dado == 3){
				cara3++;
			}else{
				cara4++;
			}
		}
		return masVecesSalio(cara1, cara2,cara3, cara4);
	}
	public static int masVecesSalio (int cara1, int cara2, int cara3, int cara4){
		if (cara1 > cara2 && cara1 > cara3 && cara1 > cara4){
			return 1;
		}else if (cara2 > cara3 && cara2 > cara4){
			return 2;
		}else if (cara3 > cara4){
			return 3;
		}
		return 4;
	}

}
