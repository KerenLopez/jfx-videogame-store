package exceptions;

public class CodeLengthException extends Exception{

	private static final long serialVersionUID = 1;
	
	public CodeLengthException(int i) {
		super("El codigo del juego debe ser de 3 digitos. Usted ingreso "+i+" como valor para dicho atributo dentro del formulario, intentelo nuevamente.");
	}
}
