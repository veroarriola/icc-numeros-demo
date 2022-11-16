
import java.util.LinkedList;
import java.util.List;
import numeros.Número;
import numeros.Complejo;
import numeros.Doble;
import numeros.Entero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blackzafiro
 */
public class Suma implements Operacion{
	
	@Override
	public Número opera(Número n1, Número n2) {
		return n1.suma(n2);
	}
	
	public static Número opera(List<Número> numeros, Operacion o) {
		Número s = new Complejo();
		for(Número n : numeros) {
			s = o.opera(s, n);
		}
		return s;
	}
	
	public static void main(String[] args) {
		List<Número> lista = new LinkedList<>();
		lista.add(new Doble(5.0));
		lista.add(new Complejo(new Doble(1.0), new Doble(-1.0)));
		lista.add(new Entero(3));
		
		// Implementando la interfaz
		Número suma = opera(lista, new Suma());
		System.out.println("Suma = " + suma);
		
		// Con lambdas
		Número mul = opera(lista, (n1, n2) -> {
			return n1.multiplica(n2);
		});
		System.out.println("Multiplicación = " + mul);
		
		// Truqueando para imprimir
		opera(lista, (n1, n2) -> {System.out.println(n2); return n2; });
	}

}

@FunctionalInterface
interface Operacion {
	public Número opera(Número n1, Número n2);
}