# Ejercicio práctico: agregar un medio de pago

## Consigna (10 minutos)
El sistema ya permite pagar con tarjeta, billetera virtual y transferencia. Se solicita agregar una estrategia `PagoCripto` como simulación.

1. ¿Qué interfaz debe implementar?
2. Escribí `pagar(double importe)`.
3. Mostrá cómo seleccionar la nueva estrategia.
4. Explicá por qué el procesador puede utilizarla.

## Solución
```java
class PagoCripto implements MetodoPago {
    @Override
    public ResultadoPago pagar(double importe) {
        return new ResultadoPago(true,
            String.format("Pago simulado de $%.2f mediante criptoactivos.", importe));
    }
}
```
En el menú se puede añadir `case 4 -> procesador.setMetodoPago(new PagoCripto());`.
`PagoCripto` implementa `MetodoPago`, por lo que el procesador puede delegar en ella sin conocer su clase concreta. En esta demo también se modifica el menú; en un sistema más grande la selección podría resolverse con un registro de estrategias o una fábrica.
