/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package numeros;

/**
 *
 * @author blackzafiro
 */
public final class Complejo extends Número {

	enum Caso {
		REAL, IMAGINARIO_PURO, COMPLEJO;
	}

	/**
	 * Parte real.
	 */
	private Real x;

	/**
	 * Parte imaginaria.
	 */
	private Real y;

	public static Complejo analiza(String s) {
		if (s.equals("i")) {
			return new Complejo(new Entero(0), new Entero(1));
		}
		Caso c;
		if (s.matches("[+-]?[0-9]+(\\.[0-9]+)?")) {
			c = Caso.REAL;
		} else if (s.matches("[+-]?([0-9]+(\\.[0-9]+)?)?i")) {
			c = Caso.IMAGINARIO_PURO;
		} else if (s.matches("[+-]?[0-9]+(\\.[0-9]+)?[+-]([0-9]+(\\.[0-9]+)?)?i")) {
			c = Caso.COMPLEJO;
		} else {
			throw new NumberFormatException("No se reconoció al número complejo");
		}

		int signo;
		if (s.startsWith("+")) {
			signo = 1;
			s = s.substring(1);
		} else if (s.startsWith("-")) {
			signo = -1;
			s = s.substring(1);
		} else {
			signo = 1;
		}

		if (c == Caso.REAL) {
			return new Complejo(((Real) FabricaDeNumeros.analizaReal(s)).multiplica(new Entero(signo)), new Entero(0));
		} else if (c == Caso.IMAGINARIO_PURO) {
			// Hay que quitar la i
			String cim = s.substring(0, s.length() - 1);
			return new Complejo(new Entero(0),
					((Real) FabricaDeNumeros.analizaReal(cim)).multiplica(new Entero(signo)));
		}

		// Si no es ninguno de los anteriores, es un complejo.
		int signoI;
		if (s.contains("+")) {
			signoI = 1;
		} else if (s.contains("-")) {
			signoI = -1;
		} else {
			signoI = 1; // No debería pasar
		}
		String[] partes = s.split("[+-]{1}");
		String cim = partes[1].substring(0, partes[1].length() - 1);
		if (cim.length() == 0) {
			// La i está sola.
			return new Complejo((Real) FabricaDeNumeros.analizaReal(partes[0]).multiplica(new Entero(signo)),
					new Entero(signoI));
		} else {
			return new Complejo((Real) FabricaDeNumeros.analizaReal(partes[0]).multiplica(new Entero(signo)),
					((Real) FabricaDeNumeros.analizaReal(cim)).multiplica(new Entero(signoI)));
		}
	}

	/**
	 * Constructor. Crea un complejo que representa al cero.
	 */
	public Complejo() {
		x = new Doble(0.0);
		y = new Doble(0.0);
	}

	/**
	 * Constructro.
	 *
	 * @param real parte real
	 * @param imaginaria parte imaginaria
	 */
	public Complejo(Real real, Real imaginaria) {
		if (real == null || imaginaria == null) {
			throw new NullPointerException("Un número complejo debe tener parte real e imaginaria.");
		}
		x = real;
		y = imaginaria;
	}

	/**
	 *
	 * @return la parte real.
	 */
	public Real leeReal() {
		return x;
	}

	/**
	 *
	 * @return la parte imaginaria.
	 */
	public Real leeImaginaria() {
		return y;
	}

	/**
	 * Calcula el complejo conjugado de este número.
	 *
	 * @return el complejo conjugado
	 */
	public Complejo conjugado() {
		return new Complejo(x, y.multiplica(new Entero(-1)));
	}

	@Override
	public Complejo suma(Número n) {
		if (n instanceof Complejo) {
			Complejo otro = (Complejo) n;
			return suma(otro);
		} else if (n instanceof Real) {
			return suma((Real) n);
		}
		throw new ConversionNoSoportadaException("Número " + n);
	}

	public Complejo suma(Complejo n) {
		return new Complejo(x.suma(n.x), y.suma(n.y));
	}
	
	public Complejo suma(Real n) {
		return new Complejo(x.suma(n), y);
	}

	@Override
	public Complejo resta(Número n) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Complejo multiplica(Número n) {
		if (n instanceof Complejo) {
			Complejo otro = (Complejo) n;
			return multiplica(otro);
		} else if (n instanceof Doble) {
			Doble otro = (Doble) n;
			return multiplica(otro);
		} else if (n instanceof Entero) {
			Entero otro = (Entero) n;
			return multiplica(otro);
		} else {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	}

	public Complejo multiplica(Complejo n) {
		return new Complejo(x.multiplica(n.x).resta(y.multiplica(n.y)),
				x.multiplica(n.y).suma(y.multiplica(n.x)));
	}

	public Complejo multiplica(Doble n) {
		return new Complejo(x.multiplica(n), y);
	}

	public Complejo multiplica(Entero n) {
		return new Complejo(x.multiplica(n), y);
	}

	@Override
	public Complejo divide(Número n) throws ArithmeticException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String representaciónBinaria() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	/**
	 * Representación en cadena de este número.
	 *
	 * @return representación en cadena de este número.
	 */
	public String toString() {
		String signo = (y.compareTo(new Entero(0)) < 0) ? "" : "+";
		return x.toString() + signo + y.toString() + "i";
	}
}
