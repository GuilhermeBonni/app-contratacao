package exceptions;

import entities.Candidato;

public class DomainExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainExceptions() {
	}
	
	public DomainExceptions(Candidato candidato) {
	}

	public DomainExceptions(String msg) {
		super(msg);
	}

}
