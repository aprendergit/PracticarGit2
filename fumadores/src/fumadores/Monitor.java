package fumadores;

import java.util.Random;

public class Monitor {
	
	boolean disponible = false; // representa la disponibilidad del ingrediente. El proveedor lo ha dejado en la mesa
	String ingrediente = null; // representa el ingrediente que hay en la mesa
	private final int MAX_DELAY = 1000;
	
	public synchronized void coger_ingrediente(String nombre, String i){
		while (!disponible || !ingrediente.equals(i)){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			System.out.println(nombre + " ha cogido " + ingrediente + " y ha empezado a fumar");
			try {
				//Thread.sleep(3000);
				Thread.sleep((int)Math.random()*MAX_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(nombre + " ha terminado de fumar...");
			disponible = false;
			notifyAll();
			
			
		
	}
	
	public synchronized void poner_ingrediente(){
		
		while (disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int numero = (new Random().nextInt(3))+1;
		System.out.println(numero);
		if (numero == 1){
			ingrediente = "tabaco";
		}
		else if (numero == 2){
			ingrediente = "papel";	
		}
		else
			ingrediente = "cerillas";
		System.out.println("El proveedor ha puesto " + ingrediente);
		disponible = true;
		notifyAll();
		
	}

}
