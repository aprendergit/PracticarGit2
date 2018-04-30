package fumadores;

public class Fumador extends Thread {
String nombre;
String ingrediente;
Monitor m;

public Fumador(Monitor m,String nombre, String ingrediente){
	this.m = m;
	this.nombre = nombre;
	this.ingrediente = ingrediente;
}
public void run(){
	while(true){
		m.coger_ingrediente(nombre, ingrediente);
	}
}
}
