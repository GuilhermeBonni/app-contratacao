package entities;

import java.util.Objects;

import exceptions.DomainExceptions;

public class Empresa {
	
	private String nomeEmpresa;
	private String vagas;

	public Empresa() {
	}

	public Empresa(String nomeEmpresa, String vagas) {
		this.nomeEmpresa = nomeEmpresa;
		this.vagas = vagas;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getVagas() {
		return vagas;
	}

	public void setVagas(String vagas) {
		this.vagas = vagas;
	}
	
	public void verificarVaga(String vagas) {
		if (vagas.equals("") || vagas == null) {
			throw new DomainExceptions("A vaga é obrigatória. O Cliente não foi adicionado à lista.");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeEmpresa, vagas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(nomeEmpresa, other.nomeEmpresa) && Objects.equals(vagas, other.vagas);
	}
	
}


