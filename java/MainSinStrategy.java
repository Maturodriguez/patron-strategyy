import java.util.Scanner;

public class MainSinStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Importe: $");
        double importe = sc.nextDouble();
        System.out.println("1-Tarjeta | 2-Billetera | 3-Transferencia");
        int opcion = sc.nextInt();

        // Al agregar medios de pago, este bloque central debe modificarse.
        if (opcion == 1) {
            System.out.println("Procesando tarjeta por $" + importe);
        } else if (opcion == 2) {
            System.out.println("Procesando billetera por $" + importe);
        } else if (opcion == 3) {
            System.out.println("Generando transferencia por $" + importe);
        } else {
            System.out.println("Medio de pago inválido");
        }
        sc.close();
    }
}
