public class LimiteReservaExcedidoException extends RuntimeException{
    public LimiteReservaExcedidoException() {
        super("Número de assentos limite excedido");
    }
}
