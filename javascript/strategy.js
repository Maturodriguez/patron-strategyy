// Ejemplo equivalente en JavaScript. Operaciones simuladas.
class PagoTarjeta {
  pagar(importe) { return `Pago de $${importe.toFixed(2)} simulado con tarjeta.`; }
}
class PagoBilleteraVirtual {
  pagar(importe) { return `Pago de $${importe.toFixed(2)} simulado con billetera virtual.`; }
}
class PagoTransferencia {
  pagar(importe) { return `Solicitud de transferencia por $${importe.toFixed(2)} generada.`; }
}
class ProcesadorDePagos {
  constructor(metodoPago = null) { this.metodoPago = metodoPago; }
  setMetodoPago(metodoPago) {
    if (!metodoPago) throw new Error("Debe seleccionar un medio de pago.");
    this.metodoPago = metodoPago;
  }
  procesar(importe) {
    if (importe <= 0) return "El importe debe ser mayor que cero.";
    if (!this.metodoPago) return "No se seleccionó un medio de pago.";
    return this.metodoPago.pagar(importe);
  }
}
const procesador = new ProcesadorDePagos();
procesador.setMetodoPago(new PagoBilleteraVirtual());
console.log(procesador.procesar(25999.90));
