import java.util.Scanner;

// Demo educativa: no procesa dinero real ni se conecta a una pasarela.
interface MetodoPago {
    ResultadoPago pagar(double importe);
}

class ResultadoPago {
    private final boolean aprobado;
    private final String mensaje;

    public ResultadoPago(boolean aprobado, String mensaje) {
        this.aprobado = aprobado;
        this.mensaje = mensaje;
    }
    public boolean isAprobado() { return aprobado; }
    public String getMensaje() { return mensaje; }
}

class PagoTarjeta implements MetodoPago {
    public ResultadoPago pagar(double importe) {
        return new ResultadoPago(true, String.format(
            "Pago de $%.2f simulado con tarjeta.", importe));
    }
}
class PagoBilleteraVirtual implements MetodoPago {
    public ResultadoPago pagar(double importe) {
        return new ResultadoPago(true, String.format(
            "Pago de $%.2f simulado con billetera virtual.", importe));
    }
}
class PagoTransferencia implements MetodoPago {
    public ResultadoPago pagar(double importe) {
        return new ResultadoPago(true, String.format(
            "Solicitud de transferencia por $%.2f generada.", importe));
    }
}

class ProcesadorDePagos {
    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodoPago) {
        if (metodoPago == null) throw new IllegalArgumentException(
            "Debe seleccionar un método de pago.");
        this.metodoPago = metodoPago;
    }

    public ResultadoPago procesar(double importe) {
        if (importe <= 0)
            return new ResultadoPago(false, "El importe debe ser mayor que cero.");
        if (metodoPago == null)
            return new ResultadoPago(false, "No se seleccionó un medio de pago.");
        return metodoPago.pagar(importe);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProcesadorDePagos procesador = new ProcesadorDePagos();

        System.out.println("=== Sistema de cobros online (simulación) ===");
        System.out.print("Importe de la compra: $");
        if (!sc.hasNextDouble()) {
            System.out.println("Debe ingresar un importe numérico.");
            sc.close();
            return;
        }
        double importe = sc.nextDouble();

        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Billetera virtual");
        System.out.println("3. Transferencia bancaria");
        System.out.print("Seleccione medio de pago: ");
        if (!sc.hasNextInt()) {
            System.out.println("Opción inválida.");
            sc.close();
            return;
        }

        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> procesador.setMetodoPago(new PagoTarjeta());
            case 2 -> procesador.setMetodoPago(new PagoBilleteraVirtual());
            case 3 -> procesador.setMetodoPago(new PagoTransferencia());
            default -> {
                System.out.println("Medio de pago inválido.");
                sc.close();
                return;
            }
        }

        ResultadoPago resultado = procesador.procesar(importe);
        System.out.println("Resultado: " + resultado.getMensaje());
        System.out.println("Estado: " + (resultado.isAprobado() ? "OK" : "RECHAZADO"));
        sc.close();
    }
}
