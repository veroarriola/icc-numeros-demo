/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author blackzafiro
 */
public class PruebaExpresionRegular {
    public static final String PROMPT = "%> ";
    private static String[] expresiones = {
        "[+-]?[0-9]+(\\.[0-9]+)?",
        "[+-]?([0-9]+(\\.[0-9]+)?)?i",
        "[+-]?[0-9]+(\\.[0-9]+)?[+-]([0-9]+(\\.[0-9]+)?)?i"
    };
    
    public static void main(String[] args) {
        try{
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String input;
		
                System.out.print(PROMPT);
		while((input=br.readLine())!=null){
                    if("salir".equals(input)) System.exit(0);
                    for(int i = 0; i < expresiones.length; i++) {
                        System.out.println(input.matches(expresiones[i]));
                    }
                    System.out.print(PROMPT);
		}
            }
        } catch(IOException io) {
            System.out.println("Algo salió al cerrar el flujo" + io);
        }
    }
}
