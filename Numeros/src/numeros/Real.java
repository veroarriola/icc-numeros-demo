/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

/**
 * Tipo numérico que representa números reales.
 * @author blackzafiro
 */
public abstract class Real extends Número implements Comparable<Real> {
    public abstract Real suma(Número n);
    public abstract Real resta(Número n);
    public abstract Real multiplica(Número n);
    public abstract Real divide(Número n) throws ArithmeticException;
}
