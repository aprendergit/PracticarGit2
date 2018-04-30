package fumadores;

public class Principal {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		System.out.println("Comienza el programa..");
		Proveedor proveedor = new Proveedor(m);
		Fumador fumador1 = new Fumador(m, "Ana", "tabaco");
		Fumador fumador2 = new Fumador(m, "Rosa", "papel");
		Fumador fumador3 = new Fumador(m, "María", "cerillas");
		
		proveedor.start();
		fumador1.start();
		fumador2.start();
		fumador3.start();
		

	}

}
