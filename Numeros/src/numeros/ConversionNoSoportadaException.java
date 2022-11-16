/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

/**
 * Excepción utilizada cuando no existe una conversión definida entre
 * los tipos de número que operan.
 * @author blackzafiro
 */
public class ConversionNoSoportadaException extends RuntimeException {
    
    /** Constructor. */
    public ConversionNoSoportadaException() {
        super();
    }
    
    /**
     * Constructor.
     * @param msg Mensaje especificando porqué fue lanzada esta excepción.
     */
    public ConversionNoSoportadaException(String msg) {
        super(msg);
    }
}
