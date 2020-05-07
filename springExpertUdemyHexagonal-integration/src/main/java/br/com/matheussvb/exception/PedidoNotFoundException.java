package br.com.matheussvb.exception;

public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException(String message) {
        super(message);
    }
}
