package fenoyagostina.ludeoteca.exception;

public class EmailYaExisteException extends RuntimeException {
    public EmailYaExisteException(String email) {
        super("Ya existe un socio con el email " + email);
    }
}
