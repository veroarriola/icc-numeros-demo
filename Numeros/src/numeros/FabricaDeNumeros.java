/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

import java.util.Scanner;

/**
 * Lugar para métodos estáticos que reconstruyen los distintos tipos de números
 * a partir de la cadena que los representa.
 * @author blackzafiro
 */
public class FabricaDeNumeros {
    
    /**
     * Analiza una cadena numérica, determinando qué tipo de número se desea
     * representar y crea un ejemplar de la clase que más se ajuste.
     * @param token cadena que representa al número (no debe haber espacios
     *              entre los caracteres).
     * @return objeto de la subclase de <code>Número</code> más indicada.
     */
    public static Número analiza(String token){
        Scanner scann = new Scanner(token);
        if(scann.hasNextInt()) {
            return new Entero(Integer.parseInt(token));
        } else if(scann.hasNextDouble()) {
            return new Doble(Double.parseDouble(token));
        } else {
            try {
                return Complejo.analiza(token);
            } catch(NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                throw new NumberFormatException("Imposible reconocer número " + token);
            }
        }
    }
    
    /**
     * Analiza una cadena numérica, determinando qué tipo de número real se
     * desea representar y crea un ejemplar de la clase que más se ajuste.
     * @param token cadena que representa al número (no debe haber espacios
     *              entre los caracteres).
     * @return objeto de la subclase de <code>Número</code> más indicada.
     */
    public static Real analizaReal(String token) {
        Scanner scann = new Scanner(token);
        if(scann.hasNextInt()) {
            return new Entero(Integer.parseInt(token));
        } else if(scann.hasNextDouble()) {
            return new Doble(Double.parseDouble(token));
        } else throw new NumberFormatException("No se reconoce al real " + token);
    }
}
