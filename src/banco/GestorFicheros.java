package banco;

import java.io.FileReader;

public class GestorFicheros {
	public void comprobarFichero() {
		FileReader lector = new FileReader("cuentas.txt");
		System.out.println("Fichero abierto");
		lector.close();
	}
}