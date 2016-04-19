package util;

public class ConstrutoraNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ConstrutoraNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
