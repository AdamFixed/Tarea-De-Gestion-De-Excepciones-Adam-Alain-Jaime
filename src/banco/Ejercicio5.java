package banco;
 
public class Main {
 public static void main(String[] args) {
 
 Cuenta cuenta1 = new Cuenta("Ana", 1000);
 Cuenta cuenta2 = new Cuenta("Luis", 500);
 
 Banco banco = new Banco();
 
 banco.transferir(cuenta1, cuenta2, 300);
 
 System.out.println(
 "Saldo Ana: " + cuenta1.getSaldo());
 
 System.out.println(
 "Saldo Luis: " + cuenta2.getSaldo());
 
 GestorFicheros gestor = new GestorFicheros();
 
 gestor.comprobarFichero();
 }
 
}
package banco;
 
public class Cuenta {
 
 private String titular;
 private double saldo;
 
 public Cuenta(String titular, double saldoInicial) {
 this.titular = titular;
 this.saldo = saldoInicial;
 }
 
 public void retirar(double cantidad) {
 if (cantidad <= 0) {
 throw new IllegalArgumentException(
 "La cantidad debe ser mayor que 0");
 }
 
 if (cantidad > saldo) {
 throw new IllegalStateException(
 "Saldo insuficiente");
 }
 
 saldo -= cantidad;
 }
 
 public void ingresar(double cantidad) {
 if (cantidad <= 0) {
 throw new IllegalArgumentException(
 "La cantidad debe ser mayor que 0");
 }
 
 saldo += cantidad;
 }
 
 public double getSaldo() {
 return saldo;
 }
 
 public String getTitular() {
 return titular;
 }
}
package banco;
 
public class Banco {
 
 public void transferir(Cuenta origen,
 Cuenta destino,
 double cantidad)
 throws TransferenciaException {
 
 if (origen == null || destino == null) {
 throw new IllegalArgumentException(
 "Las cuentas no pueden ser null");
 }
 
 if (cantidad <= 0) {
 throw new IllegalArgumentException(
 "La cantidad debe ser positiva");
 }
 
 if (origen.getSaldo() < cantidad) {
 throw new TransferenciaException(
 "No hay saldo suficiente para realizar la transferencia");
 }
 
 origen.retirar(cantidad);
 destino.ingresar(cantidad);
 }
}
 
package banco;
 
public class TransferenciaException extends Exception {
 
 public TransferenciaException(String mensaje) {
 super(mensaje);
 }
}
package banco;
 
import java.io.FileReader;
 
public class GestorFicheros {
public void comprobarFichero() {
FileReader lector = new FileReader("cuentas.txt");
System.out.println("Fichero abierto");
lector.close();
}
}
 
