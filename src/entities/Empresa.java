package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import exceptions.DomainExceptions;

public class Empresa {
	
	private String nomeEmpresa;
	private int vagas;
	private HashMap<Integer, ArrayList<Candidato>> candidatosParaVagas = new HashMap<>();
	private int contadorDaVaga1;
	private int contadorDaVaga2;
	private int contadorDaVaga3;
	private int contadorDaVaga4;
	private int contadorDaVaga5;

	public Empresa() {
		candidatosParaVagas.put(1, new ArrayList<>());
		candidatosParaVagas.put(2, new ArrayList<>());
		candidatosParaVagas.put(3, new ArrayList<>());
		candidatosParaVagas.put(4, new ArrayList<>());
		candidatosParaVagas.put(5, new ArrayList<>());
	}

	public Empresa(String nomeEmpresa, int vagas) {
		this.nomeEmpresa = nomeEmpresa;
		this.vagas = vagas;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	public int getContadorDaVaga1() {
		return contadorDaVaga1;
	}
	
	public void setContadorDaVaga1(int contadorDaVaga1) {
		this.contadorDaVaga1 = contadorDaVaga1;
	}
	
	public int getContadorDaVaga2() {
		return contadorDaVaga2;
	}
	
	public void setContadorDaVaga2(int contadorDaVaga2) {
		this.contadorDaVaga2 = contadorDaVaga2;
	}
	
	public int getContadorDaVaga3() {
		return contadorDaVaga3;
	}
	
	public void setContadorDaVaga3(int contadorDaVaga3) {
		this.contadorDaVaga3 = contadorDaVaga3;
	}
	
	public int getContadorDaVaga4() {
		return contadorDaVaga4;
	}
	
	public void setContadorDaVaga4(int contadorDaVaga4) {
		this.contadorDaVaga4 = contadorDaVaga4;
	}
	
	public int getContadorDaVaga5() {
		return contadorDaVaga5;
	}
	
	public void setContadorDaVaga5(int contadorDaVaga5) {
		this.contadorDaVaga5 = contadorDaVaga5;
	}
	
	public void verificarVaga(String numeroDaVaga) {
		if (numeroDaVaga.equals("") || numeroDaVaga == null) {
			throw new DomainExceptions("A vaga é obrigatória. O Cliente não foi adicionado à lista.");
		}
		int numeroDaVagaConvertida = Integer.parseInt(numeroDaVaga);
		if(numeroDaVagaConvertida > 5) {
			throw new DomainExceptions("ERRO: Número da vaga não existe. Tente vagas de 1 a 5.");
		}
		else {
			if(numeroDaVagaConvertida == 1) {
				if(contadorDaVaga1 < 3) {
				contadorDaVaga1 ++;
				}
				else {
					throw new DomainExceptions("Número de candidatos excedidos para a vaga. O máximo permitido é 3.");
				}
			}
			if(numeroDaVagaConvertida == 2) {
				if(contadorDaVaga2 < 3) {
				contadorDaVaga2 ++;
				}
				else {
					throw new DomainExceptions("Número de candidatos excedidos para a vaga. O máximo permitido é 3.");
				}
			}
			if(numeroDaVagaConvertida == 3) {
				if(contadorDaVaga3 < 3) {
				contadorDaVaga3 ++;
				}
				else {
					throw new DomainExceptions("Número de candidatos excedidos para a vaga. O máximo permitido é 3.");
				}
			}
			if(numeroDaVagaConvertida == 4) {
				if(contadorDaVaga4 < 3) {
				contadorDaVaga4 ++;
				}
				else {
					throw new DomainExceptions("Número de candidatos excedidos para a vaga. O máximo permitido é 3.");
				}
			}
			if(numeroDaVagaConvertida == 5) {
				if(contadorDaVaga5 < 3) {
				contadorDaVaga5 ++;
				}
				else {
					throw new DomainExceptions("Número de candidatos excedidos para a vaga. O máximo permitido é 3.");
				}
			}
		}
	}
	
	public HashMap<Integer, ArrayList<Candidato>> getCandidatosParaVagas() {
		return candidatosParaVagas;
	}
	
	public void setCandidatoParaVagas(HashMap<Integer, ArrayList<Candidato>> candidatosParaVagas) {
		this.candidatosParaVagas = candidatosParaVagas;
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


