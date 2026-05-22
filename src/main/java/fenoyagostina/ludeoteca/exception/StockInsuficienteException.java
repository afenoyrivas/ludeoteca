package fenoyagostina.ludeoteca.exception;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException() {
        super("Stock insuficiente");
    }
}
