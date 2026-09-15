package banco;

public class Main {
	public static void main(String[] args) {

		Cuenta cuenta1 = new Cuenta("Ana", 1000);
		Cuenta cuenta2 = new Cuenta("Luis", 500);

		Banco banco = new Banco();

		banco.transferir(cuenta1, cuenta2, 300);

		System.out.println("Saldo Ana: " + cuenta1.getSaldo());

		System.out.println("Saldo Luis: " + cuenta2.getSaldo());

		GestorFicheros gestor = new GestorFicheros();

		gestor.comprobarFichero();
	}

}