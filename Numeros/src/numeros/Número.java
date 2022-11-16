/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 * TODO: Definir comportamiento como en
 * http://learnxinyminutes.com/docs/julia/
 */
package numeros;

/**
 * Cualquier número.
 * @author blackzafiro
 */
public abstract class Número {
    
    /**
     * Suma dos números realizando las adaptaciones necesarias entre tipos.
     * El tipo del número devuelto debe ser el mismo del número que llama
     * al método (i.e. <code>this</code>).
     * @param n número a sumar
     * @return un nuevo número con el valor del resultado.
     */
    public abstract Número suma(Número n);
    public abstract Número resta(Número n);
    public abstract Número multiplica(Número n);
    public abstract Número divide(Número n) throws ArithmeticException;
    
    /**
     * Devuelve una cadena con los ceros y unos de la representación binaria
     * del tipo primitivo donde se encuentra almacenado el valor de este número.
     * @return una cadena con la representación binaria.
     */
    public abstract String representaciónBinaria();
    
}
