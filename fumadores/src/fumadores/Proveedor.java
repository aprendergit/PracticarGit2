package fumadores;

public class Proveedor extends Thread {
	
	Monitor m;
	public Proveedor (Monitor m){
		this.m = m;
	}

	public void run(){
		while(true){
			m.poner_ingrediente();
		}
	}
}
