/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

/**
 * Números enteros almacenados como <code>int</code>.
 * @author blackzafiro
 */
public class Entero extends Real {
    
    /** Número de bits utilizados para almacenar un entero. */
    private static final int NUMBITS = 32;
    
    /** Variable primitiva utilizada para almacenar al entero. */
    private int numero;
    
    /** Constructor. */
    public Entero(int n) {
        this.numero = n;
    }
    
    /** Devuelve el valor de este número como un tipo de dato primitivo.
     * 
     * @return una copia del <code>int</code> donde fue almacenado este
     * número.
     */
    public int daPrimitivo() {
        return numero;
    }

    @Override
    public Entero suma(Número n) {
        if(n instanceof Entero) {
            return suma((Entero)n);
        } else if(n instanceof Doble) {
            return suma((Doble)n);
        }
        throw new ConversionNoSoportadaException("Número " + n);
    }
    
    public Entero suma(Entero n) {
        return new Entero(numero + n.numero);
    }
    
    public Entero suma(Doble n) {
        return new Entero(numero + (int)n.daPrimitivo());
    }

    @Override
    public Entero resta(Número n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entero multiplica(Número n) {
        if(n instanceof Entero) return multiplica((Entero)n);
		else if(n instanceof Doble) return multiplica((Doble) n);
        throw new ConversionNoSoportadaException("Número " + n);
    }
    
    public Entero multiplica(Entero n) {
        return new Entero(numero * n.numero);
    }
	
	public Entero multiplica(Doble n) {
        return new Entero(numero * (int)n.daPrimitivo());
    }

    @Override
    public Entero divide(Número n) throws ArithmeticException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String representaciónBinaria() {
        StringBuffer bf = new StringBuffer(NUMBITS);
        for(int i = 0; i < NUMBITS; i++) {
            bf.append((numero & (1 << i)) >>> i);
        }
        bf.reverse();
        return bf.toString();
    }
    
    /**
     * Representación en cadena de este número.
     * @return representación en cadena de este número.
     */
    public String toString() {
        return Integer.toString(numero);
    }

    @Override
    public int compareTo(Real o) {
        if(o instanceof Entero) {
            return numero - ((Entero)o).numero;
        } else if(o instanceof Doble) {
            double d = ((Doble)o).daPrimitivo();
            return (d > numero) ? 1 : (d == numero) ? 0 : -1;
        }
        throw new ConversionNoSoportadaException("Real " + o);
    }
}
