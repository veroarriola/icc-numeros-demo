/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Calculadora con interfaz de texto tipo intérprete de comandos.
 * @author blackzafiro
 */
public class UsoNumeros {
    
    private static final String PROMPT =  "*> ";
    
    /**
     * Listado de los comandos soportados por esta aplicación.
     */
    private enum Comando {
        salir,
        bin,
        suma,
        resta,
        mult,
        div;
    }

    /**
     * Método de entrada para la calculadora.
     * @param args no se utiliza.
     */
    public static void main(String[] args) {
        System.out.println("Los comandos disponibles son:");
        for(Comando c : Comando.values()) {
            System.out.println(c);
        }
        System.out.print(PROMPT); 
        
        String line, scomando;
        Comando comando;
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine())!=null) {
                Scanner sTokens = new Scanner(line);
                
                if(!sTokens.hasNext()) {
                    System.out.print(PROMPT); continue;
                }
                scomando = sTokens.next();
                
                try{
                    comando = Comando.valueOf(scomando);
                } catch (IllegalArgumentException iae) {
                    System.out.println("Comando no soportado: " + scomando);
                    System.out.print(PROMPT); continue;
                }
                System.out.println("[Echo]: " + comando);
                
                if(comando == Comando.salir) {
                    System.out.println("Adios");
                    System.exit(0);
                }
                
                // Un operando
                if(!sTokens.hasNext()) {
                    System.out.format("No se incluyó el primer operando requerido por el comando <%s>%n%s ", scomando, PROMPT); continue;
                }
                Número op1 = null;
                try {
                    op1 = FabricaDeNumeros.analiza(sTokens.next());
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                    System.out.print(PROMPT); continue;
                }
                
                if(comando == Comando.bin) {
                    System.out.format("%s: %s%n", op1.getClass().getName(), op1.representaciónBinaria());
                    System.out.print(PROMPT); continue;
                }
                
                // Dos operandos
                if(!sTokens.hasNext()) {
                    System.out.format("No se incluyó el segundo operando requerido por el comando <%s>%n%s ", scomando, PROMPT); continue;
                }
                Número op2 = null;
                try {
                    op2 = FabricaDeNumeros.analiza(sTokens.next());
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                    System.out.print(PROMPT); continue;
                }
                
                // Operaciones con dos operandos
                try {
                    switch(comando) { 
                        case suma:
                            System.out.println(op1.suma(op2));
                            break;
                        case resta:
                            System.out.println(op1.resta(op2));
							break;
                        case mult:
                            System.out.println(op1.multiplica(op2));
							break;
                        case div:
                            System.out.println(op1.divide(op2));
                    }
                } catch(UnsupportedOperationException uoe) {
                    System.out.println("No he terminado el programa, intenta con otra.");
                } catch(ConversionNoSoportadaException cns) {
                    System.out.println("No es válido realizar esta operación.  Sugerencia: revisa el orden de tus operandos.");
                }
                
                if(sTokens.hasNext()) {
                    System.out.format("Se ignoraron los operandos extra para el comando <%s>%n%s ", scomando, PROMPT); continue;
                }
                System.out.print(PROMPT); 
            }
        } catch(IOException io) {
            System.err.println("Algo salió al cerrar el flujo" + io);
        }
    }
    
}
