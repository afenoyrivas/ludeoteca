package fenoyagostina.ludeoteca.exception;

public class DniYaExisteException extends RuntimeException {
    public DniYaExisteException(String dni) {
        super("Ya existe un socio con el dni " + dni);
    }
}
