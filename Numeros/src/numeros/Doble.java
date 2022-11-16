/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

/**
 * Números con punto flotante, almacenados como <code>double</code>.
 * @author blackzafiro
 */
public class Doble extends Real {
    
    /** Número de bits utilizados para almacenar un número en punto flotante. */
    private static final int NUMBITS = 64;
    
    /** Variable primitiva utilizada para almacenar al doble. */
    private double número;
    
    /** Constructor. */
    public Doble(double n) {
        this.número = n;
    }
    
    /** Devuelve el valor de este número como un tipo de dato primitivo.
     * 
     * @return una copia del <code>double</code> donde fue almacenado este
     * número.
     */
    public double daPrimitivo() {
        return número;
    }

    @Override
    public Doble suma(Número n) {
        if(n instanceof Entero) {
            return suma((Entero)n);
        } else if(n instanceof Doble) {
            return suma((Doble)n);
        }
        throw new ConversionNoSoportadaException("Número " + n);
    }
    
    public Doble suma(Entero n) {
        return new Doble(número + n.daPrimitivo());
    }
    
    public Doble suma(Doble n) {
        return new Doble(número + n.número);
    }

    @Override
    public Doble resta(Número n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doble multiplica(Número n) {
        if(n instanceof Doble) {
            return multiplica((Doble)n);
        } else if(n instanceof Entero) {
            return multiplica((Entero)n);
        }
        throw new ConversionNoSoportadaException("Número " + n);
    }
    
    public Doble multiplica(Doble n) {
        return new Doble(número * n.número);
    }
    
    public Doble multiplica(Entero n) {
        return new Doble(número * n.daPrimitivo());
    }

    @Override
    public Doble divide(Número n) throws ArithmeticException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String representaciónBinaria() {
        long numero = Double.doubleToRawLongBits(this.número);
        return Long.toBinaryString(numero);
    }
    
    /**
     * Representación en cadena de este número.
     * @return representación en cadena de este número.
     */
    public String toString() {
        return String.format("%.2f", número);
    }

    @Override
    public int compareTo(Real o) {
        if(o instanceof Doble) {
            double temp = número - ((Doble)o).número;
            return temp < 0 ? -1 : temp == 0 ? 0 : 1;
        }
        if(o instanceof Entero) {
            double temp = número - ((Entero)o).daPrimitivo();
            return temp < 0 ? -1 : temp == 0 ? 0 : 1;
        }
        throw new ConversionNoSoportadaException("Real " + o);
    }
}
